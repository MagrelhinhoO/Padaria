package app.padaria.service;

import app.padaria.model.*;
import app.padaria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda salvar(Venda venda) {
        // Regra de negócio: Atualizar estoque dos produtos
        if (venda.getProdutos() != null && !venda.getProdutos().isEmpty()) {
            for (Produto produto : venda.getProdutos()) {
                Produto produtoBD = produtoService.buscarPorId(produto.getId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
                produtoBD.diminuirEstoque(1); // Assumindo 1 unidade por produto
                produtoService.salvar(produtoBD);
            }
        }

        // Regra de negócio: Definir data atual se não informada
        if (venda.getDataVenda() == null) {
            venda.setDataVenda(LocalDateTime.now());
        }

        return vendaRepository.save(venda);
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    public List<Venda> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return vendaRepository.findByDataVendaBetween(inicio, fim);
    }

    public List<Venda> buscarPorCliente(Long clienteId) {
        return vendaRepository.findByClienteId(clienteId);
    }
}