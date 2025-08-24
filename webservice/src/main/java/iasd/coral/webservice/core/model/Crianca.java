package iasd.coral.webservice.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "criancas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crianca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "pai_id", nullable = false)
    private Usuario pai;

    @OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL)
    private List<Presenca> presencas;

    @OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL)
    private List<TransacaoTonzinho> transacoes;

    @Column(nullable = false)
    private Integer saldoTonzinhos = 0;

    private String observacoes;

    private boolean ativo = true;
}
