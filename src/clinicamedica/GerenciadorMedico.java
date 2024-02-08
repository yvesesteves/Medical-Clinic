/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public interface GerenciadorMedico {
    public Medico buscaMedicoPeloNome(String nome);
    
    public void cadastrarMedico(Medico a) ;
    
}
