package iasd.coralzinho.usuario.core.dto;

import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Usuario;
import iasd.coralzinho.usuario.core.model.enums.TipoTransacao;
import lombok.Builder;

@Builder
public record TransacaoDTO(Crianca crianca, TipoTransacao tipo, Integer quantidade, String descricao, Usuario responsavel) {
}
