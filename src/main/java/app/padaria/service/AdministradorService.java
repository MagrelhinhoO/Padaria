package app.padaria.service;

import app.padaria.model.Administrador;
import app.padaria.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> listarTodos() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> buscarPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public Administrador salvar(Administrador administrador) {
        // Regra de negócio: Verificar se email já está cadastrado
        if (administradorRepository.findByEmail(administrador.getEmail()).size() > 0) {
            throw new RuntimeException("Email já cadastrado");
        }
        return administradorRepository.save(administrador);
    }

    public void deletar(Long id) {
        administradorRepository.deleteById(id);
    }

    public List<Administrador> buscarPorNome(String nome) {
        return administradorRepository.findByNomeContainingIgnoreCase(nome);
    }
}