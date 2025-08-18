package app.padaria.repository;

import app.padaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByPrecoLessThanEqual(Double preco);

    @Query("SELECT p FROM Produto p WHERE p.quantidadeEstoque < :quantidade")
    List<Produto> findProdutosComEstoqueBaixo(Integer quantidade);
}