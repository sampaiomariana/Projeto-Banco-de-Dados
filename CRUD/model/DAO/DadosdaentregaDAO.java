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
import model.bean.Dadosdaentrega;

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
            stmt.setDate(2, (Date) DadosdaEntrega.getDatadeEntegra());
            
            
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
