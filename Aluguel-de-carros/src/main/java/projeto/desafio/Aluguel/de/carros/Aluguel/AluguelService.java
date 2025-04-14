package projeto.desafio.Aluguel.de.carros.Aluguel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    private final AluguelRespository aluguelRespository;

    public AluguelService(AluguelRespository aluguelRespository) {
        this.aluguelRespository = aluguelRespository;
    }

    public AluguelModel alugar(AluguelModel aluguelModel){
       AluguelModel alugar = new AluguelModel();
       alugar = aluguelRespository.save(alugar);
       return  alugar;
    }

    public List<AluguelModel> listarAlugados(){
        List<AluguelModel> alugados = aluguelRespository.findAll();
        return alugados;
    }
}
