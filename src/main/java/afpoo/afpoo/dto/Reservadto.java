package afpoo.afpoo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import afpoo.afpoo.model.Cliente;
import afpoo.afpoo.model.Veiculo;

public class Reservadto {
    @NotBlank(message = "Cliente obrigatorio")
    Cliente cliente;
    @NotBlank(message = "Veiculo obrigatorio")
    Veiculo veiculo;
    @NotBlank(message = "Data obrigatorio")
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
