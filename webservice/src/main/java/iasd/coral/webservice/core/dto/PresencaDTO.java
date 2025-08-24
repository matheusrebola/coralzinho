package iasd.coral.webservice.core.dto;

import lombok.Data;

@Data
public class PresencaDTO {
    private Long criancaId;
    private String qrCode;
    private Integer tonzinhosGanhos;
}
