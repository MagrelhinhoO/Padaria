package app.padaria.repository;

import app.padaria.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    List<Fornecedor> findByNomeContainingIgnoreCase(String nome);

    List<Fornecedor> findByCnpj(String cnpj);
}