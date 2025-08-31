package iasd.coralzinho.gateway.core.consumer;

import iasd.coralzinho.gateway.core.dto.Aluno;
import iasd.coralzinho.gateway.core.dto.QRCodeRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProfessorConsumer {
    public List<Aluno> aniversariantesDoMes() {
        //TODO: Criar lógica de buscar aniversariantes
        return null;
    }

    public QRCodeRes retornarQRCode() {
        //TODO: Criar lógica de retornar qrcode
        return null;
    }
}
