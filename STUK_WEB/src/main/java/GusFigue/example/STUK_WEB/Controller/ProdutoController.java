package GusFigue.example.STUK_WEB.Controller;

import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import GusFigue.example.STUK_WEB.DTO.ProdutoDTO;
import GusFigue.example.STUK_WEB.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody @Valid ProdutoDTO dto, Object Fornecedor_Id) {
        ProdutoDTO produto = service.salvarProduto(dto, Fornecedor_Id);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<Optional<ProdutoModel>> buscarProdutoPorId(@RequestParam Long Id) {
        Optional<ProdutoModel> produto = Optional.ofNullable(service.buscarProdutoPorId(Id));
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarProdutoPorId(@RequestParam Long Id){
        service.deletarProdutoPorId(Id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProdutoPorId(@RequestParam Long Id, @RequestBody @Valid ProdutoDTO dto){
        service.atualizarProdutoPorId(Id, dto);
        return ResponseEntity.ok().build();
    }


}