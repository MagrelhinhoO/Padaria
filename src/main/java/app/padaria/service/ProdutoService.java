package app.padaria.service;

import app.padaria.model.Produto;
import app.padaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        // Regra de negócio: Se estoque for zero, definir como "ESGOTADO"
        if (produto.getQuantidadeEstoque() <= 0) {
            produto.setQuantidadeEstoque(0);
        }
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> buscarPorPrecoMaximo(Double preco) {
        return produtoRepository.findByPrecoLessThanEqual(preco);
    }

    public List<Produto> buscarProdutosComEstoqueBaixo(Integer quantidade) {
        return produtoRepository.findProdutosComEstoqueBaixo(quantidade);
    }
}