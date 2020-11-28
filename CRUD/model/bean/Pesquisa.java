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
public class Pesquisa {

private int IdPesquisa;
private int NumerodeVoluntarios;
private float TaxadeEficacia;
private Date DatadeInicio;
private Date DatadeTermino;
private Localidade CNPJ;
private PesquisadorChefe CadastroPesquisador;

    public Pesquisa (){
    }

    public Pesquisa (int NumerodeVoluntarios, float TaxadeEficacia, Date DatadeInicio,
            Date DatadeTermino, Localidade CNPJ, PesquisadorChefe CadastroPesquisador){
        
        this.NumerodeVoluntarios = NumerodeVoluntarios;
        this.TaxadeEficacia = TaxadeEficacia;
        this.DatadeInicio = DatadeInicio ;
        this.DatadeTermino = DatadeTermino;
        this.CNPJ = CNPJ;
        this.CadastroPesquisador = CadastroPesquisador; 
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

    public Localidade getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Localidade CNPJ) {
        this.CNPJ = CNPJ;
    }

    public PesquisadorChefe getCadastroPesquisador() {
        return CadastroPesquisador;
    }

    public void setCadastroPesquisador(PesquisadorChefe CadastroPesquisador) {
        this.CadastroPesquisador = CadastroPesquisador;
    }

    
    
}
