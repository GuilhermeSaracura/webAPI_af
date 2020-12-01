package afpoo.afpoo.dto;

import javax.validation.constraints.NotBlank;

public class Veiculodto {
    @NotBlank(message = "Modelo obrigatorio")
    String modelo;
    @NotBlank(message = "Valor obrigatorio")
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
