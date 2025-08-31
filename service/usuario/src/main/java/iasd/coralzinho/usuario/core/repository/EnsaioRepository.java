package iasd.coralzinho.usuario.core.repository;

import iasd.coralzinho.usuario.core.model.Ensaio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EnsaioRepository extends JpaRepository<Ensaio,Long> {
    Ensaio findByData(LocalDate agora);
}
