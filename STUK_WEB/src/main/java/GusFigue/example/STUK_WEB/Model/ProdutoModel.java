package GusFigue.example.STUK_WEB.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")


@Table (name = "ProdutoTable")
@Entity (name = "Produto")

public class ProdutoModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Descricao;
    private double Valor;
    private int Quant_CD;

}
