/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sampa
 */
public class ConectarBD {
    
     String URL = "jdbc:mysql://localhost:8111/covid";
     String user = "root";
     String password = "";
     
     public Connection conexao = null;
     
     public void conectar (){
        try {
             Class.forName("com.mysql.jdbc.Driver");
             
             conexao = DriverManager.getConnection(URL, user, password);
         
            } catch (ClassNotFoundException ex){
                
                JOptionPane.showMessageDialog(null, "Problema ao carregar o driver no banco");
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Problema ao se conectar no banco");
                
            }
              }
         
         public void desconectar (){
         
             try {
                 this.conexao.close();
             
             } catch (SQLException ex) {
             Logger.getLogger(ConectarBD.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         }
         
         public void executar (String sql) {
           
             try{
             Statement stmt = conexao.createStatement();
             stmt.execute(sql);
             
             JOptionPane.showMessageDialog(null, "Executado com sucesso");
             } catch (SQLException ex ){
                 
             JOptionPane.showMessageDialog(null, "Problema ao execultar o comando"+ex.getMessage());
             }
         }
         
          public ResultSet executarconsulta (String sql) {
           
             try{
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             JOptionPane.showMessageDialog(null, "Executado com sucesso");
             
             return rs;
             
             
             } catch (SQLException ex ){
                 
             JOptionPane.showMessageDialog(null, "Problema ao execultar o comando"+ex.getMessage());
             }
             
             return null;
         }
             
             
                
                
     
     
    
}