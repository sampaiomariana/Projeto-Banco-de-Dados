/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.bean;

/**
 *
 * @author sampaio
 */
public class Item {
    
    private int IdItem;
    private String Nome;
    private String Tipodeitem;
    private int Producaohistorica;
    private int Producaodoultimomes;
    
    /**
    * Criando um construtor vazio e um construtor preenchido
    * Como o identificador será gerado automaticamente, o id não será passado

    */
    public Item(){
        
    }
    
    public Item ( String Nome, String Tipodeitem, int Producaohistorica,
            int Producaodoultimomes){
    
    
    this.Nome = Nome;
    this.Tipodeitem = Tipodeitem;
    this.Producaohistorica = Producaohistorica;
    this.Producaodoultimomes = Producaodoultimomes;
    
    
    }

    public int getIdItem() {
        return IdItem;
    }

    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipodeitem() {
        return Tipodeitem;
    }

    public void setTipodeitem(String Tipodeitem) {
        this.Tipodeitem = Tipodeitem;
    }

    public int getProducaohistorica() {
        return Producaohistorica;
    }

    public void setProducaohistorica(int Producaohistorica) {
        this.Producaohistorica = Producaohistorica;
    }

    public int getProducaodoultimomes() {
        return Producaodoultimomes;
    }

    public void setProducaodoultimomes(int Producaodoultimomes) {
        this.Producaodoultimomes = Producaodoultimomes;
    }
    
       
    
}
