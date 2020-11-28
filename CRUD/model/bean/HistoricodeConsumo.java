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
    
   private Destino CNPJ;
   private Item IdItem;
   private int Mes;
   
   public HistoricodeConsumo (){
   }
   
   
   public HistoricodeConsumo (Destino CNPJ, Item IdItem, int Mes){
       
       this.CNPJ = CNPJ;
       this.IdItem = IdItem;
       this.Mes = Mes;
   }
   
    public Destino getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Destino CNPJ) {
        this.CNPJ = CNPJ;
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
   
     
}
