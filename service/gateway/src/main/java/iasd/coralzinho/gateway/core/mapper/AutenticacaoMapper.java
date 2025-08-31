package iasd.coralzinho.gateway.core.mapper;

import iasd.coralzinho.gateway.core.document.Login;
import iasd.coralzinho.gateway.core.dto.PaiRes;
import iasd.coralzinho.gateway.core.dto.ProfessorRes;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoMapper {

    public Login mapear(String email, String token) {
        return Login.builder()
                .email(email)
                .token(token)
                .build();
    }

    public PaiRes mapearPai(Login login) {
        return PaiRes.builder()
                .nome(login.getNome())
                .token(login.getToken())
                .email(login.getEmail())
                .build();
    }

    public ProfessorRes mapearProfessor(Login login) {
    }
}
