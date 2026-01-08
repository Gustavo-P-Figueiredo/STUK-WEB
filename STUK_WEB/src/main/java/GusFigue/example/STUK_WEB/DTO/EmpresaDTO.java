package GusFigue.example.STUK_WEB.DTO;

import GusFigue.example.STUK_WEB.Infrastructure.TipoEmpresaEnum;
import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;

public record EmpresaDTO(String Descricao, UFEnum Estado, String Cidade, String Rua,
                         String Numero, String Complemento, TipoEmpresaEnum Tipo) {

}