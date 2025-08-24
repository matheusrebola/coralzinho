package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.dto.TransacaoDTO;
import iasd.coral.webservice.core.mapper.TransacaoTonzinhoMapper;
import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.TransacaoTonzinho;
import iasd.coral.webservice.core.model.enums.TipoTransacao;
import iasd.coral.webservice.core.repository.CriancaRepository;
import iasd.coral.webservice.core.repository.TransacaoTonzinhoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {
    @Autowired
    private CriancaRepository criancaRepository;

    @Autowired
    private TransacaoTonzinhoRepository transacaoTonzinhoRepository;

    @Autowired
    private TransacaoTonzinhoMapper transacaoTonzinhoMapper;

    @Transactional
    public void adicionarTonzinhos(TransacaoDTO dto) {
        dto.crianca().setSaldoTonzinhos(dto.crianca().getSaldoTonzinhos() + dto.quantidade());
        criancaRepository.save(dto.crianca());

        transacaoTonzinhoRepository.save(transacaoTonzinhoMapper.mapear(dto));
    }
}
