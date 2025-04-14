package projeto.desafio.Aluguel.de.carros.Aluguel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping
    public ResponseEntity<String> aluguel(@RequestBody AluguelModel aluguelModel){
        AluguelModel novoAluguel = new AluguelModel();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Aluguel feito com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AluguelModel>> listarAlugados(){
        List<AluguelModel> alugados = aluguelService.listarAlugados();
        return ResponseEntity.ok(alugados);
    }

}
