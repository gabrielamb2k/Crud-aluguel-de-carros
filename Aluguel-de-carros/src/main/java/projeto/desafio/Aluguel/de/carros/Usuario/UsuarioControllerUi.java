package projeto.desafio.Aluguel.de.carros.Usuario;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario/ui")
public class UsuarioControllerUi {

    private final UsuarioService usuarioService;

    public UsuarioControllerUi(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastrar")
    public String criaUsuario(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "Usuario/adicionarUsuario";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute UsuarioDTO usuario, Model model) {
        model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "redirect:/carros/ui/listar";
    }
}
