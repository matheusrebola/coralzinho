package iasd.coralzinho.usuario.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ensaios", schema = "tonzinhos", indexes = {
        @Index(name = "idx_presencas_crianca", columnList = "crianca_id"),
        @Index(name = "idx_presencas_data", columnList = "data_hora"),
        @Index(name = "idx_presencas_professor", columnList = "professor_id")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ensaio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate data;

    @Column
    private LocalTime hora;

    @OneToMany(mappedBy = "ensaio", cascade = CascadeType.ALL)
    private Presenca presenca;
}
