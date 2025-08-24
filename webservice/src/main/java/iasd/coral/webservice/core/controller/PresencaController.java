package iasd.coral.webservice.core.controller;

import iasd.coral.webservice.core.dto.PresencaDTO;
import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.service.PresencaService;
import iasd.coral.webservice.core.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/presenca")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PresencaController {
    private final PresencaService presencaService;
    private final QRCodeService qrCodeService;

    @PostMapping("/registrar/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
    public ResponseEntity<?> registrarPresenca(@RequestBody PresencaDTO presencaDTO, @PathVariable Long id) {
        Presenca presenca = presencaService.registrarPresenca(
                presencaDTO.getCriancaId(),
                id
        );
        return ResponseEntity.ok(presenca);
    }

    @GetMapping("/qrcode/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
    public ResponseEntity<?> gerarQRCode(@PathVariable Long id) throws Exception {
        String qrCode = qrCodeService.generatePresencaQRCode(id);
        return ResponseEntity.ok(Map.of("qrCode", qrCode));
    }
}
