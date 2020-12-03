package afpoo.afpoo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cliente {
    int codigo;
    @NotBlank(message = "Nome obrigatorio")
    String nome;
    @NotBlank(message = "Endereço obrigatorio")
    String endereco;
    @NotBlank(message = "CPF obrigatorio")
    @Size(min=9, max=9)
    String cpf;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
