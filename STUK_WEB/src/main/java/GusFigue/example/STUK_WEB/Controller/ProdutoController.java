package GusFigue.example.STUK_WEB.Controller;

import GusFigue.example.STUK_WEB.Service.Produto.ProdutoDTO;
import GusFigue.example.STUK_WEB.Service.Produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody @Valid ProdutoDTO dto) {
        ProdutoDTO produto = service.salvarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }


}
