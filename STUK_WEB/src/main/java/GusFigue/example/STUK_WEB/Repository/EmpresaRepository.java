package GusFigue.example.STUK_WEB.Repository;

import GusFigue.example.STUK_WEB.Model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

    Optional<EmpresaModel> findById(Long Id);

    void deleteById(Long Id);

}