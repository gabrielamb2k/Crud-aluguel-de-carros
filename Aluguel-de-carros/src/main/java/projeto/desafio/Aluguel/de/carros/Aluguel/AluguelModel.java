package projeto.desafio.Aluguel.de.carros.Aluguel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.desafio.Aluguel.de.carros.Carro.CarroModel;
import projeto.desafio.Aluguel.de.carros.Usuario.UsuarioDTO;
import projeto.desafio.Aluguel.de.carros.Usuario.UsuarioModel;


import java.time.LocalDate;


@Entity
@Table(name="aluguel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AluguelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_fim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name="carros_id")
    private CarroModel carros;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private UsuarioModel usuarioModel;
}
