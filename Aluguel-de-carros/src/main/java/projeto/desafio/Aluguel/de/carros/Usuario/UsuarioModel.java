package projeto.desafio.Aluguel.de.carros.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.desafio.Aluguel.de.carros.Aluguel.AluguelModel;
import projeto.desafio.Aluguel.de.carros.Carro.CarroModel;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @OneToOne
    private AluguelModel aluguelModel;
}
