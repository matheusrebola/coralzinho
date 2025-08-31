package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.ProfessorConsumer;
import iasd.coralzinho.gateway.core.dto.Aluno;
import iasd.coralzinho.gateway.core.dto.Horario;
import iasd.coralzinho.gateway.core.dto.QRCodeRes;
import iasd.coralzinho.gateway.core.producer.ProfessorProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorProducer professorProducer;
    private final ProfessorConsumer professorConsumer;

    @GetMapping("/criancas/{id}")
    public ResponseEntity<List<Aluno>> listarAniversariantes(@PathVariable Long id) {
        try {
            Boolean isBuscado = professorProducer.buscarAniversariantes(LocalDateTime.now().getMonthValue(), id);
            if (isBuscado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(professorConsumer.aniversariantesDoMes(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<?> definirHorario(@RequestBody Horario horario) {
        try {
            Boolean isAtualizado = professorProducer.atualizarHorario(horario);
            if (isAtualizado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    //valor é quantidade de tonzinhos
    @PostMapping("/qrcode/{valor}")
    public ResponseEntity<QRCodeRes> criarQRCode(@PathVariable Short valor) {
        try {
            Boolean isCriado = professorProducer.criarQRCode(valor);
            if (isCriado.equals(false)){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(professorConsumer.retornarQRCode(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
