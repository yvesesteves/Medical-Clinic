/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class GerenciadorArquivos {
    
    public static ArrayList<Medico> importaMedicos(String NomeArq) throws FileNotFoundException{
        
        Scanner entrada = new Scanner(new File(NomeArq));
        ArrayList<Medico> ret = new ArrayList<>();
        
        while(entrada.hasNext()){
        
            try{
                String linha = entrada.nextLine();
                String info[] = linha.split(";");
                String agendaString[] = info[7].split("-"); //agendaString[0] -> listaDatasDisponiveis
                System.out.println("\n"+agendaString[0]);
                //ret.add(new Medico(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], info[5], info[6], a));
            }

            catch(NoSuchElementException e){
                System.err.println("Arquivo com formato incorreto");
                entrada.close();
                System.exit(1);
            }
        }
        
        return ret;
    }
    
    public static void  escreveTXT(String nomeArq, ArrayList<Medico> ListaContatos) throws IOException, FileNotFoundException{
        try{
            System.out.println(ListaContatos.toString());
            File arquivo = new File(nomeArq);
            arquivo.createNewFile();
            //Escrever no arquivo
            FileWriter filewriter = new FileWriter(arquivo, false);
            PrintWriter writer = new PrintWriter(filewriter);
            for(int i=0; i< ListaContatos.size(); i++){
                writer.println(ListaContatos.get(i).toCsv());
            }
            writer.flush();
            writer.close();
        }
        catch(IOException excecao){
            System.out.printf("\n%s Excecao: %s\n", excecao);
        }         
    }
}
