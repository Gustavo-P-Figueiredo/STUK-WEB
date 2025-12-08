package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.EmpresaDTO;
import GusFigue.example.STUK_WEB.Model.EmpresaModel;
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

        if (dto.Estado() == null || dto.Estado().isBlank()) {
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

        if (dto.Tipo() == null || dto.Tipo().isBlank()) {
            throw new IllegalArgumentException("Por favor informe um tipo de empresa.");
        }

        EmpresaModel empresa = new EmpresaModel(
                null,
                dto.Descricao(),
                dto.Estado(),
                dto.Cidade(),
                dto.Rua(),
                dto.Numero(),
                dto.Complemento(),
                dto.Tipo()
        );

        EmpresaModel salvo = repository.save(empresa);

        return new EmpresaDTO(
                salvo.getDescricao(),
                salvo.getEstado(),
                salvo.getCidade(),
                salvo.getRua(),
                salvo.getNumero(),
                salvo.getComplemento(),
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
        empresa.setEstado(dto.Estado());
        empresa.setCidade(dto.Cidade());
        empresa.setRua(dto.Rua());
        empresa.setNumero(dto.Numero());
        empresa.setComplemento(dto.Complemento());
        empresa.setTipo(dto.Tipo());


        EmpresaModel salvo = repository.save(empresa);

        return new EmpresaDTO(
                salvo.getDescricao(),
                salvo.getEstado(),
                salvo.getCidade(),
                salvo.getRua(),
                salvo.getNumero(),
                salvo.getComplemento(),
                salvo.getTipo()
        );
    }
}
