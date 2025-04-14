package projeto.desafio.Aluguel.de.carros.Usuario;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<String> criaUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO novoUsuario = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado com sucesso");
    }
}
