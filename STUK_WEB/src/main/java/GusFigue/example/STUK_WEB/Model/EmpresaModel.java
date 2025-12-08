package GusFigue.example.STUK_WEB.Model;

import GusFigue.example.STUK_WEB.Infrastructure.TipoEmpresaEnum;
import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Por favor informe o estado")
    @Column(name = "Estado", nullable = false)
    private UFEnum Estado;

    @NotBlank(message = "Por favor informe uma cidade")
    @Column(name = "Cidade", nullable = false)
    private String Cidade;

    @NotBlank(message = "Por favor informe uma rua")
    @Column(name = "Rua", nullable = false)
    private String Rua;

    @NotBlank(message = "Por favor informe um numero")
    @Column(name = "Descricao", nullable = false)
    private String Numero;

    @Column(name = "Complemento")
    private String Complemento;

    @NotBlank(message = "Por favor informe o tipo da empresa")
    @Column(name = "Tipo", nullable = false)
    private TipoEmpresaEnum Tipo;

}
