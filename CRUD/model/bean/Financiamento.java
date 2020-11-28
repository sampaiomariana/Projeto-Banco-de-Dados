/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

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
    private Pesquisa IdPesquisa;

    public Financiamento (){
    }
    
    public Financiamento (String CPFouCNPJ, String PublicoouPrivado,int Valor, Date DatadeFinanciamento
            ){
        
        this.CPFouCNPJ = CPFouCNPJ;
        this.PublicoouPrivado = PublicoouPrivado;
        this.Valor = Valor;
        this.DatadeFinanciamento = DatadeFinanciamento;

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

    public Pesquisa getIdPesquisa() {
        return IdPesquisa;
    }

    public void setIdPesquisa(Pesquisa IdPesquisa) {
        this.IdPesquisa = IdPesquisa;
    }
    
    
}
