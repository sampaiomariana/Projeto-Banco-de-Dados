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
public class Dadosdaentrega {
    private lote IdLote;
    private lote StatusLote;
    private Date DatadeSolicitacao;
    private Date DatadeEntegra;

    
    public Dadosdaentrega(){
    }
    
    public Dadosdaentrega( lote IdLote, lote StatusLote, Date DatadeSolicitacao, Date DatadeEntrega){
        this.IdLote = IdLote;
        this.StatusLote = StatusLote;
        this.DatadeSolicitacao = DatadeSolicitacao;
        this.DatadeEntegra = DatadeEntrega;
    }
    
    
    public lote getIdLote() {
        return IdLote;
    }

    public void setIdLote(lote IdLote) {
        this.IdLote = IdLote;
    }

    public lote getStatusLote() {
        return StatusLote;
    }

    public void setStatusLote(lote StatusLote) {
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
