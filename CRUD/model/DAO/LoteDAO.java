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
import model.bean.Dadosdaentrega;
import model.bean.Destino;
import model.bean.lote;


/**
 *
 * @author sampa
 */
public class LoteDAO {
    
    private Connection conexao = null;
    
    public LoteDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (lote Lote){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO lote (Fornecedor,Valor,CNPJ) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Lote.getFornecedor());
            stmt.setFloat(2, Lote.getValor());
            stmt.setString(3, Lote.getDestino().getCNPJ());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    public List <lote> read(){
        
         String sql = "select  lote.idlote, lote.fornecedor, dadosdaentrega.StatusLote from lote \n" +
"join dadosdaentrega \n" +
"on lote.idlote = dadosdaentrega.IdLote;";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<lote> lotes = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                lote lote = new lote();
                
                lote.setIdLote(rs.getInt("IdLote"));
                lote.setForncedor(rs.getString("Fornecedor"));
                
                 Dadosdaentrega entrega = new Dadosdaentrega();
                 
                 entrega.setStatusLote(rs.getString("StatusLote"));
                
                lotes.add(lote);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return lotes;
    
    }
    
     public boolean update (lote lote ){
        PreparedStatement stmt = null;
        String sql = "UPDATE lote SET Valor = ? WHERE IdLote = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1 , lote.getIdLote());
            stmt.setString(2, lote.getFornecedor());
            stmt.setFloat(3, lote.getValor());
            stmt.setString(4, lote.getDestino().getCNPJ());
         
            
            
            
            
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
  
    
    
     public boolean delete(lote lote ){
        PreparedStatement stmt = null;
        String sql = "DELETE FROM lote  WHERE IdLote = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1 , lote.getIdLote());
            
         
            
            
            
            
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
    

