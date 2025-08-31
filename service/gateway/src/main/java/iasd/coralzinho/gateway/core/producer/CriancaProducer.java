package iasd.coralzinho.gateway.core.producer;

import iasd.coralzinho.gateway.core.dto.Filho;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CriancaProducer {
    public void adicionarFilho(Filho dto, Long id) {
        //TODO: Criar lógica de adicionar filho
    }

    public void atualizarFilho(Filho dto, Long id) {
        //TODO: Criar lógica de atualizar filho
    }

    public void buscarFilhos(Long id) {
        //TODO: Criar lógica de buscar filhos
    }
}
