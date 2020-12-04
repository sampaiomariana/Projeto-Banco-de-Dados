/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Item;
import projetobd.connection.ConectarBD;
import model.bean.PesquisadorChefe;

/**
 *
 * @author sampa
 */
public class PesquisadorChefeDAO {
    
    
    
    public void inserir (PesquisadorChefe obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lCadastroPesquisador = obj.getCadastroPesquisador();
        String lNome = obj.getNome();
        String lEspecialidade = obj.getEspecialidade();
        String lEmail = obj.getEmail();
        
        objBD.conectar();
        
        
        
        
        
        try {
            
             String sql = ("INSERT INTO PesquisadorChefe ( CadastroPesquisador, Nome,Especialidade,Email) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lCadastroPesquisador);
             stmt.setString(2, lNome);
             stmt.setString(3, lEspecialidade);
             stmt.setString(4, lEmail);      
             
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
            
            String sql = "SELECT PesquisadorChefe.* FROM PesquisadorChefe " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (PesquisadorChefe obj){
         
          ConectarBD objBD = new ConectarBD();
          
         
        int lCadastroPesquisador = obj.getCadastroPesquisador();
        String lNome = obj.getNome();
        String lEspecialidade = obj.getEspecialidade();
        String lEmail = obj.getEmail();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  PesquisadorChefe SET CadastroPesquisador = ?,  Nome  = ?,Especialidade= ?, Email = ? WHERE CadastroPesquisador = ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
			  
             objstmt.setInt(1, lCadastroPesquisador);
             objstmt.setString(2, lNome);
             objstmt.setString(3, lEspecialidade);
             objstmt.setString(4, lEmail);  
              
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (PesquisadorChefe  obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lCadastroPesquisador = obj.getCadastroPesquisador();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM PesquisadorChefe WHERE CadastroPesquisador  = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(4, lCadastroPesquisador);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

}
       
    

