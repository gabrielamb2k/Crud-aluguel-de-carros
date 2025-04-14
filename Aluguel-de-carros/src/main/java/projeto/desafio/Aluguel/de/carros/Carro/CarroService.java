package projeto.desafio.Aluguel.de.carros.Carro;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<CarroModel> carrosDisponiveis(){
        List<CarroModel> carros= carroRepository.findAll();
        return carros;
    }

    public CarroModel adicionaCarro(CarroModel carro){
        CarroModel carroNovo = carroRepository.save(carro);
        return carroNovo;
    }

    public CarroModel buscarPorId(Long id){
        Optional<CarroModel> carroId = carroRepository.findById(id);
        return carroId.orElse(null);
    }
}
