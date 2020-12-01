package afpoo.afpoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import afpoo.afpoo.dto.Reservadto;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.service.Servicereserva;

@Controller
@RequestMapping("/reservas")
public class Controllerreserva {
    
    @Autowired
    private Servicereserva service;

    @GetMapping()
    public List<Reserva> getreservas(){
        return service.getlistadereservas();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Reserva> getreserva(@PathVariable int codigo){
        Reserva reserva = service.getreservaporcodigo(codigo);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Reservadto reservadto,HttpServletRequest request,UriComponentsBuilder builder){
        Reserva reserva = service.criarfromDTOreserva(reservadto);
        reserva = service.salvarreserva(reserva);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+reserva.getNum()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        service.removerreserva(codigo);
        return ResponseEntity.noContent().build();
    }
    
}
