package iasd.coral.webservice.core.mapper;

import iasd.coral.webservice.core.dto.CadastroDTO;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.model.enums.TipoUsuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface UsuarioMapper {
    default Usuario mapear(CadastroDTO dto){
        return Usuario.builder()
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .tipo(TipoUsuario.PAI)
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
