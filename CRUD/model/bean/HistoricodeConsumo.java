/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author sampa
 */
public class HistoricodeConsumo {
    
   private Destino destino;
   private Item IdItem;
   private int Mes;
   private int QuantidadeMensal;
   
   public HistoricodeConsumo (){
   }
   
   
   public HistoricodeConsumo (Destino destino, Item IdItem, int Mes, int QuantidadeMensal){
       
       this.destino = destino;
       this.IdItem = IdItem;
       this.Mes = Mes;
       this.QuantidadeMensal = QuantidadeMensal;
   }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Item getIdItem() {
        return IdItem;
    }

    public void setIdItem(Item IdItem) {
        this.IdItem = IdItem;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getQuantidadeMensal() {
        return QuantidadeMensal;
    }

    public void setQuantidadeMensal(int QuantidadeMensal) {
        this.QuantidadeMensal = QuantidadeMensal;
    }
    
    
   
}
