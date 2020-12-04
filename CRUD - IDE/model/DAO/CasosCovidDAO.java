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
import model.bean.Casoscovid;
import model.bean.Destino;




/**
 *
 * @author sampa
 */
public class CasosCovidDAO {
    
     private Connection conexao = null;
     
     
    public   CasosCovidDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
    
     public boolean create (Casoscovid CasosCovid){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO CasosCovid (CNPJ, QuantidadedeInternados, QuantidadedeCurados, QuantidadedeMortes) VALUES (?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, CasosCovid.getDestino().getCNPJ());
            stmt.setInt(2, CasosCovid.getQuantidadedeInternados());
            stmt.setInt(3, CasosCovid.getQuantidadedeCurados());
            stmt.setInt(4, CasosCovid.getQuantidadedeMortes());
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    
     public List<Casoscovid> read(){
        
         String sql = "SELECT * FROM Casoscovid ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Casoscovid> casos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Casoscovid casoscovid = new Casoscovid();
                
                casoscovid.setQuantidadedeCurados(rs.getInt("QuantidadedeCurados"));
                casoscovid.setQuantidadedeInternados(rs.getInt("QuantidadedeInternados"));
                casoscovid.setQuantidadedeMortes(rs.getInt("QuantidadedeMortes"));
                casos.add(casoscovid);
                
                Destino destino = new Destino();
                destino.setCNPJ(rs.getString("CNPJ"));
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return casos;
    }
   
    
    
    
     public boolean update(Casoscovid CasosCovid){
        
        PreparedStatement stmt = null;
        String sql = "UPDATE CasosCovid SET QuantidadedeCurados = ? WHERE CNPJ = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, CasosCovid.getDestino().getCNPJ());
            stmt.setInt(2, CasosCovid.getQuantidadedeInternados());
            stmt.setInt(3, CasosCovid.getQuantidadedeCurados());
            stmt.setInt(4, CasosCovid.getQuantidadedeMortes());
            
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
  public boolean delete (Casoscovid CasosCovid){
        
        PreparedStatement stmt = null;
        String sql = "DELETE from CasosCovid  WHERE CNPJ = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, CasosCovid.getDestino().getCNPJ());
           
            
           
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