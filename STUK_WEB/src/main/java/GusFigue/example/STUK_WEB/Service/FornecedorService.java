package GusFigue.example.STUK_WEB.Service;

import GusFigue.example.STUK_WEB.DTO.FornecedorDTO;
import GusFigue.example.STUK_WEB.Model.FornecedorModel;
import GusFigue.example.STUK_WEB.Model.ProdutoModel;
import GusFigue.example.STUK_WEB.Repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class FornecedorService {

    private final FornecedorRepository repository;

    @Autowired
    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public FornecedorDTO salvarFornecedor(FornecedorDTO dto) {
        if (dto.Nome() == null || dto.Nome().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o nome do fornecedor.");
        }

        if (dto.CNPJ() == null || dto.CNPJ().isBlank()) {
            throw new IllegalArgumentException("Por favor informe o CNPJ do fornecedor.");
        }

        FornecedorModel fornecedor = new FornecedorModel(
                null,
                dto.Nome(),
                dto.CNPJ(),
                produtoList()
        );

        FornecedorModel salvo = repository.save(fornecedor);

        return new FornecedorDTO(
                salvo.getNome(),
                salvo.getCNPJ(),
                salvo.getProdutoList()
        );
    }

    private List<ProdutoModel> produtoList() {
        return null;
    }

    public FornecedorModel buscarFornecedorPorId(Long Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public void deletarFornecedorPorId(Long Id) {
        repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        repository.deleteById(Id);
    }

    public FornecedorDTO atualizarFornecedorPorId(Long Id, FornecedorDTO dto) {
        FornecedorModel fornecedor = repository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        fornecedor.setNome(dto.Nome());
        fornecedor.setCNPJ(dto.CNPJ());

        FornecedorModel salvo = repository.save(fornecedor);

        return new FornecedorDTO(
                salvo.getNome(),
                salvo.getCNPJ(),
                salvo.getProdutoList()
        );
    }

}



