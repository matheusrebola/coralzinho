package iasd.coralzinho.gateway.core.mapper;

import iasd.coralzinho.gateway.core.document.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {
    public Token mapear(String token, String email){
        return Token.builder()
                .token(token)
                .email(email)
                .build();
    }
}
