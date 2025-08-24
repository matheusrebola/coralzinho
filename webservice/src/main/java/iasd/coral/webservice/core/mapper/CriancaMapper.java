package iasd.coral.webservice.core.mapper;

import iasd.coral.webservice.core.dto.CriancaDTO;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public interface CriancaMapper {
    default Crianca mapear(CriancaDTO dto, Usuario pai){
        return Crianca.builder()
                .nome(dto.getNome())
                .dataNascimento(dto.getDataNascimento())
                .pai(pai)
                .saldoTonzinhos(0)
                .observacoes(dto.getObservacoes())
                .ativo(true)
                .build();
    }

    default CriancaDTO mapear(Crianca crianca) {
        return CriancaDTO.builder()
                .id(crianca.getId())
                .nome(crianca.getNome())
                .dataNascimento(crianca.getDataNascimento())
                .saldoTonzinhos(crianca.getSaldoTonzinhos())
                .observacoes(crianca.getObservacoes())
                .build();
    }
}
