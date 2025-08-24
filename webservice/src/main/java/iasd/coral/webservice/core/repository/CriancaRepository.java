package iasd.coral.webservice.core.repository;

import iasd.coral.webservice.core.model.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {
    List<Crianca> findByPaiId(Long paiId);

    @Query("SELECT c FROM Crianca c WHERE MONTH(c.dataNascimento) = ?1")
    List<Crianca> findAniversariantesDoMes(int mes);
}
