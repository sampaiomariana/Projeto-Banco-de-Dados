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
import model.bean.PesquisadorChefe;


/**
 *
 * @author sampa
 */
public class PesquisadorChefeDAO {
 
    
    private Connection conexao = null;
    
    
    public PesquisadorChefeDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
    
     public boolean create (PesquisadorChefe pesquisador){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO pesquisador (Nome,Especialidade,Email) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisador.getNome());
            stmt.setString(2, pesquisador.getEspecialidade());
            stmt.setString(3, pesquisador.getEmail());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
     public List<PesquisadorChefe> read(){
        
         String sql = "SELECT * FROM  pesquisador ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<PesquisadorChefe> pesquisadores = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                PesquisadorChefe pesquisador = new PesquisadorChefe();
                
                pesquisador.setCadastroPesquisador(rs.getInt("CadastroPesquisador"));
                pesquisador.setNome(rs.getString("Nome"));
                pesquisador.setEspecialidade(rs.getString("Especialidade"));
                pesquisador.setEmail(rs.getString("Email"));
                
                pesquisadores.add(pesquisador);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return pesquisadores;
    }
    
     
     public boolean update  (PesquisadorChefe pesquisador){
        
        PreparedStatement stmt = null;
        String sql = "UPDATE pesquisador SET Email = ? WHERE CadastroPesquisador = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisador.getNome());
            stmt.setString(2, pesquisador.getEspecialidade());
            stmt.setString(3, pesquisador.getEmail());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    
     public boolean delete (PesquisadorChefe pesquisador){
        
        PreparedStatement stmt = null;
        String sql = "DELETE from pesquisador WHERE CadastroPesquisador = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pesquisador.getCadastroPesquisador());
           
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
