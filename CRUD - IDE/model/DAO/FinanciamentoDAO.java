/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Financiamento;
import model.bean.Pesquisa;


/**
 *
 * @author sampa
 */
public class FinanciamentoDAO {
    
     
    private Connection conexao = null;
   
     public FinanciamentoDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
     
      public boolean create (Financiamento financiamento){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO financiamento (CPFouCNPJ,PublicoouPrivado,Valor,DataFinanciamento,Id_Pesquisa) VALUES (?,?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, financiamento.getCPFouCNPJ());
            stmt.setString(2, financiamento.getPublicoouPrivado());
            stmt.setInt(3, financiamento.getValor());
            stmt.setDate(4, (Date) financiamento.getDatadeFinanciamento());
            stmt.setInt(5, financiamento.getPesquisa().getIdPesquisa());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
    public List<Financiamento> read(){
        
         String sql = "SELECT * FROM financiamento ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Financiamento> financiamentos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Financiamento financiamento = new Financiamento();
                
                financiamento.setIdFinanciamento(rs.getInt("IdFinanciamento"));
                financiamento.setCPFouCNPJ(rs.getString("CPFouCNPJ"));
                financiamento.setPublicoouPrivado(rs.getString("PublicoouPrivado"));
                financiamento.setValor(rs.getInt("Valor"));
                financiamento.setDatadeFinanciamento(rs.getDate("DatadeFinanciamento"));
                
                
                
              
                financiamentos.add(financiamento);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return financiamentos;
    }
    
     public boolean update (Financiamento financiamento ){
        PreparedStatement stmt = null;
        String sql = "UPDATE financiamento SET Publicoouprivado = ? WHERE idFinanciamento = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, financiamento.getIdFinanciamento());
            stmt.setString(2, financiamento.getCPFouCNPJ());
            stmt.setString(3, financiamento.getPublicoouPrivado());
            stmt.setInt(4, financiamento.getValor());
            stmt.setDate(5, (Date) financiamento.getDatadeFinanciamento());
            stmt.setInt(6, financiamento.getPesquisa().getIdPesquisa());
          
            
            
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
  
    
    
   
    public boolean delete (Financiamento financiamento ){
        PreparedStatement stmt = null;
        String sql = "DELETE from financiamento  WHERE idFinanciamento = ? ";
       
        
        try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, financiamento.getIdFinanciamento());
           
          
            
            
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
