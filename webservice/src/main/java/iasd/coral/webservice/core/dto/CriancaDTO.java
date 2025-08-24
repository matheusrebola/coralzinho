package iasd.coral.webservice.core.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CriancaDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Integer saldoTonzinhos;
    private String observacoes;
}
