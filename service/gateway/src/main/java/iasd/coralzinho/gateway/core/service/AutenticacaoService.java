package iasd.coralzinho.gateway.core.service;

import iasd.coralzinho.gateway.core.document.Login;
import iasd.coralzinho.gateway.core.dto.LoginReq;
import iasd.coralzinho.gateway.core.dto.LoginRes;
import iasd.coralzinho.gateway.core.dto.PaiRes;
import iasd.coralzinho.gateway.core.mapper.AutenticacaoMapper;
import iasd.coralzinho.gateway.core.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
    private final LoginRepository repository;
    private AutenticacaoMapper mapper;

    public Login registrarLogin(Login login) {
        return salvar(login);
    }

    private Login salvar(Login login){
        return repository.save(login);
    }

    public LoginRes efetuarLogin(LoginReq req) {
        return null;
    }

    private Login buscarLogin(String email){
        return repository.findByEmail(email);
    }
}
