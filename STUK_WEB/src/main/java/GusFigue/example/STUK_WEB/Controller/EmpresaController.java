package GusFigue.example.STUK_WEB.Controller;

import GusFigue.example.STUK_WEB.DTO.EmpresaDTO;
import GusFigue.example.STUK_WEB.DTO.ProdutoDTO;
import GusFigue.example.STUK_WEB.Model.EmpresaModel;
import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import GusFigue.example.STUK_WEB.Service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> salvarEmpresa(@RequestBody @Valid EmpresaDTO dto) {
        EmpresaDTO empresa = service.salvarEmpresa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping
    public ResponseEntity<Optional<EmpresaModel>> buscarEmpresaPorId(@RequestParam Long Id) {
        Optional<EmpresaModel> empresa = Optional.ofNullable(service.buscarEmpresaPorId(Id));
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEmpresaPorId(@RequestParam Long Id){
        service.deletarEmpresaPorId(Id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEmpresaPorId(@RequestParam Long Id, @RequestBody @Valid EmpresaDTO dto){
        service.atualizarEmpresaPorId(Id, dto);
        return ResponseEntity.ok().build();
    }

}
