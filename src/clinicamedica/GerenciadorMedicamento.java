/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public interface GerenciadorMedicamento {
    public void cadastraMedicamento(Medicamento a);
    
    public Medicamento buscaMedicamentoPeloNome(String nome);
    
    public void setarEstoqueMedicamento(int quantidade, String nome);
    
    public void getUtilizacaoMedicamentos();
}
