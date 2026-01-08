package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.ClienteDTO;
import GusFigue.example.STUK_WEB.DTO.EnderecoDTO;
import GusFigue.example.STUK_WEB.Infrastructure.UFEnum;
import GusFigue.example.STUK_WEB.Model.ClienteModel;
import GusFigue.example.STUK_WEB.Model.EnderecoModel;
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

        // ===============================
        // Validações do Cliente
        // ===============================
        if (dto.Nome() == null || dto.Nome().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o nome do cliente.");
        }

        if (dto.CPF() == null || dto.CPF().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o CPF do cliente.");
        }

        if (dto.Telefone() == null || dto.Telefone().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o telefone de contato.");
        }

        // ===============================
        // Validações do Endereço
        // ===============================
        EnderecoDTO e = dto.Endereco();

        if (e == null) {
            throw new IllegalArgumentException("Por favor informe o endereço.");
        }

        if (e.getEstado() == null) {
            throw new IllegalArgumentException("Por favor informe um estado.");
        }

        if (e.getCidade() == null || e.getCidade().isBlank()) {
            throw new IllegalArgumentException("Por favor informe uma cidade.");
        }

        if (e.getRua() == null || e.getRua().isBlank()) {
            throw new IllegalArgumentException("Por favor informe uma rua.");
        }

        if (e.getNumero() == null || e.getNumero().isBlank()) {
            throw new IllegalArgumentException("Por favor informe um número.");
        }

        // ===============================
        // Montagem do EnderecoModel
        // ===============================
        EnderecoModel endereco = new EnderecoModel();
        endereco.setEstado(e.getEstado());      // ✅ UFEnum direto
        endereco.setCidade(e.getCidade());
        endereco.setRua(e.getRua());
        endereco.setNumero(e.getNumero());
        endereco.setComplemento(e.getComplemento());

        // ===============================
        // Montagem do ClienteModel
        // ===============================
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(dto.Nome());
        cliente.setCPF(dto.CPF());
        cliente.setTelefone(dto.Telefone());
        cliente.setEndereco(endereco);

        ClienteModel salvo = repository.save(cliente);

        // ===============================
        // Retorno DTO
        // ===============================
        return new ClienteDTO(
                salvo.getNome(),
                salvo.getCPF(),
                new EnderecoDTO(
                        salvo.getEndereco().getEstado(),
                        salvo.getEndereco().getCidade(),
                        salvo.getEndereco().getRua(),
                        salvo.getEndereco().getNumero(),
                        salvo.getEndereco().getComplemento()
                ),
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

    public ClienteDTO atualizarClientePorId(Long id, ClienteDTO dto) {

        // ===============================
        // Busca do cliente
        // ===============================
        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // ===============================
        // Validações básicas
        // ===============================
        if (dto.Nome() == null || dto.Nome().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o nome do cliente.");
        }

        if (dto.CPF() == null || dto.CPF().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o CPF do cliente.");
        }

        if (dto.Telefone() == null || dto.Telefone().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o telefone.");
        }

        if (dto.Endereco() == null) {
            throw new IllegalArgumentException("Por favor informe o endereço.");
        }

        // ===============================
        // Atualização do Cliente
        // ===============================
        cliente.setNome(dto.Nome());
        cliente.setCPF(dto.CPF());
        cliente.setTelefone(dto.Telefone());

        // ===============================
        // Atualização do Endereço
        // ===============================
        EnderecoDTO e = dto.Endereco();
        EnderecoModel endereco = cliente.getEndereco();

        if (endereco == null) {
            endereco = new EnderecoModel();
        }

        endereco.setEstado(e.getEstado());
        endereco.setCidade(e.getCidade());
        endereco.setRua(e.getRua());
        endereco.setNumero(e.getNumero());
        endereco.setComplemento(e.getComplemento());

        cliente.setEndereco(endereco);

        // ===============================
        // Persistência
        // ===============================
        ClienteModel salvo = repository.save(cliente);

        // ===============================
        // Retorno DTO
        // ===============================
        return new ClienteDTO(
                salvo.getNome(),
                salvo.getCPF(),
                new EnderecoDTO(
                        salvo.getEndereco().getEstado(),
                        salvo.getEndereco().getCidade(),
                        salvo.getEndereco().getRua(),
                        salvo.getEndereco().getNumero(),
                        salvo.getEndereco().getComplemento()
                ),
                salvo.getTelefone()
        );
    }
}