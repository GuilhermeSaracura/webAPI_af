package afpoo.afpoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import afpoo.afpoo.dto.Clientedto;
import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.service.Servicecliente;

@RestController
@RequestMapping("/clientes")
public class Controllercliente {
    
    @Autowired
    private Servicecliente service;

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
    public ResponseEntity<Void> salvar(@RequestBody Clientedto clientedto, HttpServletRequest request,UriComponentsBuilder builder){
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


    
}
