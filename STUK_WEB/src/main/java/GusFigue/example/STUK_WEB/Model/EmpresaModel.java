package GusFigue.example.STUK_WEB.Model;

import GusFigue.example.STUK_WEB.Infrastructure.TipoEmpresaEnum;
import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")


@Table(name = "EmpresaTable")
@Entity(name = "Empresa")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Por favor informe uma descrição")
    @Column(name = "Descricao", nullable = false)
    private String Descricao;

    @NotNull(message = "Por favor informe o tipo da empresa")
    @Column(name = "Tipo", nullable = false)
    private TipoEmpresaEnum Tipo;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Endereco_id", nullable = false)
    private EnderecoModel endereco;
}