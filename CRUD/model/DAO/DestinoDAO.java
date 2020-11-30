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
    
    public List<Destino> read(){
        
         String sql = "SELECT * FROM destino ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Destino> destinos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Destino destino = new Destino();
                
               destino.setCNPJ(rs.getString("CNPJ"));
               destino.setNome(rs.getString("Nome"));
               destino.setTipodeestabelecimento(rs.getString("Tipodeestabelecimento"));
               destino.setUF(rs.getString("UF"));
               destino.setCEP(rs.getString("CEP"));
               destino.setNumero(rs.getInt("Numero"));
                
               destinos.add(destino);
                
                
            
            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: "+ex);
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        
        }
           return destinos;
    }
    
    
}
