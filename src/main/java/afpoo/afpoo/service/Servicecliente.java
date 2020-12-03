package afpoo.afpoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import afpoo.afpoo.dto.Clientedto;
import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.repository.Repositorycliente;

@Service
public class Servicecliente {
    
    @Autowired
    private Repositorycliente repositorio;

    public Cliente criarfromDTOcliente(Clientedto dto){
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setEndereço(dto.getEndereco());
        return cliente;
    }

    public Cliente altualizarfromDTOCliente(Clientedto dto){
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setEndereço(dto.getEndereco());
        return cliente;
    }

    public List<Cliente> getListadeclientes(){
        return repositorio.getListadeclientes();
    }

    public Cliente getclienteporcodigo(int codigo){
        Optional<Cliente> cli = repositorio.getclienteporcodigo(codigo);
        return cli.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não cadastrado"));
    }

    public Cliente salvarcliente(Cliente cliente){
        return repositorio.salvarcliente(cliente);
    }

    public void removercliente(int codigo){
        repositorio.removercliente(getclienteporcodigo(codigo));
    }

    public Cliente atualizar(Cliente cliente){
        getclienteporcodigo(cliente.getCodigo());
        Optional<Cliente> op = repositorio.atualizar(cliente);
        return op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente náo atualizado"));
    }
}
