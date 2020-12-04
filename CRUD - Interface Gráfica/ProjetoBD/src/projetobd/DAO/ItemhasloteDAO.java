/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobd.bean.itemhaslote;
import projetobd.connection.ConectarBD;
import projetobd.bean.Item;
import projetobd.bean.lote;


/**
 *
 * @author sampa
 */
public class ItemhasloteDAO {
    
    public void inserir (itemhaslote obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdItem = obj.getItem().getIdItem();
        int lIdlote = obj.getLote().getIdLote();
        objBD.conectar();
        
        
        
        
        
        try {
            
             String sql = ("INSERT INTO itemhaslote ( IdItem,Idlote) VALUES  (?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdItem);
             stmt.setInt(2, lIdlote);
             
             
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
            
            String sql = "SELECT itemhaslote.* FROM itemhaslote " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (itemhaslote obj){
         
          ConectarBD objBD = new ConectarBD();
        
		int lIdItem = obj.getItem().getIdItem();
        int lIdlote = obj.getLote().getIdLote();
        objBD.conectar(); 
         
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  itemhaslote SET IdItem = ?, Idlote = ? WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
              
             objstmt.setInt(1, lIdItem);
             objstmt.setInt(2, lIdlote);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (itemhaslote obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdItem = obj.getItem().getIdItem();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM itemhaslote WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(2, lIdItem);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

     
}

