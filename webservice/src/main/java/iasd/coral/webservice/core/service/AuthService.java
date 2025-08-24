package iasd.coral.webservice.core.service;

import iasd.coral.webservice.config.security.JwtUtil;
import iasd.coral.webservice.core.dto.CadastroDTO;
import iasd.coral.webservice.core.dto.LoginDTO;
import iasd.coral.webservice.core.mapper.UsuarioMapper;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.model.enums.TipoUsuario;
import iasd.coral.webservice.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private JwtUtil jwtUtil;

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
