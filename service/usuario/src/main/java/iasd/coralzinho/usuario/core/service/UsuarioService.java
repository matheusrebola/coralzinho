package iasd.coralzinho.usuario.core.service;

import iasd.coralzinho.usuario.core.model.Usuario;
import iasd.coralzinho.usuario.core.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario encontrarPeloId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
