package afpoo.afpoo.repository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    public Optional<Reserva> salvarreserva(Reserva reserva, Veiculo veiculo){
        if(reserva.getDatainicio().isAfter(LocalDateTime.now()) && reserva.getDatainicio().getDayOfWeek()!=DayOfWeek.SUNDAY){
            if(reserva.getDatafim().isAfter(reserva.getDatainicio()) && reserva.getDatafim().getDayOfWeek()!=DayOfWeek.SUNDAY){
                double horas = ChronoUnit.HOURS.between(reserva.getDatainicio(), reserva.getDatafim());
                reserva.setValorfinal(horas*veiculo.getValord());
                reserva.setNum(code++);
                reservas.add(reserva);
                return Optional.of(reserva);
            }
        }
        return Optional.empty();
    }

    public void removerreserva(Reserva reserva){
        reservas.remove(reserva);
    }

    public Optional<List<Reserva>> getreservaporcodigocliente(int codigo){
        List<Reserva> reser = new ArrayList<Reserva>();
        for(int i=0;i<reservas.size();i++){
            Reserva res=reservas.get(i);
            Cliente cliente = res.getCliente();
            if(cliente.getCodigo()==codigo){
                reser.add(res);
            }
        }
        if(reser.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(reser);
    }

    public Optional<List<Reserva>> getreservaporcodigoveiculo(int codigo){
        List<Reserva> reser = new ArrayList<Reserva>();
        for(int i=0;i<reservas.size();i++){
            Reserva res=reservas.get(i);
            Veiculo veiculo = res.getVeiculo();
            if(veiculo.getCodigo()==codigo){
                reser.add(res);
            }
        }
        if(reser.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(reser);
    }

    public Optional<Reserva> atualizar(Reserva reserva){
        Reserva res =getreservaporcodigo(reserva.getNum()).get();
        if(res!=null){
            if(res.getDatainicio().isAfter(LocalDateTime.now()) && reserva.getDatainicio().getDayOfWeek()!=DayOfWeek.SUNDAY){
                if(res.getDatafim().isAfter(reserva.getDatainicio()) && reserva.getDatafim().getDayOfWeek()!=DayOfWeek.SUNDAY){
                    res.setCliente(reserva.getCliente());
                    res.setVeiculo(reserva.getVeiculo());
                    res.setDatainicio(reserva.getDatainicio());
                    res.setDatafim(reserva.getDatafim());
                    double horas = ChronoUnit.HOURS.between(reserva.getDatainicio(), reserva.getDatafim());
                    res.setValorfinal(horas*reserva.getVeiculo().getValord());
                    return Optional.of(res);
                }
                return Optional.empty();
            }
            else{
                return Optional.empty();
            }
        }
        else{
            return Optional.empty();
        }

    }
}
