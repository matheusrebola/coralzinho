package iasd.coralzinho.usuario.core.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "presencas", schema = "tonzinhos", indexes = {
        @Index(name = "idx_presencas_crianca", columnList = "crianca_id"),
        @Index(name = "idx_presencas_data", columnList = "data_hora"),
        @Index(name = "idx_presencas_professor", columnList = "professor_id")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crianca_id", nullable = false)
    private Crianca crianca;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Usuario professor;

    @Column
    private LocalDateTime registro;

    @ManyToOne
    @JoinColumn(name = "ensaio_id", nullable = false)
    private Ensaio ensaio;

    @Column(nullable = false)
    private Integer tonzinhosGanhos;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
