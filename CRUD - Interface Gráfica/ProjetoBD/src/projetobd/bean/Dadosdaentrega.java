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
public class Dadosdaentrega {
    private lote lote;
    private String StatusLote;
    private Date DatadeSolicitacao;
    private Date DatadeEntegra;

    
    public Dadosdaentrega(){
    }
    
    public Dadosdaentrega( lote lote, String StatusLote, Date DatadeSolicitacao, Date DatadeEntrega){
        this.lote = lote;
        this.StatusLote = StatusLote;
        this.DatadeSolicitacao = DatadeSolicitacao;
        this.DatadeEntegra = DatadeEntrega;
    }

    public lote getLote() {
        return lote;
    }

    public void setLote(lote lote) {
        this.lote = lote;
    }

    

    public String getStatusLote() {
        return StatusLote;
    }

    public void setStatusLote(String StatusLote) {
        this.StatusLote = StatusLote;
    }

    public Date getDatadeSolicitacao() {
        return DatadeSolicitacao;
    }

    public void setDatadeSolicitacao(Date DatadeSolicitacao) {
        this.DatadeSolicitacao = DatadeSolicitacao;
    }

    public Date getDatadeEntegra() {
        return DatadeEntegra;
    }

    public void setDatadeEntegra(Date DatadeEntegra) {
        this.DatadeEntegra = DatadeEntegra;
    }
    
    
    
}
