package iasd.coral.webservice.core.model;

import iasd.coral.webservice.core.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes_tonzinhos", indexes = {
        @Index(name = "idx_transacoes_crianca", columnList = "crianca_id"),
        @Index(name = "idx_transacoes_data", columnList = "data_hora"),
        @Index(name = "idx_transacoes_tipo", columnList = "tipo")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoTonzinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crianca_id", nullable = false)
    private Crianca crianca;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo; // GANHO, GASTO, AJUSTE

    private Integer quantidade;

    private String descricao;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;
}
