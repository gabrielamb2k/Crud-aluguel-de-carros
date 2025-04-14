package projeto.desafio.Aluguel.de.carros.Carro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.desafio.Aluguel.de.carros.Aluguel.AluguelModel;

import java.util.List;

@Entity
@Table(name="carros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="assentos")
    private int assentos;

    @Column(name="valor_por_dia")
    private double valor;

    @Column(name="status")
    private boolean status;

    @OneToMany(mappedBy = "carros")
    @JsonIgnore
    private List<AluguelModel> aluguelModel;


}
