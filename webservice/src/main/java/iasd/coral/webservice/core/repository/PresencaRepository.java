package iasd.coral.webservice.core.repository;

import iasd.coral.webservice.core.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
    List<Presenca> findByCriancaId(Long criancaId);
    List<Presenca> findByCriancaIdAndDataHoraBetween(Long criancaId, LocalDateTime inicio, LocalDateTime fim);
    boolean existsByCriancaIdAndDataHoraBetween(Long criancaId, LocalDateTime inicio, LocalDateTime fim);
}
