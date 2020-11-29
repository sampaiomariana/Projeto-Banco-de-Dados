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
import model.bean.itemhaslote;


/**
 *
 * @author sampa
 */
public class ItemhasloteDAO {
    
    
    private Connection conexao = null;
    
    public ItemhasloteDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
    
     public boolean create (itemhaslote ItemhasLote){
        
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO itemhaslote (quantidade) VALUES (?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ItemhasLote.getQuantidade());
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
