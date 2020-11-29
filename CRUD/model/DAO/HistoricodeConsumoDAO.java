/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.HistoricodeConsumo;
import model.bean.lote;

/**
 *
 * @author sampa
 */
public class HistoricodeConsumoDAO {
    
    
    private Connection conexao = null;
    
    
    public HistoricodeConsumoDAO  (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (HistoricodeConsumo HistoricoConsumo){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO HistoricoConsumo (CNPJ, Mes, QuantidadeMensal) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, HistoricoConsumo.getDestino().getCNPJ());
            stmt.setInt(2, HistoricoConsumo.getMes());
            stmt.setInt(3, HistoricoConsumo.getQuantidadeMensal());
            
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
