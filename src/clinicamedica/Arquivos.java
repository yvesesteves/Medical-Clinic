/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Arquivos {
    public static ArrayList<Medicamento> importaMedicamento(String NomeArq) throws FileNotFoundException{
        
        Scanner entrada = new Scanner(new File(NomeArq));
        ArrayList<Medicamento> ret = new ArrayList<>();
        
        while(entrada.hasNext()){
        
            try{
                   String linha = entrada.nextLine();
                   String info[] = linha.split(";");
                   ret.add(new Medicamento(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[4], info[5]));
            }

            catch(NoSuchElementException e){
                System.err.println("Arquivo com formato incorreto");
                entrada.close();
                System.exit(1);
            }
        }
        
        return ret;
    }
    
    public static ArrayList<LocalDateTime> importaDatas(String NomeArq) throws FileNotFoundException{
        
        Scanner entrada = new Scanner(new File(NomeArq));
        ArrayList<LocalDateTime> ret = new ArrayList<>();
        
        while(entrada.hasNext()){
        
            try{
                   String linha = entrada.nextLine();
                   LocalDateTime data = LocalDateTime.parse(linha);
                   ret.add(data);
            }

            catch(NoSuchElementException e){
                System.err.println("Arquivo com formato incorreto");
                entrada.close();
                System.exit(1);
            }
        }
        
        return ret;
    }
    
    public static ArrayList<Medico> importaMedicos(String NomeArq) throws FileNotFoundException{
        
        Scanner entrada = new Scanner(new File(NomeArq));
        ArrayList<Medico> ret = new ArrayList<>();
        
        while(entrada.hasNext()){
        
            try{
                String linha = entrada.nextLine();
                String info[] = linha.split(";");
                ret.add(new Medico(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], info[5], info[6]));
            }

            catch(NoSuchElementException e){
                System.err.println("Arquivo com formato incorreto");
                entrada.close();
                System.exit(1);
            }
        }
        
        return ret;
    }
    
    public static ArrayList<Paciente> importaPacientes(String NomeArq) throws FileNotFoundException{
        
        Scanner entrada = new Scanner(new File(NomeArq));
        ArrayList<Paciente> ret = new ArrayList<>();
        
        while(entrada.hasNext()){
        
            try{
                String linha = entrada.nextLine();
                String info[] = linha.split(";");
                ret.add(new Paciente(new ArrayList<>(), info[0], info[1], Integer.parseInt(info[2]), info[3], info[4], info[5]));
            }

            catch(NoSuchElementException e){
                System.err.println("Arquivo com formato incorreto");
                entrada.close();
                System.exit(1);
            }
        }
        
        return ret;
    }
}
