/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.bean;

/**
 *
 * @author sampa
 */
public class Itemhaspesquisa {
    
    private Item item;
    private Pesquisa pesquisa;
    
    public Itemhaspesquisa (){
    }

    public Itemhaspesquisa ( Item item, Pesquisa pesquisa){
        this.item = item ;
        this.pesquisa = pesquisa ; 
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

}
