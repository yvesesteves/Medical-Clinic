/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public class Doenca {
    private String nomeDoenca;
    private String tipo;
    private String grau;
    private int ocorrencias;

    public Doenca(String nomeDoenca, String tipo, String grau, int ocorrencias) {
        this.nomeDoenca = nomeDoenca;
        this.tipo = tipo;
        this.grau = grau;
        this.ocorrencias = ocorrencias;
    }
    
    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
    
    public void incrementaOcorrencia(){
        this.ocorrencias++;
    }

    @Override
    public String toString() {
        return "Doenca{" + "nomeDoenca: " + nomeDoenca + "\ntipo: " + tipo + "\ngrau: " + grau + "\nocorrencias: " + ocorrencias + '}';
    }
    
    
}
