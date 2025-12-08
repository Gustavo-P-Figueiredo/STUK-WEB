package GusFigue.example.STUK_WEB.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Long Id;

    @NotBlank(message = "Por favor informe uma descrição")
    @Column(name = "Descricao", nullable = false)
    private String Descricao;

    @NotBlank(message = "Por favor informe um valor para o produto")
    @Column(name = "Valor", nullable = false)
    private double Valor;

    @Column(name = "Quant_CD")
    private int Quant_CD;

}
