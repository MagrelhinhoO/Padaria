package app.padaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do administrador é obrigatório")
    private String nome;

    @NotBlank(message = "O email do administrador é obrigatório")
    private String email;

    @NotBlank(message = "A senha do administrador é obrigatória")
    private String senha;

    private String nivelAcesso;
}