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
    private Item item;
    private lote lote;
    private int quantidade;
    
    public itemhaslote() {
    }
    
    public itemhaslote (Item item, lote lote, int quantidade){
        
        this.item = item;
        this.lote = lote;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public lote getLote() {
        return lote;
    }

    public void setLote(lote lote) {
        this.lote = lote;
    }
    
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    

}
