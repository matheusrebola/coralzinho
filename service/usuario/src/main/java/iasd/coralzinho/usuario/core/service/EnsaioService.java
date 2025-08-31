package iasd.coralzinho.usuario.core.service;

import iasd.coralzinho.usuario.core.model.Ensaio;
import iasd.coralzinho.usuario.core.repository.EnsaioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EnsaioService {
    private final EnsaioRepository repository;

    public Ensaio encontrarPelaData(LocalDate agora) {
        return repository.findByData(agora);
    }
}
