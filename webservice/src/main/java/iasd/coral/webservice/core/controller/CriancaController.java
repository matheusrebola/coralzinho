package iasd.coral.webservice.core.controller;

import iasd.coral.webservice.core.dto.CriancaDTO;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.service.CriancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/criancas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CriancaController {
    private final CriancaService criancaService;

    @PostMapping
    @PreAuthorize("hasRole('PAI')")
    public ResponseEntity<?> adicionarFilho(@RequestBody CriancaDTO criancaDTO, Principal principal) {
        Crianca crianca = criancaService.adicionarFilho(criancaDTO, principal.getName());
        return ResponseEntity.ok(crianca);
    }

    @GetMapping("/minhas")
    @PreAuthorize("hasRole('PAI')")
    public ResponseEntity<?> listarFilhos(Principal principal) {
        List<CriancaDTO> filhos = criancaService.listarFilhos(principal.getName());
        return ResponseEntity.ok(filhos);
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<?> consultarSaldo(@PathVariable Long id) {
        Integer saldo = criancaService.consultarSaldo(id);
        return ResponseEntity.ok(Map.of("saldo", saldo));
    }
}
