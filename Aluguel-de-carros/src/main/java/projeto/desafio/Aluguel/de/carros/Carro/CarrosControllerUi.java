package projeto.desafio.Aluguel.de.carros.Carro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carros/ui")
public class CarrosControllerUi {

    private final CarroService carroService;

    public CarrosControllerUi(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/listar")
    public String carrosDisponiveis(Model model){
        List<CarroModel> carros= carroService.carrosDisponiveis();
        model.addAttribute("carros", carros);
        return "Carros/listarCarros";
    }
}
