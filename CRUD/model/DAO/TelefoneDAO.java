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
import model.bean.Item;
import model.bean.Localidade;
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
   
     public List<Telefone> read(){
        
         String sql = "SELECT * FROM telefone ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Telefone> telefones = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Telefone telefone = new Telefone();
                telefone.setNumeroTelefone(rs.getString("NumeroTelefone"));
                
                Localidade localidade = new Localidade();
                localidade.setCNPJ(rs.getString("CNPJ"));
                telefones.add(telefone);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return telefones;
    }
    
    
      public boolean update (Telefone telefone){
        
        PreparedStatement stmt = null;
        String sql = "UPDATE  telefone SET NumerodeTelefone = ? where CNPJ = ?";
        
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
   
    
    
    public boolean delete(Telefone telefone){
        
        PreparedStatement stmt = null;
        String sql = "DELETE FROM telefone WHERE CNPJ = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, telefone.getLocalidade().getCNPJ());
            
           
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
