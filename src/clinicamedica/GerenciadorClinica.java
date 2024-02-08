/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;

/**
 *
 * @author lucas
 */
public interface GerenciadorClinica {
    public void agendarConsulta(Medico med, Paciente pac, LocalDateTime data) throws DataException ;
}
