package iasd.coral.webservice.core.controller;

import iasd.coral.webservice.core.dto.CadastroDTO;
import iasd.coral.webservice.core.dto.LoginDTO;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDTO cadastroDTO) {
        Usuario usuario = authService.cadastrar(cadastroDTO);
        return ResponseEntity.ok(usuario);
    }
}
