package devandroid.glaucomv.apptesteparalistavip.model;

import androidx.annotation.NonNull;

public class Pessoa {

    // Construtor
    // Atributos
    // Métodos de acesso - Getter and Setter

    private String nome;
    private String sobrenome;
    private String parentesco;
    private String telefone;

    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @NonNull
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
