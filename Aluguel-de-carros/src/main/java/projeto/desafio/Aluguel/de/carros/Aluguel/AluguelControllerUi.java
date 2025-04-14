package projeto.desafio.Aluguel.de.carros.Aluguel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.desafio.Aluguel.de.carros.Carro.CarroModel;
import projeto.desafio.Aluguel.de.carros.Carro.CarroService;
import projeto.desafio.Aluguel.de.carros.Usuario.UsuarioDTO;
import projeto.desafio.Aluguel.de.carros.Usuario.UsuarioModel;
import projeto.desafio.Aluguel.de.carros.Usuario.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("aluguel/ui")
public class AluguelControllerUi {

    private final AluguelService aluguelService;
    private final CarroService carroService;
    private final UsuarioService usuarioService;

    public AluguelControllerUi(AluguelService aluguelService, CarroService carroService, UsuarioService usuarioService) {
        this.aluguelService = aluguelService;
        this.carroService = carroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/alugar/{carroId}")
    public String alugarCarro(@PathVariable Long carroId, Model model) {
        CarroModel carro = carroService.buscarPorId(carroId); // Busca o carro no banco
        List<UsuarioDTO> usuarios = usuarioService.listar(); // Busca todos os usuários

        AluguelModel aluguel = new AluguelModel();
        aluguel.setCarros(carro); // Pré-seleciona o carro

        model.addAttribute("aluguel", aluguel);
        model.addAttribute("carroSelecionado", carro);
        model.addAttribute("usuarios", usuarios); // Passa a lista de usuários para a view
        return "Aluguel/alugarCarro"; // Retorna a view de aluguel
    }

    @PostMapping("/alugar/{carroId}")
    public String confirmarAluguel(@PathVariable Long carroId, @ModelAttribute AluguelModel aluguel, Model model) {
        aluguelService.alugar(aluguel); // Salva o aluguel no banco
        model.addAttribute("mensagem", "Veículo alugado com sucesso!");
        return "redirect:/carros/ui/listar";  // Redireciona para a lista de carros
    }
}