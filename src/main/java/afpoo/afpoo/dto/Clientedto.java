package afpoo.afpoo.dto;

import javax.validation.constraints.NotBlank;

public class Clientedto {

    @NotBlank(message = "Nome obrigatorio")
    String nome;
    @NotBlank(message = "Endereço obrigatorio")
    String Endereço;
    @NotBlank(message = "CPF obrigatorio")
    int cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        Endereço = endereço;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
