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
public class Clinica implements GerenciadorMedicamento, GerenciadorMedico, GerenciadorPaciente, GerenciadorClinica {
    private String nome;
    private static ArrayList <Medico> listaMedicos = new ArrayList();
    private static ArrayList <Paciente> listaPacientes = new ArrayList();
    private static ArrayList <Medicamento> listaMedicamentos = new ArrayList();

    public Clinica() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }
    
    @Override
    public String toString() {
        return "Clinica{" + "nome=" + nome + '}';
    }
    
//    GERENCIA MEDICAMENTOS
    
    @Override
    public void cadastraMedicamento(Medicamento a){
        listaMedicamentos.add(a);
    }
    
    @Override
    public Medicamento buscaMedicamentoPeloNome(String nome){
        for(Medicamento medicamento: listaMedicamentos){
            if(nome.equals(medicamento.getNome())){
                return medicamento;
            }
        }
        return null;
    }
    
    @Override
    public void setarEstoqueMedicamento(int quantidade, String nome){
        Medicamento medicamento = buscaMedicamentoPeloNome(nome);
        medicamento.setQuantidadeEstoque(quantidade);
    }
    
    @Override
    public void getUtilizacaoMedicamentos(){
        for(Medicamento medicamento: listaMedicamentos){
            System.out.println("\nNome: "+ medicamento.getNome() + "\nQuantidade: " + medicamento.getQuantidadeEstoque() + "\nVezes usados: "+ medicamento.getQuantidadeUso());
        }
    }
    
//    GERENCIA MEDICO
    
    @Override
    public Medico buscaMedicoPeloNome(String nome){
        for(Medico med: listaMedicos){
            if(nome.equals(med.getNome())){
                return med;
            }
        }
        return null;
    }
    
    @Override
    public void cadastrarMedico(Medico a) {
        listaMedicos.add(a);
    }
    
//    GERENCIA PACIENTE
    
    @Override
    public Paciente buscaPacientePeloNome(String nome){
        for(Paciente pac: listaPacientes){
            if(nome.equals(pac.getNome())){
                return pac;
            }
        }
        return null;
    }
    
    @Override
    public void cadastrarPaciente(Paciente a){
        this.listaPacientes.add(a);
    }
    
    @Override
    public void atualizaHistoricoDoencaPaciente(Paciente pac, Doenca doen){
        pac.adicionaDoenca(doen);
    }
    
    @Override
    public ArrayList<RegistroConsulta> getRelatorioPaciente(Paciente pac, LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> totalListaConsultas = new ArrayList();
        
        for(Medico medico: listaMedicos){
           ArrayList<RegistroConsulta> listaPorMedico;
           listaPorMedico = medico.getHistoricoConsultasPorPaciente(pac, dataInicio, dataFim);
           for(RegistroConsulta reg: listaPorMedico){
               totalListaConsultas.add(reg);
           }
        }
        return totalListaConsultas;
    }
    
//    CLINICA
    
    @Override
    public void agendarConsulta(Medico med, Paciente pac, LocalDateTime data) throws DataException {
        LocalDateTime currentDate = LocalDateTime.now();
        if(data.isBefore(currentDate)){
            throw new DataException("\nData invalida!");
        }
        boolean isDataDisponivel = med.getAgenda().marcarAgenda(data);
        if(isDataDisponivel == true){
            ConsultasAgendadas novaConsulta = new ConsultasAgendadas(pac, data);
            med.getListaConsultasAgendadas().add(novaConsulta);
        }else{
            throw new DataException("\n Data desejada nao existe ou nao esta disponivel \n");
        } 
    }
    
}
