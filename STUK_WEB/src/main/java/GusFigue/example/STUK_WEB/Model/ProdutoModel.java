package GusFigue.example.STUK_WEB.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")

@Table (name = "ProdutoTable")
@Entity (name = "Produto")

public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @NotBlank(message = "Por favor informe uma descrição")
    @Column(name = "Descricao", nullable = false)
    public String Descricao;

    @NotNull(message = "Por favor informe o valor.")
    @Positive(message = "O valor deve ser maior que zero.")
    @Column(name = "Valor", nullable = false)
    public double Valor;

    @Column(name = "Quant_CD")
    public int Quant_CD;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    public FornecedorModel fornecedor;
}
