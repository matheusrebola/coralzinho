package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.PresencaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PresencaService {
    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private CriancaRepository criancaRepository;

    @Autowired
    private TransacaoService transacaoService;

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

        // Registra presença
        Presenca presenca = new Presenca();
        presenca.setCrianca(crianca);
        presenca.setProfessor(new Usuario()); // Buscar professor pelo ID
        presenca.setDataHora(LocalDateTime.now());
        presenca.setTonzinhosGanhos(10); // Valor padrão

        presenca = presencaRepository.save(presenca);

        // Adiciona tonzinhos
        transacaoService.adicionarTonzinhos(crianca, 10, "Presença no ensaio", professorId);

        return presenca;
    }
}
