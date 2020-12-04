/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Item;

/**
 *
 * @author sampa
 */



public class ItemDAO {


    
    public void inserir (Item obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdItem = obj.getIdItem();
        String lNome = obj.getNome();
        String lTipodeitem = obj.getTipodeitem();
        int lProducaohistorica = obj.getProducaohistorica();
        int lProducaodoultimomes = obj.getProducaodoultimomes();
        
        objBD.conectar();
        
        
        
        
        
        try {
            
             String sql = ("INSERT INTO item ( IdItem,Nome, Tipodeitem,Producaohistorica, Producaodoultimomes) VALUES  (?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdItem);
             stmt.setString(2, lNome);
             stmt.setString(3, lTipodeitem);
             stmt.setInt(4, lProducaohistorica);
             stmt.setInt(5, lProducaodoultimomes);
             
             stmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do insert"+ex.getMessage());
        }
    }
    
    public ResultSet selecionar (){
        
        ConectarBD objBD = new ConectarBD();
      
        
        objBD.conectar();
        try {
            
            String sql = "SELECT item.* FROM item " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Item obj){
         
          ConectarBD objBD = new ConectarBD();
          
           
        int lIdItem = obj.getIdItem();
        String lNome = obj.getNome();
        String lTipodeitem = obj.getTipodeitem();
        int lProducaohistorica = obj.getProducaohistorica();
        int lProducaodoultimomes = obj.getProducaodoultimomes();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  item SET Nome = ?, Tipodeitem = ?,Producaohistorica = ?, Producaodoultimomes = ? WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
              
             objstmt.setInt(1, lIdItem);
             objstmt.setString(2, lNome);
             objstmt.setString(3, lTipodeitem);
             objstmt.setInt(4, lProducaohistorica);
             objstmt.setInt(5, lProducaodoultimomes);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Item obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdItem = obj.getIdItem();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM item WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(5, lIdItem);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

     
    
    
}


    
    
    
       
    
     /*public void atualizar (Item obj){
         
          ConectarBD objBD = new ConectarBD();
        
        int lIdItem = obj.getIdItem();
        String lNome = obj.getNome();
        String lTipodeitem = obj.getTipodeitem();
        int lProducaohistorica = obj.getProducaohistorica();
        int lProducaodoultimomes = obj.getProducaodoultimomes();
        
        objBD.getConnection();
        
        
        */
       
 
   

