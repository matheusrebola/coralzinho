package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.PresencaConsumer;
import iasd.coralzinho.gateway.core.producer.PresencaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presenca")
@RequiredArgsConstructor
public class PresencaController {
    private final PresencaProducer presencaProducer;
    private final PresencaConsumer presencaConsumer;

    @PostMapping("/registrar/{id}")
    public ResponseEntity<?> registrarPresenca(@PathVariable Long id) {
        //TODO: criar lógica de registrar presença
        return null;
    }

}
