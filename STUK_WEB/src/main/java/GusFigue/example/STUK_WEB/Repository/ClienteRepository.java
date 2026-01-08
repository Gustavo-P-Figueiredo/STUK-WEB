package GusFigue.example.STUK_WEB.Repository;

import GusFigue.example.STUK_WEB.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findById(Long Id);

    void deleteById(Long Id);

}