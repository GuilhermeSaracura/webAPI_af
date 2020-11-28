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

import afpoo.afpoo.dto.Veiculodto;
import afpoo.afpoo.model.Veiculo;
import afpoo.afpoo.service.Serviceveiculo;

@RestController
@RequestMapping("/veiculos")
public class Controllerveiculo {
    
    @Autowired
    private Serviceveiculo service;

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
    public ResponseEntity<Void> salvar(@RequestBody Veiculodto veiculodto, HttpServletRequest request,UriComponentsBuilder builder){
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
}
