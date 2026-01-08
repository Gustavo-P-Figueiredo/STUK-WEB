package GusFigue.example.STUK_WEB.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")

@Table(name = "FornecedorTable")
@Entity(name = "Fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Por favor informe uma descrição")
    @Column(name = "Descricao", nullable = false)
    private String Nome;

    @Pattern(regexp = "\\d{14}", message = "O CEP deve conter exatamente 14 dígitos numéricos")
    @Column(name = "CNPJ", nullable = false, unique=true)
    private String CNPJ;

    @OneToMany(mappedBy = "fornecedor")
    @JsonManagedReference
    private List<ProdutoModel> produtoList;

}