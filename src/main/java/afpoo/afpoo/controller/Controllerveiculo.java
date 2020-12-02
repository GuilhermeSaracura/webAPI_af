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

import afpoo.afpoo.dto.Veiculodto;
import afpoo.afpoo.model.Reserva;
import afpoo.afpoo.model.Veiculo;
import afpoo.afpoo.service.Servicereserva;
import afpoo.afpoo.service.Serviceveiculo;

@RestController
@RequestMapping("/veiculos")
public class Controllerveiculo {
    
    @Autowired
    private Serviceveiculo service;
    private Servicereserva service2;

    @GetMapping()
    public List<Veiculo> getveiculos(){
        return service.getlistadeveiculos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Veiculo> getveiculo(@PathVariable int codigo){
        Veiculo veiculo = service.getveiculoporcodigo(codigo);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@Valid @RequestBody Veiculodto veiculodto, HttpServletRequest request,UriComponentsBuilder builder){
        Veiculo veiculo = service.criarfromDTOVeiculo(veiculodto);
        veiculo = service.salvarveiculo(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+veiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        service.removerveiculo(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codigo}/reservas")
    public List<Reserva> getreservaporveiculo(@PathVariable int codigo){
        List<Reserva> reservas = service2.getreservaporcodigoveiculo(codigo);
        return reservas;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Veiculo> atualizar(@Valid @PathVariable int codigo, @RequestBody Veiculodto veiculodto){   
            Veiculo veiculo = service.atualizarfromDTOveiculo(veiculodto);
            veiculo.setCodigo(codigo);
            veiculo = service.atualizar(veiculo);
            return ResponseEntity.ok(veiculo);
       
    }
}
