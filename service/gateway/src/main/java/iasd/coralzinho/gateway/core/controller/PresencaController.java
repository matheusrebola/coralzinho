package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.PresencaConsumer;
import iasd.coralzinho.gateway.core.dto.FilhoRes;
import iasd.coralzinho.gateway.core.producer.PresencaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presenca")
@RequiredArgsConstructor
public class PresencaController {
    private final PresencaProducer presencaProducer;
    private final PresencaConsumer presencaConsumer;

    @PostMapping("/registrar/{id}")
    public ResponseEntity<FilhoRes> registrarPresenca(@PathVariable Long id) {
        try {
            Boolean isRegistrado = presencaProducer.registrarPresenca(id);
            if (isRegistrado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(presencaConsumer.presencaRegistrada(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

}
