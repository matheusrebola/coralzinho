package iasd.coral.webservice.core.mapper;

import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.Presenca;
import iasd.coral.webservice.core.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public interface PresencaMapper {
    default Presenca mapear(Crianca crianca, Usuario professor){
        return Presenca.builder()
                .crianca(crianca)
                .professor(professor)
                .dataHora(LocalDateTime.now())
                .tonzinhosGanhos(10)
                .build();
    }

    default List<String> mapear(List<Crianca> crianca){
        return crianca.stream().map(this::mapear).collect(Collectors.toList());
    }

    default String mapear(Crianca crianca){
        return crianca.getNome();
    }
}
