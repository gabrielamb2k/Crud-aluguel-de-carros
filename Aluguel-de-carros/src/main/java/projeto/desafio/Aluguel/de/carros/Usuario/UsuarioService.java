package projeto.desafio.Aluguel.de.carros.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMAPPER usuarioMAPPER;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMAPPER usuarioMAPPER) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMAPPER = usuarioMAPPER;
    }

    public UsuarioDTO criar(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMAPPER.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMAPPER.map(usuario);
    }

    public List<UsuarioDTO> listar(){
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMAPPER::map)
                .collect(Collectors.toList());
    }
}
