package iasd.coralzinho.gateway.core.service;

import iasd.coralzinho.gateway.core.document.Token;
import iasd.coralzinho.gateway.core.dto.LoginReq;
import iasd.coralzinho.gateway.core.dto.LoginRes;
import iasd.coralzinho.gateway.core.mapper.AutenticacaoMapper;
import iasd.coralzinho.gateway.core.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
    private final TokenRepository repository;
    private AutenticacaoMapper mapper;

    public Token registrarToken(Token token) {
        return salvar(token);
    }

    private Token salvar(Token token){
        return repository.save(token);
    }

}
