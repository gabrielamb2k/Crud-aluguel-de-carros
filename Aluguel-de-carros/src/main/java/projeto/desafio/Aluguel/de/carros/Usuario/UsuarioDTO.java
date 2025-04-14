package projeto.desafio.Aluguel.de.carros.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.desafio.Aluguel.de.carros.Aluguel.AluguelModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private AluguelModel aluguelModel;
}
