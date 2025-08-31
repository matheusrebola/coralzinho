package iasd.coralzinho.gateway.core.document;

import iasd.coralzinho.gateway.core.document.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logins")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Login {
    @Id
    private String email;
    private String nome;
    private String senha;
    private String token;
    private TipoUsuario tipo;
}
