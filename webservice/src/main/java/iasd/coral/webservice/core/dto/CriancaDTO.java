package iasd.coral.webservice.core.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CriancaDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Integer saldoTonzinhos;
    private String observacoes;
}
