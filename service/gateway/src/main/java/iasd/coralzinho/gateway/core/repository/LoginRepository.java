package iasd.coralzinho.gateway.core.repository;

import iasd.coralzinho.gateway.core.document.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<Login,String> {
    Login findByEmail(String email);
}
