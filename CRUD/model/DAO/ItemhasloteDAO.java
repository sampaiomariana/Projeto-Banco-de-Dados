/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Item;
import model.bean.itemhaslote;
import model.bean.lote;


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
   
    public List<itemhaslote> read(){
        
         String sql = "SELECT * FROM itemhaslote ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<itemhaslote> itens_lote = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                itemhaslote itenshas = new itemhaslote();
                
                itenshas.setQuantidade(rs.getInt("Quantidade"));
                
                lote lote = new lote();
                
                lote.setIdLote(rs.getInt("IdLote"));
                
                Item item = new Item();
                item.setIdItem(rs.getInt("IdItem"));
                
                itens_lote.add(itenshas);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return itens_lote;
    }
    
    
    
     public boolean update (itemhaslote ItemhasLote ){
        PreparedStatement stmt = null;
        String sql = "UPDATE ItemhasLote SET quantidade = ? WHERE IdItem = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
           
            
             stmt.setInt(1, ItemhasLote.getItem().getIdItem());
             stmt.setInt(2, ItemhasLote.getLote().getIdLote());
             
             stmt.setInt(3, ItemhasLote.getQuantidade());
            
            
            
            
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
  
    
     public boolean delete (itemhaslote ItemhasLote ){
        PreparedStatement stmt = null;
        String sql = "DELETE from ItemhasLote  WHERE IdItem = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
           
            
             stmt.setInt(1, ItemhasLote.getItem().getIdItem());
           
            
            
            
            
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
