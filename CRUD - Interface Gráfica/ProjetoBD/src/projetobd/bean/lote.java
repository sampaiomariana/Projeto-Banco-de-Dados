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
public class lote {
    
    private int IdLote;
    private String Fornecedor;
    private  float Valor;
    private Destino destino;

    public lote() {
    }
    
    public lote(String Fornecedor, float Valor, Destino destino) {
        
        this.Fornecedor = Fornecedor;
        this.Valor = Valor;
        this.destino = destino;
        
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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setForncedor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
