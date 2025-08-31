package iasd.coralzinho.gateway.core.consumer;

import iasd.coralzinho.gateway.core.dto.CadastroRes;
import iasd.coralzinho.gateway.core.dto.FilhoRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CriancaConsumer {
    public CadastroRes filhoAdicionado() {
        //TODO: Criar lógica de adicionar filho
        return null;
    }

    public CadastroRes filhoAtualizado() {
        //TODO: Criar lógica de atualizar filho
        return null;
    }

    public List<FilhoRes> filhosBuscados() {
        //TODO: Criar lógica de buscar filho
        return null;
    }
}
