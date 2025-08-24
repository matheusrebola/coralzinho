package iasd.coral.webservice.core.dto;

import lombok.Data;

@Data
public class CadastroDTO {
    private String email;
    private String senha;
    private String nome;
    private String telefone;
}
