package iasd.coralzinho.gateway.core.dto;

import java.util.List;

public record CadastroRes(String nome,
                          List<FilhoRes> filhos) {
}
