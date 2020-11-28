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
public class Telefone {
    
 private Localidade CNPJ;
 private String NumeroTelefone;

    public Telefone (){
    }
    
    public Telefone (Localidade CNPJ, String NumeroTelefone){
        this.CNPJ = CNPJ;
        this.NumeroTelefone = NumeroTelefone;
    }
    
    public Localidade getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Localidade CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNumeroTelefone() {
        return NumeroTelefone;
    }

    public void setNumeroTelefone(String NumeroTelefone) {
        this.NumeroTelefone = NumeroTelefone;
    }

        
    
}
