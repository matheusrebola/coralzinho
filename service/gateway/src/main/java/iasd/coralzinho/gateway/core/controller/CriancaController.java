package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.CriancaConsumer;
import iasd.coralzinho.gateway.core.dto.FilhoDTO;
import iasd.coralzinho.gateway.core.producer.CriancaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/criancas")
@RequiredArgsConstructor
public class CriancaController {
    private final CriancaProducer criancaProducer;
    private final CriancaConsumer criancaConsumer;

    @PostMapping
    public ResponseEntity<?> adicionarFilho(@RequestBody FilhoDTO dto) {
        //TODO: criar lógica de adicionar filho
        return null;
    }

    @PutMapping
    public ResponseEntity<?> atualizarFilho(@RequestBody FilhoDTO dto) {
        //TODO: criar lógica de atualizar filho
        return null;
    }

    @GetMapping("/minhas")
    public ResponseEntity<?> listarFilhos(@PathVariable Long idPai) {
        //TODO: criar lógica de trazer todos os filhos
        return null;
    }

}
