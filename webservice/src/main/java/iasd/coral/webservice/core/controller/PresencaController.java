package iasd.coral.webservice.core.controller;

import iasd.coral.webservice.core.dto.PresencaDTO;
import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.service.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/presenca")
@CrossOrigin(origins = "*")
public class PresencaController {
    @Autowired
    private PresencaService presencaService;

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
    public ResponseEntity<?> registrarPresenca(@RequestBody PresencaDTO presencaDTO) {
        Presenca presenca = presencaService.registrarPresenca(
                presencaDTO.getCriancaId(),
                getCurrentUserId()
        );
        return ResponseEntity.ok(presenca);
    }

    @GetMapping("/qrcode")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
    public ResponseEntity<?> gerarQRCode() {
        String qrCode = qrCodeService.generatePresencaQRCode(getCurrentUserId());
        return ResponseEntity.ok(Map.of("qrCode", qrCode));
    }
}
