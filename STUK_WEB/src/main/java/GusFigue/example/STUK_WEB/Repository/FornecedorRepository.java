package GusFigue.example.STUK_WEB.Repository;

import GusFigue.example.STUK_WEB.Model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

    Optional<FornecedorModel> findById(Long Id);

    void deleteById(Long Id);

}
