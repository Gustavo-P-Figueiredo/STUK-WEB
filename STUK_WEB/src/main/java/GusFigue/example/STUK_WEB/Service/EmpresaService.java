package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.ClienteDTO;
import GusFigue.example.STUK_WEB.DTO.EmpresaDTO;
import GusFigue.example.STUK_WEB.DTO.EnderecoDTO;
import GusFigue.example.STUK_WEB.Model.ClienteModel;
import GusFigue.example.STUK_WEB.Model.EmpresaModel;
import GusFigue.example.STUK_WEB.Model.EnderecoModel;
import GusFigue.example.STUK_WEB.Repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpresaService {

    private final EmpresaRepository repository;

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaDTO salvarEmpresa(EmpresaDTO dto) {
        if (dto.Descricao() == null || dto.Descricao().isBlank()) {
            throw new IllegalArgumentException("Por favor informe a descrição da empresa.");
        }

        if (dto.Tipo() == null) {
            throw new IllegalArgumentException("Por favor informe um tipo de empresa.");
        }

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

        EnderecoModel endereco = new EnderecoModel();
        endereco.setEstado(e.getEstado());
        endereco.setCidade(e.getCidade());
        endereco.setRua(e.getRua());
        endereco.setNumero(e.getNumero());
        endereco.setComplemento(e.getComplemento());

        EmpresaModel empresa = new EmpresaModel();
        empresa.setDescricao(dto.Descricao());
        empresa.setTipo(dto.Tipo());
        empresa.setEndereco(endereco);

        EmpresaModel salvo = repository.save(empresa);

        return new EmpresaDTO(
                salvo.getDescricao(),
                new EnderecoDTO(
                        salvo.getEndereco().getEstado(),
                        salvo.getEndereco().getCidade(),
                        salvo.getEndereco().getRua(),
                        salvo.getEndereco().getNumero(),
                        salvo.getEndereco().getComplemento()
                ),
                salvo.getTipo()
        );
    }

    public EmpresaModel buscarEmpresaPorId(Long Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrado"));
    }

    public void deletarEmpresaPorId(Long Id) {
        repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrado"));
        repository.deleteById(Id);
    }

    public EmpresaDTO atualizarEmpresaPorId(Long Id, EmpresaDTO dto) {
        EmpresaModel empresa = repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrado"));

        empresa.setDescricao(dto.Descricao());
        empresa.setTipo(dto.Tipo());

        EnderecoDTO e = dto.Endereco();
        EnderecoModel endereco = empresa.getEndereco();

        if (endereco == null) {
            endereco = new EnderecoModel();
        }

        endereco.setEstado(e.getEstado());
        endereco.setCidade(e.getCidade());
        endereco.setRua(e.getRua());
        endereco.setNumero(e.getNumero());
        endereco.setComplemento(e.getComplemento());

        empresa.setEndereco(endereco);

        EmpresaModel salvo = repository.save(empresa);

        return new EmpresaDTO(
                salvo.getDescricao(),
                new EnderecoDTO(
                        salvo.getEndereco().getEstado(),
                        salvo.getEndereco().getCidade(),
                        salvo.getEndereco().getRua(),
                        salvo.getEndereco().getNumero(),
                        salvo.getEndereco().getComplemento()
                ),
                salvo.getTipo()
        );
    }
}