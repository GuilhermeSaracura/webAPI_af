package afpoo.afpoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import afpoo.afpoo.dto.Clientedto;
import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.service.Servicecliente;
import afpoo.afpoo.service.Servicereserva;

@RestController
@RequestMapping("/clientes")
public class Controllercliente {
    
    @Autowired
    private Servicecliente service;
    private Servicereserva service2;


    @GetMapping()
    public List<Cliente> getclientes(){
        return service.getListadeclientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getcliente(@PathVariable int codigo){
        Cliente cliente = service.getclienteporcodigo(codigo);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@Valid @RequestBody Clientedto clientedto, HttpServletRequest request,UriComponentsBuilder builder){
        Cliente cliente = service.criarfromDTOcliente(clientedto);
        cliente = service.salvarcliente(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        service.removercliente(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codigo}/reservas")
    public List<Reserva> getreservaporcliente(@PathVariable int codigo){
        List<Reserva> reservas = service2.getreservaporcodigocliente(codigo);
        return reservas;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable int codigo, @RequestBody Clientedto clientedto){   
            Cliente cliente = service.altualizarfromDTOCliente(clientedto);
            cliente.setCodigo(codigo);
            // reserva = service.update(reserva);
            return ResponseEntity.ok(cliente);
       
    }    
}
