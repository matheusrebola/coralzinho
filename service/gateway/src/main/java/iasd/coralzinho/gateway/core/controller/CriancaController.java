package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.CriancaConsumer;
import iasd.coralzinho.gateway.core.dto.CadastroRes;
import iasd.coralzinho.gateway.core.dto.Filho;
import iasd.coralzinho.gateway.core.dto.FilhoRes;
import iasd.coralzinho.gateway.core.producer.CriancaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criancas")
@RequiredArgsConstructor
public class CriancaController {
    private final CriancaProducer criancaProducer;
    private final CriancaConsumer criancaConsumer;

    @PostMapping("/{id}")
    public ResponseEntity<CadastroRes> adicionarFilho(@RequestBody Filho dto, @PathVariable Long id) {
        //TODO: criar lógica de adicionar filho
        try {
            Boolean isAdicionado = criancaProducer.adicionarFilho(dto, id);
            if (isAdicionado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(criancaConsumer.filhoAdicionado(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<CadastroRes> atualizarFilho(@RequestBody Filho dto, @PathVariable Long id) {
        //TODO: criar lógica de atualizar filho
        try {
            Boolean isAdicionado = criancaProducer.atualizarFilho(dto, id);
            if (isAdicionado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(criancaConsumer.filhoAtualizado(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<FilhoRes>> listarFilhos(@PathVariable Long id) {
        try {
            Boolean isAdicionado = criancaProducer.buscarFilhos(id);
            if (isAdicionado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(criancaConsumer.filhosBuscados(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

}
