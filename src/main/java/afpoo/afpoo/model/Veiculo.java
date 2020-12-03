package afpoo.afpoo.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class Veiculo {
    int codigo;
    @NotBlank(message = "Modelo obrigatorio")
    String modelo;
    @Digits(integer=6, fraction=2)
    double valord;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
