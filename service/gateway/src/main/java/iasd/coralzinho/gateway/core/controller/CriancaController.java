package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.CriancaConsumer;
import iasd.coralzinho.gateway.core.document.Token;
import iasd.coralzinho.gateway.core.dto.CadastroRes;
import iasd.coralzinho.gateway.core.dto.Filho;
import iasd.coralzinho.gateway.core.dto.FilhoRes;
import iasd.coralzinho.gateway.core.producer.CriancaProducer;
import iasd.coralzinho.gateway.core.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criancas")
@RequiredArgsConstructor
public class CriancaController {
    private final CriancaProducer producer;
    private final CriancaConsumer consumer;
    private final TokenService service;

    @PostMapping
    public ResponseEntity<CadastroRes> adicionarFilho(@RequestBody Filho dto,
                                                      @RequestBody Token token,
                                                      @PathVariable Long id) {
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            producer.adicionarFilho(dto, id);
            return new ResponseEntity<>(consumer.filhoAdicionado(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<CadastroRes> atualizarFilho(@RequestBody Filho dto,
                                                      @RequestBody Token token,
                                                      @PathVariable Long id) {
        //TODO: criar lógica de atualizar filho
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            producer.atualizarFilho(dto, id);
            return new ResponseEntity<>(consumer.filhoAtualizado(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<FilhoRes>> listarFilhos(@PathVariable Long id, @RequestBody Token token) {
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            producer.buscarFilhos(id);
            return new ResponseEntity<>(consumer.filhosBuscados(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

}
