package afpoo.afpoo.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class Veiculodto {
    @NotBlank(message = "Modelo obrigatorio")
    String modelo;
    @Digits(integer=6, fraction=2)
    double valord;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValord() {
        return valord;
    }

    public void setValord(double valord) {
        this.valord = valord;
    }
}
