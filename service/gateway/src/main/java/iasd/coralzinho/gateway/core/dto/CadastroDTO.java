package iasd.coralzinho.gateway.core.dto;

import java.util.List;

public record CadastroDTO(
        String nome,
        String sobrenome,
        String email,
        String telefone,
        String senha,
        List<FilhoDTO> filhos){
}
