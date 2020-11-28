/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author sampaio
 */
public class Destino {
    
    private String CNPJ;
    private String Nome;
    private String Tipodeestabelecimento;
    private String UF;
    private String CEP;
    private int Numero;
    
    public Destino (){
    }
    public Destino ( String CNPJ, String Nome, String Tipodeestabelecimento,
            String UF, String CEP, int Numero){
        
        this.CNPJ = CNPJ;
        this.Nome = Nome;
        this.Tipodeestabelecimento = Tipodeestabelecimento;
        this.UF = UF;
        this.CEP = CEP;
        this.Numero = Numero;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipodeestabelecimento() {
        return Tipodeestabelecimento;
    }

    public void setTipodeestabelecimento(String Tipodeestabelecimento) {
        this.Tipodeestabelecimento = Tipodeestabelecimento;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
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
