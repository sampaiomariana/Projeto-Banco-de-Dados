/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Dadosdaentrega;
import model.bean.lote;


/**
 *
 * @author sampa
 */
public class DadosdaentregaDAO {
    
    private Connection conexao = null;
    
    public DadosdaentregaDAO  (){
        conexao = ConnectionFactory.getConnection();
        
    }

/**
 * O parâmetro que é inserido na função corresponde ao mesmo que foi declarado na função model.bean
 * 
 */

    
    
     public boolean create (Dadosdaentrega DadosdaEntrega){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO DadosdaEntrega (StatusLote, DatadeSolicitacao, DatadeEntrega) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, DadosdaEntrega.getStatusLote());
            stmt.setDate(2, (Date) DadosdaEntrega.getDatadeSolicitacao());
            stmt.setDate(3, (Date) DadosdaEntrega.getDatadeEntegra());
            
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    public List<Dadosdaentrega> read(){
        
         String sql = "SELECT * FROM Dadosdaentrega ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Dadosdaentrega> entregas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Dadosdaentrega entrega = new Dadosdaentrega();
                
                entrega.setStatusLote(rs.getString("StatusLote"));
                entrega.setDatadeSolicitacao(rs.getDate("DatadeSolicitacao"));
                entrega.setDatadeEntegra(rs.getDate("DatadeSolicitacao"));
                
                
                lote lote = new lote();
                
                lote.setIdLote(rs.getInt("IdLote"));
                
                
                entregas.add(entrega);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return entregas;
    }
    
    
    
    
     public boolean update (Dadosdaentrega DadosdaEntrega){
        
        PreparedStatement stmt = null;
        String sql = "UPDATE dadosdaentrega SET StatusLote = ? WHERE IdLote = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, DadosdaEntrega.getStatusLote());
            stmt.setDate(2, (Date) DadosdaEntrega.getDatadeSolicitacao());
            stmt.setDate(3, (Date) DadosdaEntrega.getDatadeEntegra());
            stmt.setInt(4, DadosdaEntrega.getLote().getIdLote());
            
            
            
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
      public boolean delete (Dadosdaentrega DadosdaEntrega){
        
        PreparedStatement stmt = null;
        String sql = "DELETE from dadosdaentrega  WHERE IdLote = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, DadosdaEntrega.getLote().getIdLote());
            
            
            
            
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
