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
import model.bean.Casoscovid;



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
            stmt.setInt(3, CasosCovid.getQuantidadedeMortes());
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