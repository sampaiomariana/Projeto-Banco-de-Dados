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
public class lote {
    
    private int IdLote;
    private String Fornecedor;
    private  float Valor;
    private Destino CNPJ;

    public lote() {
    }
    
    public lote(String Fornecedor, float Valor, Destino CNPJ) {
        
        this.Fornecedor = Fornecedor;
        this.Valor = Valor;
        this.CNPJ = CNPJ;
        
    }
    
    
    
    public int getIdLote() {
        return IdLote;
    }

    public void setIdLote(int IdLote) {
        this.IdLote = IdLote;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public Destino getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Destino CNPJ) {
        this.CNPJ = CNPJ;
    }
    
}
