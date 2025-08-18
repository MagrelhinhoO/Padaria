package app.padaria.service;

import app.padaria.model.Fornecedor;
import app.padaria.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        // Regra de negócio: Verificar se CNPJ já está cadastrado
        if (fornecedorRepository.findByCnpj(fornecedor.getCnpj()).size() > 0) {
            throw new RuntimeException("CNPJ já cadastrado");
        }
        return fornecedorRepository.save(fornecedor);
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public List<Fornecedor> buscarPorNome(String nome) {
        return fornecedorRepository.findByNomeContainingIgnoreCase(nome);
    }
}