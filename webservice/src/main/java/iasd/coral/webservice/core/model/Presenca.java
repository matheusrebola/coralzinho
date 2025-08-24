package iasd.coral.webservice.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "presencas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    private LocalDateTime dataHora;

    @Column(nullable = false)
    private Integer tonzinhosGanhos = 10; // Valor padrão por presença

    private String observacao;
}
