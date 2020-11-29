/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.PesquisadorChefe;


/**
 *
 * @author sampa
 */
public class PesquisadorChefeDAO {
 
    
    private Connection conexao = null;
    
    
    public PesquisadorChefeDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
    
     public boolean create (PesquisadorChefe pesquisador){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO pesquisador (Nome,Especialidade,Email) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisador.getNome());
            stmt.setString(2, pesquisador.getEspecialidade());
            stmt.setString(3, pesquisador.getEmail());
            
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
