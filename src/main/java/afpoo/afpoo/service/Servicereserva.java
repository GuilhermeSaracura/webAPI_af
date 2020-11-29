package afpoo.afpoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Reserva> getlistadereserva(){
        return repositorio.getlistadereserva();
    }

}
