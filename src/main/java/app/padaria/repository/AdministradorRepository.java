package app.padaria.repository;

import app.padaria.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    List<Administrador> findByNomeContainingIgnoreCase(String nome);

    List<Administrador> findByEmail(String email);
}