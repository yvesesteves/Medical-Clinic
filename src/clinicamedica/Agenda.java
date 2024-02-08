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
public class Agenda {
    private ArrayList <LocalDateTime> listaDatasDisponiveis = new ArrayList();
    
    public Agenda(ArrayList <LocalDateTime> datasDisponiveis) throws DataException {
        for(LocalDateTime d: datasDisponiveis){
            if(d.isBefore(LocalDateTime.now())){
                throw new DataException("\nData invalida - Datas antigas nao sao aceitas");
            }
        }
        this.listaDatasDisponiveis = datasDisponiveis;
    }

    public void setListaDatasDisponiveis(ArrayList<LocalDateTime> listaDatasDisponiveis) {
        this.listaDatasDisponiveis = listaDatasDisponiveis;
    }
    
    public void adicionarDataDisponivel(LocalDateTime data) throws DataException {
        LocalDateTime currentDate = LocalDateTime.now();
        if(data.isBefore(currentDate)){
            throw new DataException("\nData invalida");
        }
        this.listaDatasDisponiveis.add(data);
        System.out.println("\nData adicionada");
    }
    
    public boolean marcarAgenda(LocalDateTime dataDesejada){
        //tratar data desejada
        for(LocalDateTime data: this.listaDatasDisponiveis){
            if(data.isEqual(dataDesejada)){
                this.listaDatasDisponiveis.remove(data);
                return true;
            }
        }
        return false; 
    }

    public ArrayList<LocalDateTime> getListaDatasDisponiveis() {
        return listaDatasDisponiveis;
    }
    
    
    @Override
    public String toString() {
        return "Agenda{" + "listaDatasDisponiveis: " + listaDatasDisponiveis + '}';
    }
    
}
