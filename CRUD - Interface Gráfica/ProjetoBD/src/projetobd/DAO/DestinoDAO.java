/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.DAO;


import projetobd.connection.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Destino;


/**
 *
 * @author sampa
 */
public class DestinoDAO {
    
    
    public void inserir (Destino obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        String lCNPJ = obj.getCNPJ();
        String lNome = obj.getNome();
        String lTipodeestabelecimento= obj.getTipodeestabelecimento();
        String lUF = obj.getUF();
        String lCEP = obj.getCEP();
        int lNumero = obj.getNumero();
        
        objBD.conectar();
        
        
        
        
        
        try {
            
             String sql = ("INSERT INTO destino( CNPJ,Nome,Tipodeestablecimento,UF,CEP,Numero) VALUES  (?,?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setString(1, lCNPJ);
             stmt.setString(2, lNome);
             stmt.setString(3, lTipodeestabelecimento);
             stmt.setString(4, lUF);
             stmt.setString(5, lCEP);
             stmt.setInt(6,lNumero);
             
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
            
            String sql = "SELECT Destino.* FROM Destino " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Destino obj){
         
          ConectarBD objBD = new ConectarBD();
        

        String lCNPJ = obj.getCNPJ();
        String lNome = obj.getNome();
        String lTipodeestabelecimento= obj.getTipodeestabelecimento();
        String lUF = obj.getUF();
        String lCEP = obj.getCEP();
        int lNumero = obj.getNumero();		
           
       
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Destino SET CNPJ = ?, Nome = ?,Tipodeestablecimento = ?, UF = ?, CEP = ?, Numero = ? WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
              
			  
             objstmt.setString(1, lCNPJ);
             objstmt.setString(2, lNome);
             objstmt.setString(3, lTipodeestabelecimento);
             objstmt.setString(4, lUF);
             objstmt.setString(5, lCEP);
             objstmt.setInt(6,lNumero);
			 
       
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Destino obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lCNPJ = obj.getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Destino WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(6, lCNPJ);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

}

