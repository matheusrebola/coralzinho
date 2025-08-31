package iasd.coralzinho.gateway.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaiRes extends LoginRes {
    private String nome;
    private String token;
    private String email;
    private List<FilhoRes> filhoRes;
}
