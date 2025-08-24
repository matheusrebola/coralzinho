package iasd.coral.webservice.core.mapper;

import iasd.coral.webservice.core.dto.TransacaoDTO;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.TransacaoTonzinho;
import iasd.coral.webservice.core.model.enums.TipoTransacao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface TransacaoTonzinhoMapper {
    default TransacaoTonzinho mapear(TransacaoDTO dto){
        return TransacaoTonzinho.builder()
                .crianca(dto.crianca())
                .tipo(TipoTransacao.GANHO)
                .quantidade(dto.quantidade())
                .descricao(dto.descricao())
                .dataHora(LocalDateTime.now())
                .build();
    }
}
