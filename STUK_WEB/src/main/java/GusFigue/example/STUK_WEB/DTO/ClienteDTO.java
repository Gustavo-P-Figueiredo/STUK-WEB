package GusFigue.example.STUK_WEB.DTO;

import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;

public record ClienteDTO(String Nome, String CPF, UFEnum Estado, String Cidade, String Rua,
                         String Numero, String Complemento, String Telefone) {


}
