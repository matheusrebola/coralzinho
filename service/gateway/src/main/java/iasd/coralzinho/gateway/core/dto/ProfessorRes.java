package iasd.coralzinho.gateway.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRes extends LoginRes {
    private String nome;
    private String token;
    private String email;
    private List<Filho> filho;
    private LocalDateTime horario;
}
