package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.ProfessorConsumer;
import iasd.coralzinho.gateway.core.producer.ProfessorProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorProducer professorProducer;
    private final ProfessorConsumer professorConsumer;

    @GetMapping("/criancas")
    public ResponseEntity<?> listarAniversariantes() {
        //TODO: criar lógica de buscar aniversariantes do mês
        return null;
    }

    @PutMapping
    public ResponseEntity<?> definirHorario() {
        //TODO: criar lógica de atualizar horário ensaio
        return null;
    }

    @PostMapping
    public ResponseEntity<?> criarQRCode() {
        //TODO: criar lógica de buscar aniversariantes do mês
        return null;
    }
}
