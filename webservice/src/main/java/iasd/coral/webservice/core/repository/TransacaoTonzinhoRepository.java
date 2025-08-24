package iasd.coral.webservice.core.repository;

import iasd.coral.webservice.core.model.TransacaoTonzinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoTonzinhoRepository extends JpaRepository<TransacaoTonzinho,Long> {
    List<TransacaoTonzinho> findByCriancaIdOrderByDataHoraDesc(Long criancaId);

    @Query(value = "SELECT * FROM transacoes_tonzinhos WHERE crianca_id = ?1 " +
            "AND data_hora BETWEEN ?2 AND ?3 ORDER BY data_hora DESC", nativeQuery = true)
    List<TransacaoTonzinho> findByCriancaIdAndPeriodo(Long criancaId, LocalDateTime inicio, LocalDateTime fim);
}
