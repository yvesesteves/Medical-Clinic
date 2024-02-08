/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String rg;
    private String telefone;
    private String email;

    public Pessoa(String nome, String cpf, int idade, String rg, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "\n Pessoa{" + "nome: " + nome + "\ncpf: " + cpf + "\nidade: " + idade + "\nrg: " + rg + "\ntelefone: " + telefone + "\nemail: " + email + '}';
    }
}
