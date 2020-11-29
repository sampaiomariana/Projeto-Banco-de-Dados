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
import model.bean.Telefone;


/**
 *
 * @author sampa
 */
public class TelefoneDAO {
    
     private Connection conexao = null;
   
     public TelefoneDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
     
     public boolean create (Telefone telefone){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO telefone (CNPJ, NumerodeTelefone) VALUES (?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, telefone.getLocalidade().getCNPJ());
            stmt.setString(2, telefone.getNumeroTelefone());
           
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
