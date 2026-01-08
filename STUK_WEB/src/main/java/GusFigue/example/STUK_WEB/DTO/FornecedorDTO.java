package GusFigue.example.STUK_WEB.DTO;

import GusFigue.example.STUK_WEB.Model.ProdutoModel;

import java.util.List;

public record FornecedorDTO(String Nome, String CNPJ, List<ProdutoModel> produtoList) {
}