/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "INSERT INTO item (Nome, Tipodeitem,Producaohistorica, Producaodoultimomes) VALUES  (?,?,?,?)";
       
        
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
    
    public List<Item> read(){
        
         String sql = "SELECT * FROM item ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Item> itens = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Item item = new Item();
                
                item.setIdItem(rs.getInt("IdItem"));
                item.setNome(rs.getString("Nome"));
                item.setTipodeitem(rs.getString("Tipodeitem"));
                item.setProducaohistorica(rs.getInt("Producaohistorica"));
                item.setProducaodoultimomes(rs.getInt("Producaodoultimomes"));
                itens.add(item);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return itens;
    }
    
      public boolean update (Item item ){
        PreparedStatement stmt = null;
        String sql = "UPDATE item SET Tipodeitem = ? WHERE IdItem = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1 , item.getNome());
            stmt.setString(2, item.getTipodeitem());
            stmt.setInt(3 , item.getProducaohistorica());
            stmt.setInt(4, item.getProducaodoultimomes());
            stmt.setInt(5, item.getIdItem());
            
            
            
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
  
    
      public boolean delete (Item item ){
        PreparedStatement stmt = null;
        String sql = "DELETE item  WHERE IdItem = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1 , item.getNome());
            stmt.setString(2, item.getTipodeitem());
            stmt.setInt(3 , item.getProducaohistorica());
            stmt.setInt(4, item.getProducaodoultimomes());
            stmt.setInt(5, item.getIdItem());
            
            
            
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
