package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.mapper.TokenMapper;
import iasd.coralzinho.gateway.core.consumer.AutenticacaoConsumer;
import iasd.coralzinho.gateway.core.dto.CadastroReq;
import iasd.coralzinho.gateway.core.dto.LoginReq;
import iasd.coralzinho.gateway.core.dto.LoginRes;
import iasd.coralzinho.gateway.core.producer.AutenticacaoProducer;
import iasd.coralzinho.gateway.core.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final AutenticacaoProducer producer;
    private final AutenticacaoConsumer consumer;
    private final TokenService service;
    private final TokenMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginReq req) {
        try {
            producer.efetuarLogin(req);
            return new ResponseEntity<>(consumer.loginEfetuado(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<LoginRes> cadastrar(@RequestBody CadastroReq req) {
        try{
            producer.cadastrarUsuario(req);
            var login = consumer.cadastroEfetuado();
            service.registrarToken(mapper.mapear(login.getToken(), login.getEmail()));
            return new ResponseEntity<>(consumer.cadastroEfetuado(), HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
