package projeto.desafio.Aluguel.de.carros.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMAPPER {

    public UsuarioModel map(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        usuarioModel.setAluguelModel(usuarioDTO.getAluguelModel());

        return usuarioModel;
    }

    public UsuarioDTO map(UsuarioModel usuarioModel){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setCpf(usuarioModel.getCpf());
        usuarioDTO.setAluguelModel(usuarioModel.getAluguelModel());
        return usuarioDTO;
    }
}
