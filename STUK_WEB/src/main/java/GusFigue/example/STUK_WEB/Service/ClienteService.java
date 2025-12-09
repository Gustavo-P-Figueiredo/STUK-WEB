package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.ClienteDTO;
import GusFigue.example.STUK_WEB.Model.ClienteModel;
import GusFigue.example.STUK_WEB.Repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteDTO salvarCliente(ClienteDTO dto) {
        if (dto.Nome() == null || dto.Nome().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o nome do cliente.");
        }

        if (dto.CPF() == null || dto.CPF().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o CPF do cliente.");
        }

        if (dto.Estado() == null) {
            throw new IllegalArgumentException("Por favor informe um estado.");
        }

        if (dto.Cidade() == null || dto.Cidade().isBlank()) {
            throw new IllegalArgumentException("Por favor informe uma cidade.");
        }

        if (dto.Rua() == null || dto.Rua().isBlank()) {
            throw new IllegalArgumentException("Por favor informe uma rua.");
        }

        if (dto.Numero() == null || dto.Numero().isBlank()) {
            throw new IllegalArgumentException("Por favor informe um numero.");
        }

        if (dto.Telefone() == null || dto.Telefone().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o telefone de contato.");
        }


        ClienteModel cliente = new ClienteModel(
                null,
                dto.Nome(),
                dto.CPF(),
                dto.Estado(),
                dto.Cidade(),
                dto.Rua(),
                dto.Numero(),
                dto.Complemento(),
                dto.Telefone()
        );

        ClienteModel salvo = repository.save(cliente);

        return new ClienteDTO(
                salvo.getNome(),
                salvo.getCPF(),
                salvo.getEstado(),
                salvo.getCidade(),
                salvo.getRua(),
                salvo.getNumero(),
                salvo.getComplemento(),
                salvo.getTelefone()
        );
    }

    public ClienteModel buscarClientePorId(Long Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletarClientePorId(Long Id) {
        repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        repository.deleteById(Id);
    }

    public ClienteDTO atualizarClientePorId(Long Id, ClienteDTO dto) {
        ClienteModel cliente = repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.Nome());
        cliente.setCPF(dto.CPF());
        cliente.setEstado(dto.Estado());
        cliente.setCidade(dto.Cidade());
        cliente.setRua(dto.Rua());
        cliente.setNumero(dto.Numero());
        cliente.setComplemento(dto.Complemento());
        cliente.setTelefone(dto.Telefone());


        ClienteModel salvo = repository.save(cliente);

        return new ClienteDTO(
                salvo.getNome(),
                salvo.getCPF(),
                salvo.getEstado(),
                salvo.getCidade(),
                salvo.getRua(),
                salvo.getNumero(),
                salvo.getComplemento(),
                salvo.getTelefone()
        );
    }
}
