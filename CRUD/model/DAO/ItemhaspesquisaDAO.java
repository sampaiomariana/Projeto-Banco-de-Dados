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
import model.bean.Itemhaspesquisa;


/**
 *
 * @author sampa
 */
public class ItemhaspesquisaDAO {
    
    private Connection conexao = null;
    
    public  ItemhaspesquisaDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
    
     public boolean create (Itemhaspesquisa itempesquisa){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO itempesquisa (Iditem,Idpesquisa) VALUES (?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, itempesquisa.getItem().getIdItem());
            stmt.setInt(2, itempesquisa.getPesquisa().getIdPesquisa());
            
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
