package app.padaria.controller;

import app.padaria.model.Venda;
import app.padaria.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id) {
        return vendaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return vendaService.salvar(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Long id, @RequestBody Venda venda) {
        if (!vendaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        venda.setId(id);
        return ResponseEntity.ok(vendaService.salvar(venda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!vendaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/periodo")
    public List<Venda> buscarPorPeriodo(
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        return vendaService.buscarPorPeriodo(inicio, fim);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Venda> buscarPorCliente(@PathVariable Long clienteId) {
        return vendaService.buscarPorCliente(clienteId);
    }
}