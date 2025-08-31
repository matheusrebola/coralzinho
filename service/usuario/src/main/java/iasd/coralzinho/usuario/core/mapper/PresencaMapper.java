package iasd.coralzinho.usuario.core.mapper;

import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Presenca;
import iasd.coralzinho.usuario.core.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PresencaMapper {
    public Presenca mapear(Crianca crianca, Usuario professor, Integer tonzinhos){
        return Presenca.builder()
                .crianca(crianca)
                .professor(professor)
                .registro(LocalDateTime.now())
                .tonzinhosGanhos(tonzinhos)
                .build();
    }

    public List<String> mapear(List<Crianca> crianca){
        return crianca.stream().map(this::mapear).collect(Collectors.toList());
    }

    public String mapear(Crianca crianca){
        return crianca.getNome();
    }
}
