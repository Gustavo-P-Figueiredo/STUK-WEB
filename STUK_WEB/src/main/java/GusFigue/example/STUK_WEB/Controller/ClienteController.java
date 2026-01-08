package GusFigue.example.STUK_WEB.Controller;

import GusFigue.example.STUK_WEB.DTO.ClienteDTO;
import GusFigue.example.STUK_WEB.Model.ClienteModel;
import GusFigue.example.STUK_WEB.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody @Valid ClienteDTO dto) {
        ClienteDTO cliente = service.salvarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }


    @GetMapping
    ResponseEntity<Optional<ClienteModel>> buscarClientePorId(@RequestParam Long Id) {
        Optional<ClienteModel> cliente = Optional.ofNullable(service.buscarClientePorId(Id));
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarClientePorId(@RequestParam Long Id) {
        service.deletarClientePorId(Id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarClientePorId(@RequestParam Long Id, @RequestBody @Valid ClienteDTO dto){
        service.atualizarClientePorId(Id, dto);
        return ResponseEntity.ok().build();
    }
}