package iasd.coralzinho.usuario.core.repository;

import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
    List<Presenca> findByCriancaId(Long criancaId);
    List<Presenca> findByCriancaIdAndDataHoraBetween(Long criancaId, LocalDateTime inicio, LocalDateTime fim);
    boolean existsByCriancaIdAndDataHoraBetween(Long criancaId, LocalDateTime inicio, LocalDateTime fim);
    Object countByDataHoraBetween(LocalDateTime inicioMes, LocalDateTime fimMes);
    List<Crianca> findCriancaByDataHora(LocalDate data);
}
