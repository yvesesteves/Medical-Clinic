/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicamedica;

import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ClinicaMedica {
    public static Clinica clinica = new Clinica();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int op = -1;

        ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
        try {
            listaMedicamentos = Arquivos.importaMedicamento("medicamentos.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        for(Medicamento medicamento: listaMedicamentos){
            clinica.cadastraMedicamento(medicamento);
        }
        
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        try {
            listaMedicos = Arquivos.importaMedicos("medicos.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {            
            for(Medico me: listaMedicos){
                clinica.cadastrarMedico(me);
                me.setAgenda(new Agenda(Arquivos.importaDatas("datas.txt")));
            }
        } catch (DataException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        try {
            listaPacientes = Arquivos.importaPacientes("pacientes.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        for(Paciente paciente: listaPacientes){
            clinica.cadastrarPaciente(paciente);
        }
        
        
        while(op != 30){
            System.out.println("=== CLINICA MEDICA ===");
            //System.out.println("1 - Cadastrar Clinica");
            System.out.println("2 - CLINICA - Cadastrar Medico");
            System.out.println("3 - CLINICA - Cadastrar Paciente");
            System.out.println("4 - MEDICO - Adicionar convenio");
            System.out.println("5 - PACIENTE - Agendar consulta");
            System.out.println("6 - MEDICO - Registrar Consulta Realizada");
            System.out.println("7 - CLINICA - Historico de utilizacao dos medicamentos");
            System.out.println("8 - CLINICA - Listar medicos");
            System.out.println("9 - CLINICA - Listar pacientes");
            System.out.println("10 - MEDICO - Ver consultas agendadas por medico");
            System.out.println("11 - MEDICO - Ver consultas registradas por medico / relatorio do medico");
            System.out.println("12 - CLINICA - Cadastrar medicamento");
            System.out.println("13 - MEDICO - Adicionar data disponivel na agenda");
            System.out.println("14 - MEDICO - Ver datas disponiveis");
            System.out.println("15 - CLINICA - Listar medicamentos");
            System.out.println("16 - PACIENTE - Atualizar historico de doencas");
            System.out.println("17 - PACIENTE - Ver historico de consultas / relatorio paciente");
            System.out.println("18 - CLINICA - Ver historico de consultas de todos os medicos / relatorio clinica");
            System.out.println("19 - CLINICA - Ver todas consultas agendadas / relatorio clinica");
            System.out.println("20 - MEDICO - Ver detalhes/historico de consultas de um paciente / relatorio do medico");
            System.out.println("21 - PACIENTE - Ver historico de consultas agendadas com medico");
            System.out.println("30 - sair");
            
            op = sc.nextInt();
            sc.nextLine();
            
            
            String especialidade;
            String nome;
            String nomeDoenca;
            String cpf;
            String idade;
            String rg; 
            
            String telefone;
            String email;
            Agenda agenda;
            Medico medico;
            
            Paciente paciente;
            
            String dia;
            String mes;
            String ano;
            String hora;
            String minuto;
            String tipo;
            String grau;
            String qtd_vezes;
            LocalDateTime dataInicio;
            LocalDateTime dataFim;
            int cont = 0;
            ArrayList<Medico> listaTodosMedicos;
            
            
            switch (op){
                case 1:
                    clinica.setNome("Clinica 1");
                    System.out.println(clinica.toString());
                    break;
                case 2:
                    try {
                        System.out.println("Nome do medico: ");
                        nome = sc.nextLine();
                        System.out.println("cpf: ");
                        cpf = sc.nextLine();
                        System.out.println("rg: ");
                        rg = sc.nextLine();
                        System.out.println("especialidade: ");
                        especialidade = sc.nextLine();
                        System.out.println("idade: ");
                        idade = sc.nextLine();
                        System.out.println("telefone: ");
                        telefone = sc.nextLine();
                        System.out.println("email: ");
                        email = sc.nextLine();
                        System.out.println("Quantas datas deseja cadastrar como disponiveis para iniciar os atendimentos? ");
                        String contadorText = sc.nextLine();
                        cont = Integer.parseInt(contadorText);
                        ArrayList <LocalDateTime> datasDisponiveis = new ArrayList();
                        LocalDateTime d;
                    
                    for(int i=1;i<=cont;i++){
                        System.out.println("data "+ i +": ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        
                        d = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        
                        System.out.println("Data final: "+ d.toString());
                        datasDisponiveis.add(d);
                    }
                    
                    agenda = new Agenda(datasDisponiveis);
                    
                    medico = new Medico(especialidade, nome, cpf, Integer.parseInt(idade), rg, telefone, email, agenda);
                    System.out.println("\nMedico Cadastrado com sucesso");
                    System.out.println("\n"+medico.toString());
                    clinica.cadastrarMedico(medico);
                } catch (NullPointerException e) {
                    System.out.println("\n Valores nulos nao sao aceitos");
                }
                catch(NumberFormatException ex){
                    System.out.println("\n Datas devem ser numericos: "+ ex.getMessage());
                }
                catch(DateTimeException ex){
                    System.out.println("\n Datas invalida: "+ ex.getMessage());
                } catch (DataException ex) {
                    System.out.println(ex.getMessage());
                }
                    
                    break;


                case 3:
                    try {
                        System.out.println("Nome do paciente: ");
                        nome = sc.nextLine();
                        System.out.println("cpf: ");
                        cpf = sc.nextLine();
                        System.out.println("rg: ");
                        rg = sc.nextLine();
                        System.out.println("idade: ");
                        idade = sc.nextLine();
                        System.out.println("telefone: ");
                        telefone = sc.nextLine();
                        System.out.println("email: ");
                        email = sc.nextLine();



                        System.out.println("Doencas que ja teve");
                        System.out.println("Quantas doencas deseja cadastrar: ");
                        String contadorString = sc.nextLine();

                        cont = Integer.parseInt(contadorString);
                        ArrayList <Doenca> doencas = new ArrayList();
                        Doenca d1;
                        for(int i = 0;i<cont;i++){
                            System.out.println("nome: ");
                            nomeDoenca = sc.nextLine();
                            System.out.println("tipo: ");
                            tipo = sc.nextLine();
                            System.out.println("grau: ");
                            grau = sc.nextLine();
                            System.out.println("quantas vezes: ");
                            qtd_vezes = sc.nextLine();


                            d1 = new Doenca(nomeDoenca, tipo, grau, Integer.parseInt(qtd_vezes));
                            doencas.add(d1);
                        }

                        paciente = new Paciente(doencas, nome, cpf, Integer.parseInt(idade), rg, telefone,  email);
                        clinica.cadastrarPaciente(paciente);
                        
                        System.out.println("\nPaciente cadastrado com sucesso");
                        System.out.println("\n"+ paciente.toString());
                    
                        
                        } catch (NumberFormatException e) {
                            System.out.println("\n Numero de doencas e idade devem ser numericos: "+e.getMessage());
                        }
                        catch(NullPointerException ex){
                            System.out.println("\nValores nulos nao sao aceitos: "+ ex.getMessage());
                        }
                    break;
                case 4:
                    try {
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica.buscaMedicoPeloNome(nome);
                    
                    System.out.println("Nome do convenio: ");
                    nome = sc.nextLine();
                    
                    medico.addConvenio(nome);
                    System.out.println("\n Convenio cadastrado com sucesso\n Medico: "+ medico.getNome()+"\nConvenio: "+nome);
                    } catch (NullPointerException e) {
                        System.out.println("\nMedico nao existe, verifique o nome inserido");
                    }

                    break;
                case 5:
                    try{
                        System.out.println("Nome do paciente: ");
                        nome = sc.nextLine();
                        paciente = clinica.buscaPacientePeloNome(nome);
                        
                        System.out.println("\n====Medicos da clinica====\n");
                        for(Medico m: clinica.getListaMedicos()){
                            System.out.println("\nNome: "+ m.getNome());
                            System.out.println("Especialidade: "+ m.getEspecialidade());
                            if(!m.getListaDoencas().isEmpty()){
                                System.out.println("\nDoencas que ja tratou: ");
                                for(Doenca d: m.getListaDoencas()){
                                    System.out.println("\n"+ d.getNomeDoenca() + "\nQuantidade de vezes que ja tratou: " + d.getOcorrencias());
                                }
                            }
                        }
                        System.out.println("\n========\n");
                        
                        System.out.println("Qual medico deseja consultar: ");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);

                        System.out.println("\n==== Datas Disponiveis de "+ medico.getNome() +" ====\n");
                        for(LocalDateTime data: medico.getAgenda().getListaDatasDisponiveis()){
                            System.out.println("\n"+data.toLocalDate() + " : " + data.toLocalTime()+"\n");
                        }
                        System.out.println("\n==========\n");

                        LocalDateTime dataDesejada;

                        System.out.println("data desejada: ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        dataDesejada = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));

                        clinica.agendarConsulta(medico, paciente, dataDesejada);
                        
                        System.out.println("\n Consulta agendada com sucesso\n Paciente: " + paciente.getNome());
                        System.out.println("\nMedico: " + medico.getNome());
                        System.out.println("\n Data: "+dataDesejada.toLocalDate() + " : " + dataDesejada.toLocalTime());
                    }
                    catch (NullPointerException e) {
                        System.out.println("\nMedico e/ou paciente nao existe, verifique o nome inserido");
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\nInformacoes de data e hora devem ser numericos: "+e.getMessage());
                    } catch (DataException ex) {
                        System.out.println(ex.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\n Datas invalida: "+ ex.getMessage());
                    }
                                        
                    break;

                case 6:
                    try {
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica.buscaMedicoPeloNome(nome);
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica.buscaPacientePeloNome(nome);
                    
                    System.out.println("Batimentos por minuto: ");
                    String bpm = sc.nextLine();
                    System.out.println("pressao: ");
                    String pressao = sc.nextLine();
                    System.out.println("temperatura: ");
                    String temperatura = sc.nextLine();
                    System.out.println("Diagnostico e observacoes: ");
                    String diagnostico = sc.nextLine();
                    
                    System.out.println("\n==== Medicamentos Disponiveis ====\n");
                    for(Medicamento medicamento: clinica.getListaMedicamentos()){
                        System.out.println("\n"+medicamento.toString()+"\n");
                    }
                    System.out.println("\n==========\n");
                    
                    System.out.println("\nNome do medicamento: ");
                    nome = sc.nextLine();
                    Medicamento medicamento1 = clinica.buscaMedicamentoPeloNome(nome);
                    ArrayList<Medicamento> listaMedicamentosPreescritos = new ArrayList();
                    listaMedicamentosPreescritos.add(medicamento1);
                    
//                    System.out.println("data realizada: ");
//                    System.out.println("dia: ");
//                    dia = sc.nextLine();
//                    System.out.println("mes: ");
//                    mes = sc.nextLine();
//                    System.out.println("ano: ");
//                    ano = sc.nextLine();
//                    System.out.println("hora: ");
//                    hora = sc.nextLine();
//                    System.out.println("minuto: ");
//                    minuto = sc.nextLine();
//                    LocalDateTime dataRealizada = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    
                    System.out.println("\nHouve alguma doenca sobre o paciente?\n");
                    System.out.println("\n1. sim");
                    System.out.println("\n2. nao");
                    int houveDoenca = Integer.parseInt(sc.nextLine());
                    if(houveDoenca == 1){
                        System.out.println("\nNome da doenca: ");
                        nomeDoenca = sc.nextLine();
                        boolean isDoencaExisteMedico = medico.doencaExiste(nomeDoenca);
                        boolean isDoencaExistePaciente = paciente.doencaExiste(nomeDoenca);
                        if(isDoencaExisteMedico){
                            //incremente doenca medico
                            Doenca doencaMedico = medico.buscaDoencaPeloNome(nomeDoenca);
                            medico.incrementaDoenca(doencaMedico);
                        }else{
                            //cadastra doenca medico
                            System.out.println("\n Voce nunca havia tratado dessa doenca antes");
                            System.out.println("\n Favor cadastrar estas informacoes a respeito dessa doenca para incluir em seu historico");
                            System.out.println("tipo: ");
                            tipo = sc.nextLine();
                            System.out.println("grau: ");
                            grau = sc.nextLine();
                            Doenca doencaMedico;
                            doencaMedico = new Doenca(nomeDoenca, tipo, grau, 1);
                            medico.adicionaDoenca(doencaMedico);
                            System.out.println("\nDoenca Cadastrada com sucesso!");
                        }
                        if(isDoencaExistePaciente){
                            //incremente doenca paciente
                            Doenca doencaPaciente = medico.buscaDoencaPeloNome(nomeDoenca);
                            paciente.incrementaDoenca(doencaPaciente);
                        }else{
                            //cadastra doenca paciente
                            System.out.println("\n Este paciente nunca havia tido essa doenca antes");
                            System.out.println("\n Favor cadastrar estas informacoes a respeito dessa doenca para incluir no historico");
                            System.out.println("tipo: ");
                            tipo = sc.nextLine();
                            System.out.println("grau: ");
                            grau = sc.nextLine();
                            Doenca doencaPaciente;
                            doencaPaciente = new Doenca(nomeDoenca, tipo, grau, 1);
                            paciente.adicionaDoenca(doencaPaciente);
                            System.out.println("\nDoenca Cadastrada com sucesso!");
                        }
                        medico.registrarConsultaRealizada(paciente, bpm, pressao, temperatura, diagnostico, listaMedicamentosPreescritos);
                    
                        System.out.println("\nConsulta registrada com sucesso!");
                    }else{
                        medico.registrarConsultaRealizada(paciente, bpm, pressao, temperatura, diagnostico);

                        System.out.println("\nConsulta registrada com sucesso!");
                    }
                    } catch (NullPointerException e) {
                            System.out.println("\n Valores nulos foram encontrados: "+ e.getMessage());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n Valores numericos para datas: "+ e.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\n Datas invalida: "+ ex.getMessage());
                    } catch (ConsultaException ex) {
                            System.out.println("\n"+ ex.getMessage());
                    }
                    
                    break;
                    
                case 7:
                    System.out.println("\n====RELATORIO UTILIZACAO MEDICAMENTOS====");
                    clinica.getUtilizacaoMedicamentos();
                    System.out.println("\n======\n");
                    break;
                
                case 8:
                    System.out.println("\n====LISTA MEDICOS====\n");
                    for(Medico m: clinica.getListaMedicos()){
                        System.out.println(m.toString());
                    }
                    System.out.println("\n======\n");
                    break;
                    
                case 9:
                    System.out.println("\n====LISTA PACIENTES====\n");
                    for(Paciente p: clinica.getListaPacientes()){
                        System.out.println(p.toString());
                    }
                    System.out.println("\n=====\n");
                    break;
                    
                case 10:
                    try {
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica.buscaMedicoPeloNome(nome);
                    System.out.println("\n====RELATORIO MEDICO - CONSULTAS AGENDADAS====\n");
                    for(ConsultasAgendadas p: medico.getListaConsultasAgendadas()){
                        System.out.println(p.toString());
                    }
                    System.out.println("\n========\n");
                    } catch (NullPointerException e) {
                            System.out.println("\n Medico nao existe: "+ e.getMessage());
                    }
                    break;
                    
                case 11:
                    try {
                        System.out.println("Nome do medico: ");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);

                        System.out.println("\n====CONSULTAS JA REALIZADAS====\n"); //apenas as datas
                        for(RegistroConsulta registro: medico.getListaRegistroConsultas()){
                            System.out.println("\n"+registro.getDataConsulta().toLocalDate() + " : " + registro.getDataConsulta().toLocalTime()+"\n");
                        }
                        System.out.println("\n========\n");

                        System.out.println("Informe uma data de inicio: ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        dataInicio = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        System.out.println("Informe uma data de data fim: ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        dataFim = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        System.out.println("\n====RELATORIO MEDICO - CONSULTAS REGISTRADAS====\n");
                        ArrayList<RegistroConsulta> arrayConsultas = medico.getFaixaRegistros(dataInicio, dataFim);
                        for(RegistroConsulta p: arrayConsultas){
                            System.out.println("\n"+p.getRegistroRealizadoParaMedico()+"\n");
                        }
                        System.out.println("\n========\n");
                    } catch (NullPointerException e) {
                            System.out.println("\nMedico nao encontrado: "+ e.getMessage());
                    }
                    catch(NumberFormatException ex){
                        System.out.println("\nValores de data devem ser numericos: "+ ex.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\nDava invalida: "+ ex.getMessage());
                    }
                    break;
                    
                case 12:
                    try {
                        System.out.println("Nome do medicamento: ");
                        nome = sc.nextLine();
                        System.out.println("Faixa do medicamento: ");
                        String faixa = sc.nextLine();
                        System.out.println("Quantidade: ");
                        String qtd = sc.nextLine();
                        System.out.println("Tipo: ");
                        tipo = sc.nextLine();
                        System.out.println("Indicacao: ");
                        String indicacao = sc.nextLine();

                        Medicamento medic1 = new Medicamento(nome, faixa, Integer.parseInt(qtd), 0, tipo, indicacao);
                        clinica.cadastraMedicamento(medic1);
                        System.out.println("\nMedicamento " + medic1.getNome() + " cadastrado com sucesso");
                        } catch (NumberFormatException e) {
                            System.out.println("\nQuantidade deve ser numerico: "+ e.getMessage());
                        }catch(NullPointerException e){
                            System.out.println("\nValores nulos: "+ e.getMessage());
                        }
                    break;
                case 13:
                    try {
                        System.out.println("Nome do medico: ");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);
                        System.out.println("data: ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        LocalDateTime dataAdd = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        medico.getAgenda().adicionarDataDisponivel(dataAdd);
                        System.out.println("\nData adicionada com sucesso: "+ dataAdd.toLocalDate() + " : " + dataAdd.toLocalTime());
                    } catch (NumberFormatException e) {
                        System.out.println("\nValores de data deve ser numerico: "+ e.getMessage());
                    }catch(NullPointerException e){
                        System.out.println("\nMedico nao encontrado: "+ e.getMessage());
                    } catch (DataException ex) {
                        System.out.println(ex.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\n Datas invalida: "+ ex.getMessage());
                    }
                    break;

                case 14:
                    try {
                        System.out.println("Nome do medico: ");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);
                        System.out.println("\n==== Datas Disponiveis ====\n");
                        for(LocalDateTime data: medico.getAgenda().getListaDatasDisponiveis()){
                            System.out.println("\n"+data.toLocalDate() + " : " + data.toLocalTime()+"\n");
                        }
                        System.out.println("\n==========\n");
                    } catch (NullPointerException e) {
                        System.out.println("\nMedico nao encontrado: "+ e.getMessage());
                    }
                    break;
                    
                case 15:
                    System.out.println("\n====LISTA MEDICAMENTOS====\n");
                    for(Medicamento medicamento: clinica.getListaMedicamentos()){
                        System.out.println("\n"+medicamento.toString()+"\n");
                    }
                    System.out.println("\n==========\n");
                    break;
                    
                case 16:
                    try {
                        System.out.println("Nome do paciente: ");
                        nome = sc.nextLine();
                        paciente = clinica.buscaPacientePeloNome(nome);
                        
                        System.out.println("\n====SUAS DOENCAS====\n");
                        for(Doenca doenc: paciente.getHistoricoDoencas()){
                            System.out.println("\n: "+ doenc.getNomeDoenca());
                        }
                        System.out.println("\n==========\n");
                        System.out.println("\n==Digite o nome de uma nova doenca para cadastra-la\n");
                        System.out.println("\n==Digite o nome de uma doenca já existente para incrementar suas ocorrencias\n");

                        System.out.println("nome: ");
                        nomeDoenca = sc.nextLine();
                        
                        boolean isDoencaExiste = paciente.doencaExiste(nomeDoenca);
                        if(isDoencaExiste){
                            Doenca doencaExistente = paciente.buscaDoencaPeloNome(nomeDoenca);
                            paciente.incrementaDoenca(doencaExistente);
                            System.out.println("\nDoenca incrementada com sucesso");
                            break;
                        }
                        
                        System.out.println("\nInsira estas outras informacoes para cadastrar uma nova doenca\n");
                        
                        
                        System.out.println("tipo: ");
                        tipo = sc.nextLine();
                        System.out.println("grau: ");
                        grau = sc.nextLine();
                        System.out.println("quantas vezes: ");
                        qtd_vezes = sc.nextLine();
                        Doenca doencaPaciente;
                        doencaPaciente = new Doenca(nomeDoenca, tipo, grau, Integer.parseInt(qtd_vezes));
                        paciente.adicionaDoenca(doencaPaciente);
                    } catch (NullPointerException e) {
                        System.out.println("\nPaciente nao encontrado: "+ e.getMessage());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\nQuantidade de vezes deve ser numerico: "+ e.getMessage());
                    }
                    break;
                    
                case 17:
                    try {
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica.buscaPacientePeloNome(nome);
                    System.out.println("Informe uma data de inicio: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataInicio = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    System.out.println("Informe uma data de data fim: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataFim = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    
                    ArrayList<RegistroConsulta> listaRegistrosPaciente;
                    listaRegistrosPaciente = clinica.getRelatorioPaciente(paciente, dataInicio, dataFim);
                    System.out.println("\n=====RELATORIO REGISTRO CONSULTAS PACIENTE====\n");
                    for(RegistroConsulta registro: listaRegistrosPaciente){
                        System.out.println("\n"+ registro.getRegistroRealizadoParaPaciente());
                    }
                    System.out.println("\n=========\n");
                    } catch (NullPointerException ex) {
                        System.out.println("\n Paciente nao encontrado: "+ ex.getMessage());
                    }
                    catch(NumberFormatException ex){
                        System.out.println("\n Datas deve ser numerica: "+ ex.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\n Datas invalida: "+ ex.getMessage());
                    }
                    break;
                    
                case 18:
                    listaTodosMedicos = clinica.getListaMedicos();
                    for(Medico med: listaTodosMedicos){
                        ArrayList<RegistroConsulta> listaConsultasPorMedico = med.getListaRegistroConsultas();
                        System.out.println("\n=====RELATORIO REGISTRO CONSULTAS PARA CLINICA=====\n");
                        for(RegistroConsulta registro: listaConsultasPorMedico){
                            
                            System.out.println("\n"+ registro.getRegistroRealizadoParaClinia() +"\n");
                        }
                        System.out.println("\n=========\n");
                    }
                    break;
                    
                case 19:
                    listaTodosMedicos = clinica.getListaMedicos();
                    for(Medico med: listaTodosMedicos){
                        ArrayList<ConsultasAgendadas> listaConsultasPorMedico = med.getListaConsultasAgendadas();
                        System.out.println("\n=====TODAS CONSULTAS AGENDADAS=====\n");
                        for(ConsultasAgendadas consulta: listaConsultasPorMedico){
                            System.out.println("\nMedico: "+ med.getNome()+ "\n");
                            System.out.println(consulta.toString());
                        }
                        System.out.println("\n========\n");
                    }
                    System.out.println("\nDeseja filtrar por consultas já realizadas?");
                    System.out.println("\n1. Sim");
                    System.out.println("\n2. Nao");
                    int realizadas = Integer.parseInt(sc.nextLine());
                    if(realizadas == 1){
                        for(Medico med: listaTodosMedicos){
                            ArrayList<ConsultasAgendadas> listaConsultasPorMedico = med.getListaConsultasAgendadas();
                            System.out.println("\n=====TODAS CONSULTAS AGENDADAS REALIZADAS=====\n");
                            for(ConsultasAgendadas consulta: listaConsultasPorMedico){
                                if(consulta.isIsRealizada()){
                                    System.out.println("\nMedico: "+ med.getNome()+ "\n");
                                    System.out.println(consulta.toString());
                                }
                            }
                            System.out.println("\n========\n");
                        }
                    }
                    break;
                case 20:
                    try {
                        System.out.println("\nNome do medico:");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);
                        System.out.println("Nome do paciente: ");
                        nome = sc.nextLine();
                        paciente = clinica.buscaPacientePeloNome(nome);
                        System.out.println("Informe uma data: ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        dataInicio = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        System.out.println("\n=====REGISTRO CONSULTAS DE "+ paciente.getNome() +"======\n");
                        for(RegistroConsulta registro: medico.getListaRegistroConsultas()){
                            if(dataInicio.equals(registro.getDataConsulta())  && registro.getNomePaciente().equals(paciente.getNome())){
                                System.out.println("\n"+ registro.getRegistroRealizadoDePacienteParaMedico());
                            }
                        }
                        System.out.println("\n=========\n");
                    } catch (NullPointerException e) {
                            System.out.println("\nMedico e/ou Paciente nao encontrados: "+ e.getMessage());
                    }
                    catch(NumberFormatException e){
                        System.out.println("\nValores de datas devem ser numericos: "+ e.getMessage());
                    }
                    catch(DateTimeException ex){
                        System.out.println("\n Datas invalida: "+ ex.getMessage());
                    }
                    break;
                    
                case 21:
                    try {
                        System.out.println("Nome do medico: ");
                        nome = sc.nextLine();
                        medico = clinica.buscaMedicoPeloNome(nome);
                        System.out.println("Nome do paciente: ");
                        nome = sc.nextLine();
                        paciente = clinica.buscaPacientePeloNome(nome);
                        System.out.println("\n==== CONSULTAS AGENDADAS DE "+ paciente.getNome() +" COM MEDICO "+ medico.getNome() +" ====\n");
                        for(ConsultasAgendadas cons : medico.getListaConsultasAgendadas()){
                            if(cons.getPac().getNome().equals(paciente.getNome())){
                                String realizada = "Nao";
                                if(cons.isIsRealizada()){
                                    realizada = "sim";
                                }
                                System.out.println("\nData: " + cons.getData().toLocalDate() + " : "+ cons.getData().toLocalTime());
                                System.out.println("Ja foi realizada: "+ realizada);
                            }
                        }
                        System.out.println("\n=========\n");
                        
                    } catch (Exception e) {
                        System.out.println("\nPaciente e/ou Medico nao encontrado"+ e.getMessage());
                    }
                    break;
            }
            
        }
        
    }
}
