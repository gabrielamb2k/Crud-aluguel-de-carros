package projeto.desafio.Aluguel.de.carros.Carro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<CarroModel>> carrosDisponiveis(){
        List<CarroModel> carros = carroService.carrosDisponiveis();
        return ResponseEntity.ok(carros);
    }

    @PostMapping("/novo")
    public ResponseEntity<String> adicionaCarro(@RequestBody CarroModel carroModel){
        CarroModel carroNovo = carroService.adicionaCarro(carroModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro adicionado");
    }
}
