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
public class Itemhaspesquisa {
    
    private Item IdItem;
    private Pesquisa IdPesquisa;
    
    public Itemhaspesquisa (){
    }

    public Itemhaspesquisa ( Item IdItem, Pesquisa IdPesquisa){
        this.IdItem = IdItem ;
        this.IdPesquisa = IdPesquisa ; 
    }

    public Item getIdItem() {
        return IdItem;
    }

    public void setIdItem(Item IdItem) {
        this.IdItem = IdItem;
    }

    public Pesquisa getIdPesquisa() {
        return IdPesquisa;
    }

    public void setIdPesquisa(Pesquisa IdPesquisa) {
        this.IdPesquisa = IdPesquisa;
    }
    
    

}
