package iasd.coralzinho.usuario.core.mapper;

import iasd.coralzinho.usuario.core.dto.CriancaDTO;
import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class CriancaMapper {
    public Crianca mapear(CriancaDTO dto, Usuario pai){
        return Crianca.builder()
                .nome(dto.nome())
                .dataNascimento(dto.dataNascimento())
                .pai(pai)
                .saldoTonzinhos(dto.saldoTonzinhos())
                .observacoes(dto.observacoes())
                .ativo(true)
                .build();
    }

    public CriancaDTO mapear(Crianca crianca) {
        return CriancaDTO.builder()
                .id(crianca.getId())
                .nome(crianca.getNome())
                .dataNascimento(crianca.getDataNascimento())
                .saldoTonzinhos(crianca.getSaldoTonzinhos())
                .observacoes(crianca.getObservacoes())
                .build();
    }
}
