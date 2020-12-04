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
import projetobd.bean.Item;
import projetobd.bean.Pesquisa;
import projetobd.bean.Itemhaspesquisa;
import projetobd.connection.ConectarBD;

/**
 *
 * @author sampa
 */
public class itemhaspesquisaDAO {
    
     public void inserir (Itemhaspesquisa obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdItem = obj.getItem().getIdItem();
        int lIdPesquisa = obj.getPesquisa().getIdPesquisa();
        
        
        objBD.conectar();
        
        
        
        
        
        try {
            
             String sql = ("INSERT INTO itemhaspesquisa ( IdItem,IdPesquisa) VALUES  (?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdItem);
             stmt.setInt(2, lIdPesquisa);
             
             
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
            
            String sql = "SELECT itemhaspesquisa.* FROM itemhaspesquisa " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Itemhaspesquisa obj){
         
          ConectarBD objBD = new ConectarBD();
      
        int lIdItem = obj.getItem().getIdItem();
        int lIdPesquisa = obj.getPesquisa().getIdPesquisa();
        
        objBD.conectar(); 
         
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  itemhaspesquisa SET IdItem = ?, IdPesquisa = ? WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
             
			 
             objstmt.setInt(1, lIdItem);
             objstmt.setInt(2, lIdPesquisa);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Itemhaspesquisa obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdItem = obj.getItem().getIdItem();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM itemhaspesquisa WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(2, lIdItem);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

   
}
    

