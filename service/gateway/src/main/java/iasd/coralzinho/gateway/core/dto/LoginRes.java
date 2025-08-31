package iasd.coralzinho.gateway.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRes {
    private String nome;
    private String token;
    private String email;
    //professor
    private List<Filho> filho;
    private LocalDateTime horario;

    //pai
    private List<FilhoRes> filhoRes;
}
