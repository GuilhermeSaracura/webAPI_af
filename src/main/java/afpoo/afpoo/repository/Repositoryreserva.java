package afpoo.afpoo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.model.Veiculo;

@Component
public class Repositoryreserva {
    
    private ArrayList<Reserva> reservas;
    private int code;

    @PostConstruct
    public void criarreserva(){
        reservas = new ArrayList<Reserva>();
        code=1;
    }

    public List<Reserva> getlistadereservas(){
        return reservas;
    }

    public Optional<Reserva> getreservaporcodigo(int codigo){
        for(int i=0;i<reservas.size();i++){
            Reserva res=reservas.get(i);
            if(res.getNum()==codigo){
                return Optional.of(res);
            }
        }
        return Optional.empty();
    }

    public Reserva salvarreserva(Reserva reserva){
        reserva.setNum(code++);
        reservas.add(reserva);
        return reserva;
    }

    public void removerreserva(Reserva reserva){
        reservas.remove(reserva);
    }

    public Optional<List<Reserva>> getreservaporcodigocliente(int codigo){
        List<Reserva> reservas=null;
        for(int i=0;i<reservas.size();i++){
            Reserva res=reservas.get(i);
            Cliente cliente = res.getCliente();
            if(cliente.getCodigo()==codigo){
                reservas.add(res);
            }
        }
        if(reservas==null){
            return Optional.of(reservas);
        }
        else{
            return Optional.empty();
        }
    }

    public Optional<List<Reserva>> getreservaporcodigoveiculo(int codigo){
        List<Reserva> reservas=null;
        for(int i=0;i<reservas.size();i++){
            Reserva res=reservas.get(i);
            Veiculo veiculo = res.getVeiculo();
            if(veiculo.getCodigo()==codigo){
                reservas.add(res);
            }
        }
        if(reservas==null){
            return Optional.of(reservas);
        }
        else{
            return Optional.empty();
        }
    }
}
