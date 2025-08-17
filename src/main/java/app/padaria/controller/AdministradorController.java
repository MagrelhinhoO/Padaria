package app.padaria.controller;

import app.padaria.model.Administrador;
import app.padaria.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> listarTodos() {
        return administradorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarPorId(@PathVariable Long id) {
        return administradorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Administrador salvar(@RequestBody Administrador administrador) {
        return administradorService.salvar(administrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> atualizar(@PathVariable Long id, @RequestBody Administrador administrador) {
        if (!administradorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        administrador.setId(id);
        return ResponseEntity.ok(administradorService.salvar(administrador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!administradorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        administradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Administrador> buscarPorNome(@RequestParam String nome) {
        return administradorService.buscarPorNome(nome);
    }
}