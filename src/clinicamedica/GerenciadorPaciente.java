/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface GerenciadorPaciente {
    public Paciente buscaPacientePeloNome(String nome);
    
    public void cadastrarPaciente(Paciente a);
    
    public void atualizaHistoricoDoencaPaciente(Paciente pac, Doenca doen);
    
    public ArrayList<RegistroConsulta> getRelatorioPaciente(Paciente pac, LocalDateTime dataInicio, LocalDateTime dataFim);
}
