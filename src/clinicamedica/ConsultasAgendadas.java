/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;

/**
 *
 * @author lucas
 */
public class ConsultasAgendadas {
    private Paciente pac;
    private LocalDateTime data;
    private boolean isRealizada;

    public ConsultasAgendadas(Paciente pac, LocalDateTime data) {
        this.pac = pac;
        this.data = data;
        this.isRealizada = false;
    }
    
    public ConsultasAgendadas(Paciente pac, LocalDateTime data, boolean isRealizada) {
        this.pac = pac;
        this.data = data;
        this.isRealizada = isRealizada;
    }

    public boolean isIsRealizada() {
        return isRealizada;
    }

    public void setIsRealizada(boolean isRealizada) {
        this.isRealizada = isRealizada;
    }
    
    public Paciente getPac() {
        return pac;
    }

    public void setPac(Paciente pac) {
        this.pac = pac;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String conSultaRealizada = "Nao";
        if(this.isRealizada){
            conSultaRealizada = "Sim";
        }
        return "\n Consulta Agendada:  " + "\npaciente: " + pac.getNome() + "\ndata: " + data.toLocalDate() + " : " + data.toLocalTime() + "\nJa foi realizada: "+ conSultaRealizada;                      
    }
    
}
