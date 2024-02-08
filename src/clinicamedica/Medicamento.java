/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

public class Medicamento {
    public String nome;
    public String Faixa;
    public int quantidadeEstoque;
    public int quantidadeUso;
    public String tipo;
    public String indicacao;

    public Medicamento(String nome, String Faixa, int quantidadeEstoque, int quantidadeUso, String tipo, String indicacao) {
        this.nome = nome;
        this.Faixa = Faixa;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeUso = quantidadeUso;
        this.tipo = tipo;
        this.indicacao = indicacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaixa() {
        return Faixa;
    }

    public void setFaixa(String Faixa) {
        this.Faixa = Faixa;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeUso() {
        return quantidadeUso;
    }

    public void setQuantidadeUso(int quantidadeUso) {
        this.quantidadeUso = quantidadeUso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    } 
    
    public void decrementaQuantidade(){
        this.quantidadeEstoque--;
    }
    
    public void incrementaQuantidade(){
        this.quantidadeEstoque++;
    }
    
    public void incrementaUso(){
        this.quantidadeUso++;
    }
    
    @Override
    public String toString() {
        return "Medicamento{" + "\nnome: " + nome + "\nFaixa: " + Faixa  + "\ntipo: " + tipo + "\nindicacao: " + indicacao + '}';
    }

}
