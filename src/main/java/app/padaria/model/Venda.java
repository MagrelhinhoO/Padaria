package app.padaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data da venda é obrigatória")
    private LocalDateTime dataVenda;

    @NotNull(message = "O valor total é obrigatório")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("compras")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "venda_produto",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    @JsonIgnoreProperties("vendas")
    private List<Produto> produtos;

    @PrePersist
    public void calcularValorTotal() {
        if (produtos != null && !produtos.isEmpty()) {
            this.valorTotal = produtos.stream()
                    .mapToDouble(Produto::getPreco)
                    .sum();
        } else {
            this.valorTotal = 0.0;
        }
    }
}