/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.bean;

import java.util.Date;

/**
 *
 * @author sampa
 */
public class Financiamento {
    
    private int IdFinanciamento;
    private String CPFouCNPJ;
    private String PublicoouPrivado;
    private int Valor;
    private Date DatadeFinanciamento;
    private Pesquisa pesquisa;

    public Financiamento (){
    }
    
    public Financiamento (String CPFouCNPJ, String PublicoouPrivado,int Valor, Date DatadeFinanciamento, Pesquisa pesquisa
            ){
        
        this.CPFouCNPJ = CPFouCNPJ;
        this.PublicoouPrivado = PublicoouPrivado;
        this.Valor = Valor;
        this.DatadeFinanciamento = DatadeFinanciamento;
        this.pesquisa = pesquisa;

    }

    public int getIdFinanciamento() {
        return IdFinanciamento;
    }

    public void setIdFinanciamento(int IdFinanciamento) {
        this.IdFinanciamento = IdFinanciamento;
    }

    public String getCPFouCNPJ() {
        return CPFouCNPJ;
    }

    public void setCPFouCNPJ(String CPFouCNPJ) {
        this.CPFouCNPJ = CPFouCNPJ;
    }

    public String getPublicoouPrivado() {
        return PublicoouPrivado;
    }

    public void setPublicoouPrivado(String PublicoouPrivado) {
        this.PublicoouPrivado = PublicoouPrivado;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public Date getDatadeFinanciamento() {
        return DatadeFinanciamento;
    }

    public void setDatadeFinanciamento(Date DatadeFinanciamento) {
        this.DatadeFinanciamento = DatadeFinanciamento;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    
}
