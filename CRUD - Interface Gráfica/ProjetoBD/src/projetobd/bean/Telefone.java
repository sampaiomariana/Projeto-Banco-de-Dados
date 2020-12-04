/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.bean;
/**
 *
 * @author sampa
 */
public class Telefone {
    
 private Localidade localidade;
 private String NumeroTelefone;

    public Telefone (){
    }
    
    public Telefone (Localidade localidade, String NumeroTelefone){
        this.localidade = localidade;
        this.NumeroTelefone = NumeroTelefone;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public String getNumeroTelefone() {
        return NumeroTelefone;
    }

    public void setNumeroTelefone(String NumeroTelefone) {
        this.NumeroTelefone = NumeroTelefone;
    }
    
    
}
