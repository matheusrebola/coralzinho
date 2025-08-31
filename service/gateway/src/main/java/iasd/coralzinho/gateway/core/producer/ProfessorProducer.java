package iasd.coralzinho.gateway.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProfessorProducer {


    public Boolean buscarAniversariantes(int monthValue, Long id) {
        //TODO: Criar lógica de buscar aniversariantes
        return null;
    }

    public Boolean atualizarHorario(LocalDate horario) {
        //TODO: Criar lógica de atualizar horario
        return null;
    }

    public Boolean criarQRCode(Short valor) {
        //TODO: Criar lógica de criar qrcode
        return null;
    }
}
