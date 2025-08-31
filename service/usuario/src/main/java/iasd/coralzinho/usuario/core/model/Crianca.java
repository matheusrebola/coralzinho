package iasd.coralzinho.usuario.core.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "criancas", schema = "tonzinhos", indexes = {
        @Index(name = "idx_criancas_pai", columnList = "pai_id"),
        @Index(name = "idx_criancas_aniversario", columnList = "data_nascimento"),
        @Index(name = "idx_criancas_ativo", columnList = "ativo")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private List<Transacao> transacoes;

    @Column(nullable = false)
    private Integer saldoTonzinhos = 0;

    private String observacoes;

    private boolean ativo = true;
}
