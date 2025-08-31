package iasd.coralzinho.gateway.core.controller;

import iasd.coralzinho.gateway.core.consumer.ProfessorConsumer;
import iasd.coralzinho.gateway.core.document.Token;
import iasd.coralzinho.gateway.core.dto.Aluno;
import iasd.coralzinho.gateway.core.dto.QRCodeRes;
import iasd.coralzinho.gateway.core.producer.ProfessorProducer;
import iasd.coralzinho.gateway.core.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorProducer professorProducer;
    private final ProfessorConsumer professorConsumer;
    private final TokenService service;

    @GetMapping("/criancas/{id}")
    public ResponseEntity<List<Aluno>> listarAniversariantes(@PathVariable Long id, @RequestBody Token token) {
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            professorProducer.buscarAniversariantes(LocalDateTime.now().getMonthValue(), id);
            return new ResponseEntity<>(professorConsumer.aniversariantesDoMes(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{hora}")
    public ResponseEntity<?> definirHorario(@PathVariable LocalDate horario, @RequestBody Token token) {
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            professorProducer.atualizarHorario(horario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    //valor é quantidade de tonzinhos
    @PostMapping("/qrcode/{valor}")
    public ResponseEntity<QRCodeRes> criarQRCode(@PathVariable Short valor, @RequestBody Token token) {
        try {
            if (service.validarToken(token).equals(false)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            professorProducer.criarQRCode(valor);
            return new ResponseEntity<>(professorConsumer.retornarQRCode(), HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
