package iasd.coralzinho.usuario.core.service;

import iasd.coralzinho.usuario.core.dto.CriancaDTO;
import iasd.coralzinho.usuario.core.mapper.CriancaMapper;
import iasd.coralzinho.usuario.core.model.Crianca;
import iasd.coralzinho.usuario.core.model.Usuario;
import iasd.coralzinho.usuario.core.repository.CriancaRepository;
import iasd.coralzinho.usuario.core.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriancaService {
    private final CriancaRepository criancaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CriancaMapper criancaMapper;

    @Transactional
    public Crianca adicionarFilho(CriancaDTO dto, String emailPai) {
        Usuario pai = usuarioRepository.findByEmail(emailPai).orElseThrow();
        return criancaRepository.save(criancaMapper.mapear(dto, pai));
    }

    @Transactional
    public void removerFilho(Long id) {
        usuarioRepository.deleteFilhoById(id);
    }

    public List<CriancaDTO> listarFilhos(String emailPai) {
        return criancaRepository.findByPaiEmail(emailPai).stream()
                .map(criancaMapper::mapear)
                .toList();
    }

    public Integer consultarSaldo(Long criancaId) {
        Crianca crianca = criancaRepository.findById(criancaId).orElseThrow();
        return crianca.getSaldoTonzinhos();
    }

    public List<CriancaDTO> getAniversariantesDoMes() {
        int mesAtual = LocalDate.now().getMonthValue();
        return criancaRepository.findAniversariantesDoMes(mesAtual).stream()
                .map(criancaMapper::mapear)
                .toList();
    }
}
