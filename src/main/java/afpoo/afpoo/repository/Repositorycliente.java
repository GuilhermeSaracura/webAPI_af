package afpoo.afpoo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import afpoo.afpoo.model.Cliente;

@Component
public class Repositorycliente {

    private ArrayList<Cliente> clientes;
    private int code;

    @PostConstruct
    public void criarclientes(){
        clientes = new ArrayList<Cliente>();
        code=1;
    }

    public List<Cliente> getListadeclientes(){
        return clientes;
    }

    public Optional<Cliente> getclienteporcodigo(int codigo){
        for(int i=0;i<clientes.size();i++){
            Cliente cli=clientes.get(i);
            if(cli.getCodigo()==codigo){
                return Optional.of(cli);
            }
        }
        return Optional.empty();
    }

    public Cliente salvarcliente(Cliente cliente){
        cliente.setCodigo(code++);
        clientes.add(cliente);
        return cliente;
    }

    public void removercliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public Optional<Cliente> atualizar(Cliente cliente){
        Cliente cli =getclienteporcodigo(cliente.getCodigo()).get();
        if(cli!=null){
            cli.setCpf(cliente.getCpf());
            cli.setNome(cliente.getNome());
            cli.setendereco(cliente.getendereco());
            return Optional.of(cli);
        }
        else{
            return Optional.empty();
        }
    }
}
