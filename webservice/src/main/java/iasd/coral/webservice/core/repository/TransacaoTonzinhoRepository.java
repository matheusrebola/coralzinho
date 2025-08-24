package iasd.coral.webservice.core.repository;

import iasd.coral.webservice.core.model.TransacaoTonzinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoTonzinhoRepository extends JpaRepository<TransacaoTonzinho,Long> {
}
