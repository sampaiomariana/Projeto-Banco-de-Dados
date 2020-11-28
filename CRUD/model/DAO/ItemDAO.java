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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Item;

/**
 *
 * @author sampa
 */
public class ItemDAO {
    
    private Connection conexao = null;

    public ItemDAO() {
        
        conexao = ConnectionFactory.getConnection();
    }
    
  /*
* Iniciando o Create do CRUD
* 
*/
    public boolean create (Item item ){
        PreparedStatement stmt = null;
        String sql = "INSERT INTO item (Nome) VALUES  (?)";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1 , item.getNome());
            stmt.setString(2, item.getTipodeitem());
            stmt.setInt(3 , item.getProducaohistorica());
            stmt.setInt(4, item.getProducaodoultimomes() );
            
            
 /*
* Depois que aceitou os termos da variável é necessário executar o stmt
* 
*/
            stmt.executeUpdate();
            return true;
                                        
        } catch (SQLException ex) {
           System.err.println("Erro: "+ex);
           return false;
        } finally {                
                ConnectionFactory.closeConnection(conexao, stmt);
                
            
        }
    }
}
