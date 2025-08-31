package iasd.coralzinho.usuario.core.service;

import iasd.coralzinho.usuario.core.model.Presenca;
import iasd.coralzinho.usuario.core.repository.PresencaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresencaService {
    private final PresencaRepository repository;

    @Transactional
    public Presenca salvar(Presenca presenca) {
        return repository.save(presenca);
    }
}
