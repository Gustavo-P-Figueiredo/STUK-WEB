package GusFigue.example.STUK_WEB.Service.Produto;

import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import GusFigue.example.STUK_WEB.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoDTO salvarProduto(ProdutoDTO dto) {
        ProdutoModel produto = new ProdutoModel(
                null,
                dto.Descricao(),
                dto.Valor(),
                dto.Quant_CD()
        );

        ProdutoModel salvo = repository.save(produto);

        return new ProdutoDTO(
                salvo.getDescricao(),
                salvo.getValor(),
                salvo.getQuant_CD()
        );
    }
}
