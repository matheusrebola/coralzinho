package iasd.coral.webservice.core.service;

import iasd.coral.webservice.config.exception.ResourceNotFoundException;
import iasd.coral.webservice.core.dto.CriancaDTO;
import iasd.coral.webservice.core.mapper.CriancaMapper;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.Usuario;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.UsuarioRepository;
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
        Usuario pai = usuarioRepository.findByEmail(emailPai)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return criancaRepository.save(criancaMapper.mapear(dto, pai));
    }

    public List<CriancaDTO> listarFilhos(String emailPai) {
        return criancaRepository.findByPaiEmail(emailPai).stream()
                .map(criancaMapper::mapear)
                .toList();
    }

    public Integer consultarSaldo(Long criancaId) {
        Crianca crianca = criancaRepository.findById(criancaId)
                .orElseThrow(() -> new ResourceNotFoundException("Criança não encontrada"));
        return crianca.getSaldoTonzinhos();
    }

    public List<CriancaDTO> getAniversariantesDoMes() {
        int mesAtual = LocalDate.now().getMonthValue();
        return criancaRepository.findAniversariantesDoMes(mesAtual).stream()
                .map(criancaMapper::mapear)
                .toList();
    }
}
