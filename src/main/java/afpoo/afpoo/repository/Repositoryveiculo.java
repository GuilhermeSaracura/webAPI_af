package afpoo.afpoo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import afpoo.afpoo.model.Veiculo;

@Component
public class Repositoryveiculo {
    
    private ArrayList<Veiculo> veiculos;
    private int code;

    @PostConstruct
    public void criarVeiculo(){
        veiculos = new ArrayList<Veiculo>();
        code=1;
    }

    public List<Veiculo> getlistadeveiculos(){
        return veiculos;
    }

    public Optional<Veiculo> getveiculoporcodigo(int codigo){
        for(int i=0;i<veiculos.size();i++){
            Veiculo vei = veiculos.get(i);
            if(vei.getCodigo()==codigo){
                return Optional.of(vei);
            }
        }
        return Optional.empty();
    }

    public Veiculo salvarveiculo(Veiculo veiculo){
        veiculo.setCodigo(code++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public void removerveiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public Optional<Veiculo> atualizar(Veiculo veiculo){
        Veiculo vei =getveiculoporcodigo(veiculo.getCodigo()).get();
        if(vei!=null){
            vei.setModelo(veiculo.getModelo());
            vei.setValord(veiculo.getValord());
            return Optional.of(vei);
        }
        else{
            return Optional.empty();
        }
    }
}
