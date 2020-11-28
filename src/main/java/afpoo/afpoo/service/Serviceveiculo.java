package afpoo.afpoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import afpoo.afpoo.dto.Veiculodto;
import afpoo.afpoo.model.Veiculo;
import afpoo.afpoo.repository.Repositoryveiculo;

@Service
public class Serviceveiculo {

    @Autowired
    private Repositoryveiculo repositorio;

    public Veiculo criarfromDTOVeiculo(Veiculodto dto){
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValord(dto.getValord());

        return veiculo;
    }

    public Veiculo atualizarfromDTOveiculo (Veiculodto dto){
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValord(dto.getValord());

        return veiculo;
    }

    public List<Veiculo> getlistadeveiculos(){
        return repositorio.getlistadeveiculos();
    }

    public Veiculo getveiculoporcodigo(int codigo){
        Optional<Veiculo> op = repositorio.getveiculoporcodigo(codigo);
        return op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Veiculo náo cadastrado"));
    }

    public Veiculo salvarveiculo(Veiculo veiculo){
        return repositorio.salvarveiculo(veiculo);
    }

    public void removerveiculo(int codigo){
        repositorio.removerveiculo(getveiculoporcodigo(codigo));
    }
}
