package iasd.coralzinho.gateway.core.service;

import iasd.coralzinho.gateway.core.document.Token;
import iasd.coralzinho.gateway.core.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository repository;

    public Token registrarToken(Token token) {
        return salvar(token);
    }

    private Token salvar(Token token){
        return repository.save(token);
    }

    public Boolean validarToken(Token token){
        return (emailValido(token.getEmail()).equals(true) && tokenValido(token.getToken()).equals(true));
    }

    private Boolean emailValido(String email){
        return repository.findByEmail(email);
    }

    private Boolean tokenValido(String token){
        return repository.findByToken(token);
    }

}
