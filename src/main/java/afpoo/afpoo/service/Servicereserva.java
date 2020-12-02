package afpoo.afpoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import afpoo.afpoo.dto.Reservadto;
import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.model.Veiculo;
import afpoo.afpoo.repository.Repositoryreserva;

@Service
public class Servicereserva {

    @Autowired
    private Repositoryreserva repositorio;
    private Servicecliente service1;
    private Serviceveiculo service2;

    public Reserva criarfromDTOreserva(Reservadto dto){
        Reserva reserva = new Reserva();
        reserva.setCliente(dto.getCliente());
        reserva.setVeiculo(dto.getVeiculo());
        reserva.setDatainicio(dto.getDatainicio());
        reserva.setDatafim(dto.getDatafim());
        return reserva;
    }

    public Reserva atualizarfromDTOreserva(Reservadto dto){
        Reserva reserva = new Reserva();
        reserva.setCliente(dto.getCliente());
        reserva.setVeiculo(dto.getVeiculo());
        reserva.setDatainicio(dto.getDatainicio());
        reserva.setDatafim(dto.getDatafim());
        return reserva;
    }

    public List<Reserva> getlistadereservas(){
        return repositorio.getlistadereservas();
    }

    public Reserva getreservaporcodigo(int codigo){
        Optional<Reserva> res = repositorio.getreservaporcodigo(codigo);
        return res.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Reserva não cadastrada"));
    }

    public Reserva salvarreserva(Reserva reserva){
        Cliente clienteres = reserva.getCliente();
        Veiculo veiculores = reserva.getVeiculo();
        service1.getclienteporcodigo(clienteres.getCodigo());
        service2.getveiculoporcodigo(veiculores.getCodigo());
        Optional<Reserva> res = repositorio.salvarreserva(reserva,service2.getveiculoporcodigo(veiculores.getCodigo()));
        return res.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Náo foi possível cadastrar a reserva, algum dado foi inserido de forma incorreta"));
    }

    public void removerreserva(int codigo){
        repositorio.removerreserva(getreservaporcodigo(codigo));
    }  

    public List<Reserva> getreservaporcodigocliente(int codigo){
        Optional<List<Reserva>> res = repositorio.getreservaporcodigocliente(codigo);
        return res.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Náo foi encontrado nenhuma reserva"));
    }

    public List<Reserva> getreservaporcodigoveiculo(int codigo){
        Optional<List<Reserva>> res = repositorio.getreservaporcodigoveiculo(codigo);
        return res.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Náo foi encontrado nenhuma reserva"));
    }

    public Reserva atualizar(Reserva reserva){
        Cliente clienteres = reserva.getCliente();
        Veiculo veiculores = reserva.getVeiculo();
        service1.getclienteporcodigo(clienteres.getCodigo());
        service2.getveiculoporcodigo(veiculores.getCodigo());
        Optional<Reserva> op = repositorio.atualizar(reserva);
        return op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Veiculo náo atualizado"));
    }

}
