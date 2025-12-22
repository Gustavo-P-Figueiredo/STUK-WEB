package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.ProdutoDTO;
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
            if (dto.Descricao() == null || dto.Descricao().isBlank()) {
                throw new IllegalArgumentException("A descrição do produto não pode ser vazia.");
            }

            if (dto.Valor() <= 0) {
                throw new IllegalArgumentException("O valor do produto deve ser maior que zero.");
            }

            ProdutoModel produto = new ProdutoModel(
            );

            ProdutoModel salvo = repository.save(produto);

            return new ProdutoDTO(
                    salvo.getDescricao(),
                    salvo.getValor(),
                    salvo.getQuant_CD()
            );
    }

    public ProdutoModel buscarProdutoPorId(Long Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletarProdutoPorId(Long Id) {
        repository.findById(Id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        repository.deleteById(Id);
    }

    public ProdutoDTO atualizarProdutoPorId(Long Id, ProdutoDTO dto) {
        ProdutoModel produto = repository.findById(Id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setDescricao(dto.Descricao());
        produto.setValor(dto.Valor());
        produto.setQuant_CD(dto.Quant_CD());
        ProdutoModel salvo = repository.save(produto);

        return new ProdutoDTO(
                salvo.getDescricao(),
                salvo.getValor(),
                salvo.getQuant_CD()
        );
    }

}