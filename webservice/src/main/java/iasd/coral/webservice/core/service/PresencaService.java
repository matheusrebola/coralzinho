package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.mapper.PresencaMapper;
import iasd.coral.webservice.core.mapper.TransacaoMapper;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.PresencaRepository;
import iasd.coral.webservice.core.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PresencaService {
    private final PresencaRepository presencaRepository;
    private final CriancaRepository criancaRepository;
    private final TransacaoService transacaoService;
    private final PresencaMapper presencaMapper;
    private final TransacaoMapper transacaoMapper;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Presenca registrarPresenca(Long criancaId, Long professorId) {
        // Verifica se já foi registrada presença hoje
        LocalDateTime inicioDia = LocalDate.now().atStartOfDay();
        LocalDateTime fimDia = inicioDia.plusDays(1);

        if (presencaRepository.existsByCriancaIdAndDataHoraBetween(criancaId, inicioDia, fimDia)) {
            throw new RuntimeException("Presença já registrada hoje");
        }

        Crianca crianca = criancaRepository.findById(criancaId)
                .orElseThrow(() -> new RuntimeException("Criança não encontrada"));

        Usuario professor = usuarioRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrada"));

        transacaoService.adicionarTonzinhos(transacaoMapper.mapear(crianca, 10, "Presença no ensaio", professorId));

        return presencaRepository.save(presencaMapper.mapear(crianca, professor));
    }

    public List<String> getPresentesHoje() {
        return presencaMapper.mapear(presencaRepository.findCriancaByDataHora(LocalDate.now()));
    }
}
