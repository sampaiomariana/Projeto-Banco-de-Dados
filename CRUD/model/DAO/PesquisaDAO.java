/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Pesquisa;


/**
 *
 * @author sampa
 */
public class PesquisaDAO {
    
     
    private Connection conexao = null;
   
    public PesquisaDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (Pesquisa pesquisa){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO pesquisa (NumerodeVoluntarios,TaxadeEficacia,DatadeInicio,DatadeTermino,Pesquisador,CNPJ) VALUES (?,?,?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pesquisa.getNumerodeVoluntarios());
            stmt.setFloat(2, pesquisa.getTaxadeEficacia());
            stmt.setDate(3, (Date) pesquisa.getDatadeInicio());
            stmt.setDate(4, (Date) pesquisa.getDatadeTermino());
            stmt.setInt(5, pesquisa.getPesquisador().getCadastroPesquisador());
            stmt.setString(6, pesquisa.getLocalidade().getCNPJ());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    
    
    
    
}
