package GusFigue.example.STUK_WEB.Repository;

import GusFigue.example.STUK_WEB.DTO.ProdutoDTO;
import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findById(Long Id);

    void deleteById(Long Id);

}