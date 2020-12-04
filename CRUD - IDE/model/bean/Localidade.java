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
public class Localidade {
    
    private String CNPJ;
    private String NomedaInstituicao;
    private String Email;
    private String CEP;
    private int Numero;

    public Localidade (){
    }
    
    public Localidade ( String CNPJ, String NomedaInstituicao, String Email, String CEP, int Numero ){
        
        this.CNPJ = CNPJ;
        this.NomedaInstituicao = NomedaInstituicao ;
        this.Email = Email;
        this.CEP = CEP;
        this.Numero = Numero; 
    }
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomedaInstituicao() {
        return NomedaInstituicao;
    }

    public void setNomedaInstituicao(String NomedaInstituicao) {
        this.NomedaInstituicao = NomedaInstituicao;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    
    

}
