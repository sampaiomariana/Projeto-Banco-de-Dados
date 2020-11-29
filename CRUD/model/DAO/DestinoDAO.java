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
import model.bean.Destino;

/**
 *
 * @author sampa
 */
public class DestinoDAO {
    
    private Connection conexao =  null;
    
    public DestinoDAO(){
        conexao = ConnectionFactory.getConnection();
    }
    
    public boolean create (Destino destino){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO destino (CNPJ, Nome, TipodeEstabelecimento,UF,CEP,Numero) VALUES (?,?,?,?,?,?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, destino.getCNPJ());
            stmt.setString(2, destino.getNome());
            stmt.setString(3, destino.getTipodeestabelecimento());
            stmt.setString(4, destino.getUF());
            stmt.setString(5, destino.getCEP());
            stmt.setInt(6, destino.getNumero());
            
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
