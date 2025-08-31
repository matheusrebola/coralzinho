package iasd.coralzinho.gateway.core.dto;

import java.util.List;

public record CadastroReq(
        String nome,
        String sobrenome,
        String email,
        String telefone,
        String senha,
        List<Filho> filhos){
}
