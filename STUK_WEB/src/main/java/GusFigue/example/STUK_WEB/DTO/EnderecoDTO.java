package GusFigue.example.STUK_WEB.DTO;

import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    public UFEnum Estado;
    String Cidade;
    String Rua;
    String Numero;
    String Complemento;

}
