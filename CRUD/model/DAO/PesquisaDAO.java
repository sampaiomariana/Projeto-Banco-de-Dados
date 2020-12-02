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
import model.bean.Localidade;
import model.bean.Pesquisa;
import model.bean.PesquisadorChefe;


/**
 *
 * @author sampa
 */
public class PesquisaDAO {
    
     
    private Connection conexao = null;
   
    public PesquisaDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (Pesquisa pesquisa){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO pesquisa (NumerodeVoluntarios,TaxadeEficacia,DatadeInicio,DatadeTermino,Pesquisador,CNPJ) VALUES (?,?,?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pesquisa.getNumerodeVoluntarios());
            stmt.setFloat(2, pesquisa.getTaxadeEficacia());
            stmt.setDate(3, (Date) pesquisa.getDatadeInicio());
            stmt.setDate(4, (Date) pesquisa.getDatadeTermino());
            stmt.setInt(5, pesquisa.getPesquisador().getCadastroPesquisador());
            stmt.setString(6, pesquisa.getLocalidade().getCNPJ());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
   public List<Pesquisa> read(){
        
         String sql = "SELECT * FROM pesquisa ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pesquisa> pesquisas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Pesquisa pesquisa = new Pesquisa();
                
                pesquisa.setIdPesquisa(rs.getInt("IdPesquisa"));
                pesquisa.setNumerodeVoluntarios(rs.getInt("NumerodeVoluntarios"));
                pesquisa.setDatadeInicio(rs.getDate("DatadeInicio"));
                pesquisa.setDatadeTermino(rs.getDate("DatadeTermino"));
                
                Localidade localidade = new Localidade();
                localidade.setCNPJ(rs.getString("CNPJ"));
                
                PesquisadorChefe pesquisador = new PesquisadorChefe();
                pesquisador.setCadastroPesquisador(rs.getInt("CadastroPesquisador"));
                pesquisas.add(pesquisa);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return pesquisas;
    }
     
     
     public boolean update(Pesquisa pesquisa){
        
        PreparedStatement stmt = null;
        String sql = "UPDATE pesquisa SET NumerodeVoluntarios = ? WHERE IdPesquisa = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pesquisa.getIdPesquisa());
            stmt.setInt(2, pesquisa.getNumerodeVoluntarios());
            stmt.setFloat(3, pesquisa.getTaxadeEficacia());
            stmt.setDate(4, (Date) pesquisa.getDatadeInicio());
            stmt.setDate(5, (Date) pesquisa.getDatadeTermino());
            stmt.setInt(6, pesquisa.getPesquisador().getCadastroPesquisador());
            stmt.setString(7, pesquisa.getLocalidade().getCNPJ());
            
            stmt.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
   
   public boolean delete (Pesquisa pesquisa){
        
        PreparedStatement stmt = null;
        String sql = "DELETE from pesquisa  WHERE IdPesquisa = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pesquisa.getIdPesquisa());
            
            
            
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
  
    
    
    

