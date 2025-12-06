package GusFigue.example.STUK_WEB.Repository;

import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import GusFigue.example.STUK_WEB.Service.Produto.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


}
