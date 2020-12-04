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
public class Pesquisa {

private int IdPesquisa;
private int NumerodeVoluntarios;
private float TaxadeEficacia;
private Date DatadeInicio;
private Date DatadeTermino;
private Localidade localidade;
private PesquisadorChefe pesquisador;

    public Pesquisa (){
    }

    public Pesquisa (int NumerodeVoluntarios, float TaxadeEficacia, Date DatadeInicio,
            Date DatadeTermino, Localidade localidade, PesquisadorChefe pesquisador){
        
        this.NumerodeVoluntarios = NumerodeVoluntarios;
        this.TaxadeEficacia = TaxadeEficacia;
        this.DatadeInicio = DatadeInicio ;
        this.DatadeTermino = DatadeTermino;
        this.localidade = localidade;
        this.pesquisador = pesquisador; 
    }

    public int getIdPesquisa() {
        return IdPesquisa;
    }

    public void setIdPesquisa(int IdPesquisa) {
        this.IdPesquisa = IdPesquisa;
    }

    public int getNumerodeVoluntarios() {
        return NumerodeVoluntarios;
    }

    public void setNumerodeVoluntarios(int NumerodeVoluntarios) {
        this.NumerodeVoluntarios = NumerodeVoluntarios;
    }

    public float getTaxadeEficacia() {
        return TaxadeEficacia;
    }

    public void setTaxadeEficacia(float TaxadeEficacia) {
        this.TaxadeEficacia = TaxadeEficacia;
    }

    public Date getDatadeInicio() {
        return DatadeInicio;
    }

    public void setDatadeInicio(Date DatadeInicio) {
        this.DatadeInicio = DatadeInicio;
    }

    public Date getDatadeTermino() {
        return DatadeTermino;
    }

    public void setDatadeTermino(Date DatadeTermino) {
        this.DatadeTermino = DatadeTermino;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public PesquisadorChefe getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(PesquisadorChefe pesquisador) {
        this.pesquisador = pesquisador;
    }
    
    
    
}
