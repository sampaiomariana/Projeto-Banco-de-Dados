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
public class Casoscovid {
        
    private Destino CNPJ;
    private int QuantidadedeInternados;
    private int QuantidadedeCurados;
    private int QuantidadedeMortes;

    
    public Casoscovid(){
    }
    
    
    public Casoscovid( Destino CNPJ, int QuantidadedeInternados, int QuantidadedeCurados
            , int QuantidadedeMortes){
        this.CNPJ = CNPJ;
        this.QuantidadedeInternados = QuantidadedeInternados;
        this.QuantidadedeCurados = QuantidadedeCurados;
        this.QuantidadedeMortes = QuantidadedeMortes; 
    }
    public Destino getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Destino CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getQuantidadedeInternados() {
        return QuantidadedeInternados;
    }

    public void setQuantidadedeInternados(int QuantidadedeInternados) {
        this.QuantidadedeInternados = QuantidadedeInternados;
    }

    public int getQuantidadedeCurados() {
        return QuantidadedeCurados;
    }

    public void setQuantidadedeCurados(int QuantidadedeCurados) {
        this.QuantidadedeCurados = QuantidadedeCurados;
    }

    public int getQuantidadedeMortes() {
        return QuantidadedeMortes;
    }

    public void setQuantidadedeMortes(int QuantidadedeMortes) {
        this.QuantidadedeMortes = QuantidadedeMortes;
    }

    

}
