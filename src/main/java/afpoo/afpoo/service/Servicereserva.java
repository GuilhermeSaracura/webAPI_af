package afpoo.afpoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import afpoo.afpoo.dto.Reservadto;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.repository.Repositoryreserva;

@Service
public class Servicereserva {

    @Autowired
    private Repositoryreserva repositorio;

    public Reserva criarfromDTOreserva(Reservadto dto){
        Reserva reserva = new Reserva();
        reserva.setCliente(dto.getCliente());
        reserva.setVeiculo(dto.getVeiculo());
        reserva.setDatainicio(dto.getDatainicio());

        return reserva;
    }

    public Reserva atualizarfromDTOreserva(Reservadto dto){
        Reserva reserva = new Reserva();
        reserva.setCliente(dto.getCliente());
        reserva.setVeiculo(dto.getVeiculo());
        reserva.setDatainicio(dto.getDatainicio());

        return reserva;
    }

    public List<Reserva> getlistadereservas(){
        return repositorio.getlistadereservas();
    }

    public Reserva getreservaporcodigo(int codigo){
        Optional<Reserva> res = repositorio.getreservaporcodigo(codigo);
        return res.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Reserva não cadastrada"));
    }

    public Reserva salvarreserva(Reserva cliente){
        return repositorio.salvarreserva(cliente);
    }

    public void removercliente(int codigo){
        repositorio.removerreserva(getreservaporcodigo(codigo));
    }

}
