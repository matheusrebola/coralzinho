package iasd.coral.webservice.core.service;

import iasd.coral.webservice.config.security.JwtUtil;
import iasd.coral.webservice.core.dto.CadastroDTO;
import iasd.coral.webservice.core.dto.LoginDTO;
import iasd.coral.webservice.core.mapper.UsuarioMapper;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;
    private final JwtUtil jwtUtil;

    public String login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(loginDTO.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        return jwtUtil.generateToken(usuario.getEmail(), usuario.getTipo().toString());
    }

    public Usuario cadastrar(CadastroDTO cadastroDTO) {
        if (usuarioRepository.existsByEmail(cadastroDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return usuarioRepository.save(mapper.mapear(cadastroDTO));
    }
}
