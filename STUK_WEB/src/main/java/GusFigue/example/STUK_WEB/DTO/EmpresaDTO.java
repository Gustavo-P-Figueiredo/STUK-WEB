package GusFigue.example.STUK_WEB.DTO;

import GusFigue.example.STUK_WEB.Infrastructure.TipoEmpresaEnum;
import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;

public record EmpresaDTO(String Descricao, EnderecoDTO Endereco, TipoEmpresaEnum Tipo) {

}