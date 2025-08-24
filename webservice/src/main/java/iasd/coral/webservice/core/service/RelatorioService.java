package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.PresencaRepository;
import iasd.coral.webservice.core.repository.TransacaoTonzinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelatorioService {
    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private CriancaRepository criancaRepository;

    @Autowired
    private TransacaoTonzinhoRepository transacaoRepository;

    public Map<String, Object> gerarEstatisticasGerais() {
        Map<String, Object> stats = new HashMap<>();

        // Total de crianças ativas
        stats.put("totalCriancasAtivas", criancaRepository.countByAtivo(true));

        // Presença do mês
        LocalDateTime inicioMes = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime fimMes = LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay();
        stats.put("presencasNoMes", presencaRepository.countByDataHoraBetween(inicioMes, fimMes));

        // Aniversariantes do mês
        //stats.put("aniversariantesDoMes", getAniversariantesDoMes());

        // Total de tonzinhos em circulação
        stats.put("totalTonzinhosEmCirculacao", criancaRepository.sumTotalTonzinhos());

        return stats;
    }

    public List<Map<String, Object>> gerarRelatorioPresenca(Long criancaId, LocalDate inicio, LocalDate fim) {
        List<Presenca> presencas = presencaRepository.findByCriancaIdAndDataHoraBetween(
                criancaId,
                inicio.atStartOfDay(),
                fim.plusDays(1).atStartOfDay()
        );

        return presencas.stream().map(p -> {
            Map<String, Object> item = new HashMap<>();
            item.put("data", p.getDataHora());
            item.put("tonzinhosGanhos", p.getTonzinhosGanhos());
            item.put("professor", p.getProfessor().getNome());
            return item;
        }).collect(Collectors.toList());
    }
}
