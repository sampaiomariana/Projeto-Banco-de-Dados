/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sampaio
 */
public class ConnectionFactory {
    
    private static final String DRIVER  = "com.mysql.jdbc.Driver";
    
    private static final String URL  = "jdbc:mysql://localhost:3306/covid";
    
    private static final String USER  = "root";
    
    private static final String PASS  = "";
    
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL,USER,PASS);
                    
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na conexão", ex); 
             }
        
        }

    public static void closeConnection(Connection conexao){
        
        if (conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro:   " +ex);
            }
        }
    }
    public static void closeConnection(Connection conexao, PreparedStatement stmt){
        
        if (conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro:   " +ex);
            }
        
        }
            closeConnection(conexao);
    }
    public static void closeConnection(Connection conexao, PreparedStatement stmt, ResultSet rs){
        
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
               System.err.println("Erro:   " +ex);
            }
        
        }
            closeConnection(conexao,stmt);
    }
}
       