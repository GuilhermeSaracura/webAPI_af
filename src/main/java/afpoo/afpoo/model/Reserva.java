package afpoo.afpoo.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class Reserva {
    int num;
    @NotBlank(message = "Cliente obrigatorio")
    Cliente cliente;
    @NotBlank(message = "Veiculo obrigatorio")
    Veiculo veiculo;
    @NotBlank(message = "Data de inicio obrigatorio")
    LocalDateTime datainicio;
    @NotBlank(message = "Data de fim obrigatorio")
    LocalDateTime datafim;
    double valorfinal;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

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

    public LocalDateTime getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDateTime datafim) {
        this.datafim = datafim;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }
}
