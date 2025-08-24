package iasd.coral.webservice.core.mapper;

import iasd.coral.webservice.core.dto.TransacaoDTO;
import iasd.coral.webservice.core.model.Crianca;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {
    public TransacaoDTO mapear(Crianca crianca, Integer quantidade, String descricao, Long responsavelId){
        return TransacaoDTO.builder()
                .crianca(crianca)
                .quantidade(quantidade)
                .descricao(descricao)
                .responsavelId(responsavelId)
                .build();
    }
}
