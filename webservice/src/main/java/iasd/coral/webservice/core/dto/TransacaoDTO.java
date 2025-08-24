package iasd.coral.webservice.core.dto;

import iasd.coral.webservice.core.model.Crianca;
import lombok.Builder;

@Builder
public record TransacaoDTO(Crianca crianca, Integer quantidade, String descricao, Long responsavelId) {
}
