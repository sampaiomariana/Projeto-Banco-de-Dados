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
import java.sql.SQLException;
import model.bean.Financiamento;
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
   
    
    
   
    
}
