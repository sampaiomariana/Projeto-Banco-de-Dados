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
import model.bean.Itemhaspesquisa;
import model.bean.Pesquisa;
import model.bean.lote;


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
   
    public List<Itemhaspesquisa > read(){
        
         String sql = "SELECT * FROM Itemhaspesquisa  ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Itemhaspesquisa > itens_pesquisados = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Itemhaspesquisa pesquisados = new Itemhaspesquisa ();
                
                Item item = new Item();
                item.setIdItem(rs.getInt("IdItem"));
                
                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setIdPesquisa(rs.getInt("IdPesquisa"));
                
                itens_pesquisados.add(pesquisados);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return itens_pesquisados;
    
    
    
    
    }
    
     public boolean update (Itemhaspesquisa item_pesquisa ){
        PreparedStatement stmt = null;
        String sql = "UPDATE item_pesquisa SET IdItem = ? WHERE IdPesquisa = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
           
            stmt.setInt(1, item_pesquisa.getItem().getIdItem());
            stmt.setInt(2, item_pesquisa.getPesquisa().getIdPesquisa());
            
            
            
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
  
    
     public boolean delete (Itemhaspesquisa item_pesquisa ){
        PreparedStatement stmt = null;
        String sql = "DELETE from item_pesquisa  WHERE IdPesquisa = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
           

            stmt.setInt(1, item_pesquisa.getPesquisa().getIdPesquisa());
            
            
            
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
