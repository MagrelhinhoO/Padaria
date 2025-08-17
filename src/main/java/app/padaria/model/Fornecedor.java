package app.padaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do fornecedor é obrigatório")
    private String nome;

    @NotBlank(message = "O CNPJ do fornecedor é obrigatório")
    private String cnpj;

    @NotBlank(message = "O telefone do fornecedor é obrigatório")
    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnoreProperties("fornecedor")
    private List<Produto> produtos;
}