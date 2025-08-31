package iasd.coralzinho.gateway.core.document;

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
public class Token {
    @Id
    private String email;
    private String token;
}
