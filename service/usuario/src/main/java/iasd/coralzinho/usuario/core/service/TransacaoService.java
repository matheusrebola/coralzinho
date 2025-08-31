package iasd.coralzinho.usuario.core.service;

import iasd.coralzinho.usuario.core.dto.TransacaoDTO;
import iasd.coralzinho.usuario.core.mapper.TransacaoMapper;
import iasd.coralzinho.usuario.core.model.Transacao;
import iasd.coralzinho.usuario.core.repository.CriancaRepository;
import iasd.coralzinho.usuario.core.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final CriancaRepository criancaRepository;
    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    @Transactional
    public void adicionarTonzinhos(TransacaoDTO dto) {
        dto.crianca().setSaldoTonzinhos(dto.crianca().getSaldoTonzinhos() + dto.quantidade());
        criancaRepository.save(dto.crianca());
        transacaoRepository.save(transacaoMapper.mapear(dto));
    }

    @Transactional
    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
}
