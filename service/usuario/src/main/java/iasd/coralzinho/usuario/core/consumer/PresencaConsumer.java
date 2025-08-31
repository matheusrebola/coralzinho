package iasd.coralzinho.usuario.core.consumer;

import iasd.coralzinho.usuario.core.mapper.PresencaMapper;
import iasd.coralzinho.usuario.core.mapper.TransacaoMapper;
import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.enums.TipoTransacao;
import iasd.coralzinho.usuario.core.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PresencaConsumer {
    private final PresencaService presencaService;
    private final EnsaioService ensaioService;
    private final UsuarioService usuarioService;
    private final TransacaoService transacaoService;
    private final CriancaService criancaService;
    private final TransacaoMapper transacaoMapper;
    private final PresencaMapper presencaMapper;

    private int calcularPontos(final LocalTime agora, final LocalTime horaEnsaio) {
        final int cmp = agora.compareTo(horaEnsaio);
        if (cmp < 0) return 30;   // antes
        if (cmp == 0) return 20;  // na hora
        return 10;                // depois
    }

    private int registrarTransacao(final Crianca crianca, final int pontos) {
        var dto = transacaoMapper.mapear(crianca, TipoTransacao.GANHO, pontos, crianca.getPai());
        var mapped = transacaoMapper.mapear(dto);
        transacaoService.salvar(mapped);
        return pontos;
    }

    public void registrarPresenca(Long criancaId, Long professorId) {
        final LocalDate hoje  = LocalDate.now();
        final LocalTime agora = LocalTime.now();

        var ensaio = Objects.requireNonNull(
                ensaioService.encontrarPelaData(hoje),
                "Ensaio não encontrado para a data de hoje"
        );
        var horaEnsaio = Objects.requireNonNull(
                ensaio.getHora(),
                "Hora do ensaio não definida"
        );

        var crianca = Objects.requireNonNull(
                criancaService.encontrarPeloId(criancaId),
                "Criança não encontrada"
        );
        var professor = Objects.requireNonNull(
                usuarioService.encontrarPeloId(professorId),
                "Professor não encontrado"
        );

        final int pontos = calcularPontos(agora, horaEnsaio);
        registrarTransacao(crianca, pontos);

        var presenca = presencaMapper.mapear(crianca, professor, pontos);
        presencaService.salvar(presenca);
    }

}
