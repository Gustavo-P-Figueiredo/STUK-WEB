package GusFigue.example.STUK_WEB.Model;

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


@Table(name = "EnderecoTable")
@Entity(name = "Endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "Por favor informe uma estado")
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private UFEnum Estado;

    @NotBlank(message = "Por favor informe uma cidade")
    @Column(name = "Cidade", nullable = false)
    private String Cidade;

    @NotBlank(message = "Por favor informe uma rua")
    @Column(name = "Rua", nullable = false)
    private String Rua;

    @NotBlank(message = "Por favor informe um numero")
    @Column(name = "Numero", nullable = false)
    private String Numero;

    @Column(name = "Complemento")
    private String Complemento;

}
