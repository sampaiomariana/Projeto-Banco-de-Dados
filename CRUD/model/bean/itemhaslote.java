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
public class itemhaslote {
    private Item IdItem;
    private lote IdLote;
    private int quantidade;
    
    public itemhaslote() {
    }
    
    public itemhaslote (Item IdItem, lote IdLote, int quantidade){
        
        this.IdItem = IdItem;
        this.IdLote = IdLote;
        this.quantidade = quantidade;
    }
    
    public Item getIdItem() {
        return IdItem;
    }

    public void setIdItem(Item IdItem) {
        this.IdItem = IdItem;
    }

    public lote getIdLote() {
        return IdLote;
    }

    public void setIdLote(lote IdLote) {
        this.IdLote = IdLote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    

}
