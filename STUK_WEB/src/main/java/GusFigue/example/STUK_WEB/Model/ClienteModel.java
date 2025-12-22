package GusFigue.example.STUK_WEB.Model;

import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")


@Table(name = "ClienteTable")
@Entity(name = "Cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Por favor informe o nome do cliente")
    @Column(name = "Nome", nullable = false)
    private String Nome;

    @NotBlank(message = "Por favor informe o CPF do cliente")

    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos")
    @Column(name = "CPF", nullable = false, unique=true)
    private String CPF;

    @NotNull(message = "Por favor informe uma estado")
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

    @NotNull(message = "Por favor informe o telefone de contato")
    @Pattern(regexp = "\\d{9}", message = "O numero de telefone deve conter exatamente 9 dígitos numéricos")
    @Column(name = "Telefone", nullable = false)
    private String Telefone;

}

