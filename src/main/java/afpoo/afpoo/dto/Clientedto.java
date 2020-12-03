package afpoo.afpoo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Clientedto {

    @NotBlank(message = "Nome obrigatorio")
    String nome;
    @NotBlank(message = "Endereço obrigatorio")
    String endereco;
    @NotBlank(message = "CPF obrigatorio")
    @Size(min=9, max=9)
    String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
