package iasd.coral.webservice.core.model;

import iasd.coral.webservice.core.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes_tonzinhos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
