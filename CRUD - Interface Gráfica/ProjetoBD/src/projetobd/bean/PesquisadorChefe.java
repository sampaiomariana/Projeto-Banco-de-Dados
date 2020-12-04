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
public class PesquisadorChefe {
    
    private int CadastroPesquisador;
    private String Nome;
    private String Especialidade;
    private String Email;
    
    public PesquisadorChefe(){ 
    }
    
    public PesquisadorChefe(int CadastroPesquisador, String Nome, String Especialidade, String Email){
        this.CadastroPesquisador = CadastroPesquisador;
        this.Nome = Nome;
        this.Especialidade = Especialidade;
        this.Email = Email;
    }
    
    public int getCadastroPesquisador() {
        return CadastroPesquisador;
    }

    public void setCadastroPesquisador(int CadastroPesquisador) {
        this.CadastroPesquisador = CadastroPesquisador;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
   
    
}
