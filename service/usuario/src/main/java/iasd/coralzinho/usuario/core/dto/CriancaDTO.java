package iasd.coralzinho.usuario.core.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CriancaDTO (
        Long id,
        String nome,
        LocalDate dataNascimento,
        Integer saldoTonzinhos,
        String observacoes
){

}
