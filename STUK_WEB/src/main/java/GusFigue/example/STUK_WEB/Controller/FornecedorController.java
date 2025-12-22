package GusFigue.example.STUK_WEB.Controller;

import GusFigue.example.STUK_WEB.DTO.FornecedorDTO;
import GusFigue.example.STUK_WEB.Model.FornecedorModel;

import GusFigue.example.STUK_WEB.Service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> salvarFornecedor(@RequestBody @Valid FornecedorDTO dto) {
        FornecedorDTO fornecedor = service.salvarFornecedor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
    }


    @GetMapping
    ResponseEntity<Optional<FornecedorModel>> buscarornecedorPorId(@RequestParam Long Id) {
        Optional<FornecedorModel> fornecedor = Optional.ofNullable(service.buscarFornecedorPorId(Id));
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFornecedorPorId(@RequestParam Long Id) {
        service.deletarFornecedorPorId(Id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarFornecedorPorId(@RequestParam Long Id, @RequestBody @Valid FornecedorDTO dto){
        service.atualizarFornecedorPorId(Id, dto);
        return ResponseEntity.ok().build();
    }
}


