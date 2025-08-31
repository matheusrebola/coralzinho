package iasd.coralzinho.usuario.core.model;

import iasd.coralzinho.usuario.core.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes", schema = "tonzinhos", indexes = {
        @Index(name = "idx_transacoes_crianca", columnList = "crianca_id"),
        @Index(name = "idx_transacoes_data", columnList = "data_hora"),
        @Index(name = "idx_transacoes_tipo", columnList = "tipo")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crianca_id", nullable = false)
    private Crianca crianca;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private TipoTransacao tipo; // GANHO, GASTO, AJUSTE

    @Column
    private Integer quantidade;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column
    private LocalDateTime dataEnsaio;

    @Column
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;
}
