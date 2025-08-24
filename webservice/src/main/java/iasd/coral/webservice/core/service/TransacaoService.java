package iasd.coral.webservice.core.service;

import iasd.coral.webservice.core.model.Crianca;
import iasd.coral.webservice.core.model.TransacaoTonzinho;
import iasd.coral.webservice.core.model.enums.TipoTransacao;
import iasd.coral.webservice.core.repository.CriancaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {
    @Autowired
    private CriancaRepository criancaRepository;

    @Transactional
    public void adicionarTonzinhos(Crianca crianca, Integer quantidade, String descricao, Long responsavelId) {
        crianca.setSaldoTonzinhos(crianca.getSaldoTonzinhos() + quantidade);
        criancaRepository.save(crianca);

        // Registra transação
        TransacaoTonzinho transacao = new TransacaoTonzinho();
        transacao.setCrianca(crianca);
        transacao.setTipo(TipoTransacao.GANHO);
        transacao.setQuantidade(quantidade);
        transacao.setDescricao(descricao);
        transacao.setDataHora(LocalDateTime.now());
        // Salvar transação
    }
}
