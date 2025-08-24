package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.dto.TransacaoDTO;
import iasd.coral.webservice.core.mapper.TransacaoTonzinhoMapper;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.TransacaoTonzinhoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final CriancaRepository criancaRepository;
    private final TransacaoTonzinhoRepository transacaoTonzinhoRepository;
    private final TransacaoTonzinhoMapper transacaoTonzinhoMapper;

    @Transactional
    public void adicionarTonzinhos(TransacaoDTO dto) {
        dto.crianca().setSaldoTonzinhos(dto.crianca().getSaldoTonzinhos() + dto.quantidade());
        criancaRepository.save(dto.crianca());
        transacaoTonzinhoRepository.save(transacaoTonzinhoMapper.mapear(dto));
    }
}
