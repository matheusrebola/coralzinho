package iasd.coral.webservice.core.controller;

import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.service.CriancaService;
import iasd.coral.webservice.core.service.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/professor")
@PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
@CrossOrigin(origins = "*")
public class ProfessorController {

    @Autowired
    private CriancaRepository criancaRepository;

    @Autowired
    private PresencaService presencaService;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard() {
        // Retorna estatísticas gerais
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalCriancas", criancaRepository.count());
        stats.put("presentesHoje", presencaService.getPresentesHoje());
        stats.put("aniversariantes", criancaService.getAniversariantesDoMes());
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/criancas")
    public ResponseEntity<?> listarTodasCriancas() {
        return ResponseEntity.ok(criancaRepository.findAll());
    }
}
