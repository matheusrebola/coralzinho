package iasd.coral.webservice.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iasd.coral.webservice.core.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo; // PAI, PROFESSOR, ADMIN

    @OneToMany(mappedBy = "pai", cascade = CascadeType.ALL)
    private List<Crianca> filhos;

    private LocalDateTime dataCadastro;

    private boolean ativo = true;
}
