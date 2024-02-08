/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class RegistroConsulta {
    private String nomePaciente;
    private String nomeMedico;
    private String especialidadeMedico;
    private LocalDateTime dataConsulta;
    private String bpm;
    private String pressao;
    private String temperatura;
    private ArrayList <Medicamento> medicamentosIndicados = new ArrayList();
    private String observacao;

    public RegistroConsulta(String nomePaciente, String nomeMedico, String especialidadeMedico, LocalDateTime dataConsulta, String bpm, String pressao, String temperatura, String observacao, ArrayList <Medicamento> listaMedicamentos) {
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.dataConsulta = dataConsulta;
        this.bpm = bpm;
        this.pressao = pressao;
        this.temperatura = temperatura;
        this.observacao = observacao;
        this.medicamentosIndicados = listaMedicamentos;
    }
    
    public RegistroConsulta(String nomePaciente, String nomeMedico, String especialidadeMedico, LocalDateTime dataConsulta, String bpm, String pressao, String temperatura, String observacao) {
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.dataConsulta = dataConsulta;
        this.bpm = bpm;
        this.pressao = pressao;
        this.temperatura = temperatura;
        this.observacao = observacao;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public String getBpm() {
        return bpm;
    }

    public String getPressao() {
        return pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public ArrayList<Medicamento> getMedicamentosIndicados() {
        return medicamentosIndicados;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setMedicamentosIndicados(ArrayList<Medicamento> medicamentosIndicados) {
        this.medicamentosIndicados = medicamentosIndicados;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getRegistroRealizadoParaPaciente(){
        return "\nPaciente: " + this.nomePaciente + "\nMedico: " + this.nomeMedico + "\nData realizada: "+ this.getDataConsulta().toLocalDate() + " : " + this.getDataConsulta().toLocalTime()+"\n";
    }
    
    public String getRegistroRealizadoParaMedico(){
        return "\nNome do paciente :" + this.nomePaciente + "\nData realizada: "+ this.getDataConsulta().toLocalDate() + " : " + this.getDataConsulta().toLocalTime()+"\n";
    }
    
    public String getRegistroRealizadoDePacienteParaMedico(){
        return "data da consulta=" + dataConsulta.toLocalDate() + " : " + dataConsulta.toLocalTime() + "\nbpm: " + bpm + "\n pressao: " + pressao + "\ntemperatura: " + temperatura + "\nmedicamentos indicados: " + medicamentosIndicados.toString() + "\n observacao: " + observacao + '}';
    }
    
    public String getRegistroRealizadoParaClinia(){
        return "\nNome do medico :" + this.nomeMedico + "\nNome do paciente :" + this.nomePaciente + "\nData realizada: "+ this.getDataConsulta().toLocalDate() + " : " + this.getDataConsulta().toLocalTime()+"\n";
    }

    @Override
    public String toString() {
        return "\nRegistro Consulta{" + "nome Paciente=" + nomePaciente + ", nome Medico=" + nomeMedico + ", especialidade Medico=" + especialidadeMedico + ", data Consulta=" + dataConsulta.toLocalDate() + " : " + dataConsulta.toLocalTime() + ", bpm=" + bpm + ", pressao=" + pressao + ", temperatura=" + temperatura + ", medicamentos Indicados=" + medicamentosIndicados.toString() + ", observacao=" + observacao + '}';
    }   
    
    
}
