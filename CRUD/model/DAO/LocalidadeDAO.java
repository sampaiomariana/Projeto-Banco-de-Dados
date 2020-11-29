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
import model.bean.Localidade;


/**
 *
 * @author sampa
 */
public class LocalidadeDAO {
    
    private Connection conexao = null;
    
    public LocalidadeDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (Localidade localidade){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO localidade (CNPJ, NomedaInstituicao,Email,CEP,Numero) VALUES (?,?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, localidade.getCNPJ());
            stmt.setString(2, localidade.getNomedaInstituicao());
            stmt.setString(3, localidade.getEmail());
            stmt.setString(3, localidade.getCEP());
            stmt.setInt(3, localidade.getNumero());
            
            
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
