package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.AutenticacaoConsumer;
import iasd.coralzinho.gateway.core.document.Login;
import iasd.coralzinho.gateway.core.dto.CadastroReq;
import iasd.coralzinho.gateway.core.dto.CadastroRes;
import iasd.coralzinho.gateway.core.dto.LoginReq;
import iasd.coralzinho.gateway.core.mapper.AutenticacaoMapper;
import iasd.coralzinho.gateway.core.producer.AutenticacaoProducer;
import iasd.coralzinho.gateway.core.service.AutenticacaoService;
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
    private final AutenticacaoMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody LoginReq req) {
        try {
            Boolean isAutenticado = producer.efetuarLogin(req);
            if (isAutenticado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<CadastroRes> cadastrar(@RequestBody CadastroReq req) {
        try{
            Boolean isCadastrado = producer.cadastrarUsuario(req);
            if (isCadastrado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(consumer.cadastroEfetuado(), HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
