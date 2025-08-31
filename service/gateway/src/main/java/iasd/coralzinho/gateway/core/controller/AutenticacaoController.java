package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.AutenticacaoConsumer;
import iasd.coralzinho.gateway.core.dto.CadastroDTO;
import iasd.coralzinho.gateway.core.dto.LoginDTO;
import iasd.coralzinho.gateway.core.producer.AutenticacaoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final AutenticacaoProducer autenticacaoProducer;
    private final AutenticacaoConsumer autenticacaoConsumer;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        //TODO: criar lógica de login
        return null;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDTO dto) {
        //TODO: criar lógica de cadastro
        return null;
    }
}
