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
public class Medico extends Pessoa {
    private String especialidade;
    private ArrayList <String> listaConvenios = new ArrayList();
    private ArrayList <RegistroConsulta> listaRegistroConsultas = new ArrayList();
    private ArrayList <ConsultasAgendadas> listaConsultasAgendadas = new ArrayList();
    private Agenda agenda;
    private ArrayList <Doenca> listaDoencas = new ArrayList();

    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email, Agenda agenda) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
        this.agenda = agenda;
    }
    
    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public ArrayList<Doenca> getListaDoencas() {
        return listaDoencas;
    }

    public void setListaDoencas(ArrayList<Doenca> listaDoencas) {
        this.listaDoencas = listaDoencas;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void setListaRegistroConsultas(ArrayList<RegistroConsulta> listaRegistroConsultas) {
        this.listaRegistroConsultas = listaRegistroConsultas;
    }
    
    @Override
    public String toString() {
        return super.toString()+ "\n Medico{" + "\nespecialidade: " + especialidade + "\nlistaConvenios: " + listaConvenios + "\nlistaDoencas: " + listaDoencas + '}';
    }
    
//    CONVENIO

    public ArrayList<String> getListaConvenios() {
        return listaConvenios;
    }

    public void addConvenio(String novoConvenio) {
        this.listaConvenios.add(novoConvenio);
    }
    
    public void removeConvenio(String nomeConvenio){
        for(String nome: this.listaConvenios){
            if(nome.equalsIgnoreCase(nomeConvenio)){
                this.listaConvenios.remove(nome);
                System.out.println("\n Convenio removido com sucesso");
            }
        }
        System.out.println("\n Convenio nao encontrado");
    }
    
//    DOENCA
    
    public void adicionaDoenca(Doenca a){
        this.listaDoencas.add(a);
    }
    
    public void incrementaDoenca(Doenca a){
        for(Doenca doenca: this.listaDoencas){
            if(a.getNomeDoenca().equals(doenca.getNomeDoenca())){
                doenca.incrementaOcorrencia();
            }
        }
    }
    
    public boolean doencaExiste(String a){
        for(Doenca doenca: this.listaDoencas){
            if(a.equals(doenca.getNomeDoenca())){
                return true;
            }
        }
        return false;
    }
    
    public Doenca buscaDoencaPeloNome(String a){
        for(Doenca doenca: this.listaDoencas){
            if(a.equals(doenca.getNomeDoenca())){
                return doenca;
            }
        }
        return null;
    }
    
//    REGISTRO CONSULTAS

    public ArrayList<RegistroConsulta> getListaRegistroConsultas() {
        return listaRegistroConsultas;
    }
    
    public ArrayList<RegistroConsulta> getFaixaRegistros(LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> listaConsultas = new ArrayList();
        
        for(RegistroConsulta registro: listaRegistroConsultas){
            if(registro.getDataConsulta().isAfter(dataInicio) && registro.getDataConsulta().isBefore(dataFim)){
                listaConsultas.add(registro);
            }
        }
        
        return listaConsultas;
    }
    
    public void registrarConsultaRealizada(Paciente pac, String bpm, String pressao, String temperatura, String diagnostico, ArrayList<Medicamento> listaMedicamentos) throws ConsultaException {
        LocalDateTime data = null;
        for(ConsultasAgendadas c: this.listaConsultasAgendadas){
            if(c.getPac().getNome().equals(pac.getNome())){
                data = c.getData();
                c.setIsRealizada(true);
            }
        }
        if(data == null){
            throw new ConsultaException("\n Consulta nao encontrada, talvez nao haja consultas agendadas");
        }else{
            RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico, listaMedicamentos);
            for(Medicamento medicamento: listaMedicamentos){
                medicamento.decrementaQuantidade();
                medicamento.incrementaUso();
            }
            this.listaRegistroConsultas.add(consultaRealizada);
        }
    }
    
    public void registrarConsultaRealizada(Paciente pac, String bpm, String pressao, String temperatura, String diagnostico) throws ConsultaException {
        LocalDateTime data = null;
        for(ConsultasAgendadas c: this.listaConsultasAgendadas){
            if(c.getPac().getNome().equals(pac.getNome())){
                data = c.getData();
                c.setIsRealizada(true);
            }
        }
        if(data == null){
            throw new ConsultaException("\n Consulta nao encontrada, talvez nao haja consultas agendadas");
        }else{
            RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico);
            this.listaRegistroConsultas.add(consultaRealizada);
        }
    }
    
//    CONSULTAS AGENDADAS
    
    public ArrayList<ConsultasAgendadas> getListaConsultasAgendadas() {
        return listaConsultasAgendadas;
    }

//    CONSULTAS REALIZADAS POR PACIENTE
    
    public ArrayList<RegistroConsulta> getHistoricoConsultasPorPaciente(Paciente pac, LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> listaConsultas = new ArrayList();
        
        for(RegistroConsulta registro: listaRegistroConsultas){
            if(registro.getNomePaciente().equals(pac.getNome()) && registro.getDataConsulta().isAfter(dataInicio) && registro.getDataConsulta().isBefore(dataFim)){
                listaConsultas.add(registro);
            }
        }
        return listaConsultas;
    }
    
    public String toCsv(){
        return super.getNome() + ";" +  super.getCpf() + ";" +  super.getIdade() + ";" + super.getRg();
    }

}
