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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.lote;


/**
 *
 * @author sampa
 */
public class LoteDAO {
    
    private Connection conexao = null;
    
    public LoteDAO (){
        conexao = ConnectionFactory.getConnection();
        
    }
    
     public boolean create (lote Lote){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO lote (Fornecedor,Valor,CNPJ) VALUES (?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Lote.getFornecedor());
            stmt.setFloat(2, Lote.getValor());
            stmt.setString(3, Lote.getDestino().getCNPJ());
            
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
