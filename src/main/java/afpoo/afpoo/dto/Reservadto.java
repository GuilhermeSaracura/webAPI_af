package afpoo.afpoo.dto;

import java.time.LocalDateTime;

import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.model.Veiculo;

public class Reservadto {

    Cliente cliente;
    Veiculo veiculo;
    LocalDateTime datainicio;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDateTime datainicio) {
        this.datainicio = datainicio;
    }
    
}
