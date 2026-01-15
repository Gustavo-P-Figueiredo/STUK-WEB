package GusFigue.example.STUK_WEB.Model;

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

    @Pattern(regexp = "\\d{8}", message = "O CPF deve conter exatamente 8 dígitos numéricos")
    @Column(name = "CPF", nullable = false, unique=true)
    private String CPF;

    @NotNull(message = "Por favor informe o telefone de contato")
    @Pattern(regexp = "\\d{9}", message = "O numero de telefone deve conter exatamente 9 dígitos numéricos")
    @Column(name = "Telefone", nullable = false)
    private String Telefone;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Endereco_id", nullable = false)
    private EnderecoModel endereco;
}
