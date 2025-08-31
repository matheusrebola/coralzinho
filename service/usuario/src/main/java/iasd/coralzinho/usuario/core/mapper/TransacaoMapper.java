package iasd.coralzinho.usuario.core.mapper;

import iasd.coralzinho.usuario.core.dto.TransacaoDTO;
import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Transacao;
import iasd.coralzinho.usuario.core.model.Usuario;
import iasd.coralzinho.usuario.core.model.enums.TipoTransacao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransacaoMapper {
    public Transacao mapear(TransacaoDTO dto){
        return Transacao.builder()
                .crianca(dto.crianca())
                .tipo(dto.tipo())
                .quantidade(dto.quantidade())
                .dataHora(LocalDateTime.now())
                .responsavel(dto.responsavel())
                .build();
    }

    public TransacaoDTO mapear(Crianca crianca, TipoTransacao tipo, Integer quantidade, Usuario responsavel){
        return TransacaoDTO.builder()
                .crianca(crianca)
                .tipo(tipo)
                .quantidade(quantidade)
                .responsavel(responsavel)
                .build();
    }
}
