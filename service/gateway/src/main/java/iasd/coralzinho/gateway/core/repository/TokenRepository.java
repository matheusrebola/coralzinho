package iasd.coralzinho.gateway.core.repository;

import iasd.coralzinho.gateway.core.document.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends MongoRepository<Token,String> {
    Boolean findByEmail(String email);

    Boolean findByToken(String token);
}
