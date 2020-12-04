package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobd.bean.Localidade;

/**
 *
 * @author sampa
 */



public class LocalidadeDAO {


    
    public void inserir (Localidade obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        String lCNPJ = obj.getCNPJ();
        String lNomedaInstituicao  = obj.getNomedaInstituicao ();
        String lEmail = obj.getEmail();
        String lCEP = obj.getCEP();
	int lNumero = obj.getNumero();
        objBD.conectar();
        
   
        
        
        
        try {
            
             String sql = ("INSERT INTO Localidade ( CNPJ,NomedaInstituicao,Email,Cep,Numero) VALUES  (?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setString(1, lCNPJ);
             stmt.setString(2, lNomedaInstituicao);
             stmt.setString(3, lEmail);
             stmt.setString(4, lCEP);
             stmt.setInt(5, lNumero);
             
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
            
            String sql = "SELECT Localidade.* FROM Localidade " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Localidade obj){
         
          ConectarBD objBD = new ConectarBD();
        
	String lCNPJ = obj.getCNPJ();
        String lNomedaInstituicao  = obj.getNomedaInstituicao ();
        String lEmail = obj.getEmail();
        String lCEP = obj.getCEP();
	int lNumero = obj.getNumero();
        
		objBD.conectar(); 
         
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Localidade SET CNPJ = ?, NomedaInstituicao = ?, Email = ?, Cep = ?, Numero = ?  WHERE CNPJ = ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
               
             objstmt.setString(1, lCNPJ);
             objstmt.setString(2, lNomedaInstituicao);
             objstmt.setString(3, lEmail);
             objstmt.setString(4, lCEP);
             objstmt.setInt(5, lNumero);
		
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Localidade obj){  
        ConectarBD objBD = new ConectarBD();
      
       String lCNPJ = obj.getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Localidade WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setString(5, lCNPJ);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

    }
    