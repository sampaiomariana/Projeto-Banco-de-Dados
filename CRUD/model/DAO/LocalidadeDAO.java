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
   
    
    
    public List<Localidade> read(){
        
         String sql = "SELECT * FROM localidade ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Localidade> localidades = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
            Localidade localidade = new Localidade();
                
                localidade.setCNPJ(rs.getString("CNPJ"));
                localidade.setNomedaInstituicao(rs.getString("NomedaInstituicao"));
                localidade.setEmail(rs.getString("Email"));
                localidade.setCEP(rs.getString("CEP"));
                localidade.setNumero(rs.getInt("Numero"));
                
                
                
                localidades.add(localidade);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return localidades;
    }
    
     public boolean update (Localidade localidade ){
        PreparedStatement stmt = null;
        String sql = "UPDATE localidade SET Email = ? WHERE CNPJ = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString (1, localidade.getCNPJ());
            stmt.setString (2, localidade.getNomedaInstituicao());
            stmt.setString (3, localidade.getEmail());
            stmt.setString (4, localidade.getCEP());
            stmt.setInt(5, localidade.getNumero());
            
            
            
            
            
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
  
    
    
    
    public boolean delete (Localidade localidade ){
        PreparedStatement stmt = null;
        String sql = "DELETE from localidade  WHERE CNPJ = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString (1, localidade.getCNPJ());
           
            
            
            
            
            
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
