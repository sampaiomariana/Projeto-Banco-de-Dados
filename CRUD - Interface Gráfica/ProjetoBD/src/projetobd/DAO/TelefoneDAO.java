package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Telefone;
import model.bean.Localidade;
/**
 *
 * @author sampa
 */



public class TelefoneDAO {


    
    public void inserir (Telefone obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
		String lCNPJLocalidade = obj.getLocalidade.getCNPJ();
        String lNumeroTelefone = obj.getNumeroTelefone();
        
        objBD.conectar();
        
        
        
        try {
            
             String sql = ("INSERT INTO Telefone ( CNPJ, NumeroTelefone) VALUES  (?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setString(1, lCNPJLocalidade);
             stmt.setString(2, lNumeroTelefone);
             stmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do insert"+ex.getMessage());
        }
		
		
		  
    public ResultSet selecionar (){
        
        ConectarBD objBD = new ConectarBD();
      
        
        objBD.conectar();
        try {
            
            String sql = "SELECT Telefone .* FROM Telefone  " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Telefone obj){
         
          ConectarBD objBD = new ConectarBD();
          
      
		String lCNPJLocalidade = obj.getLocalidade.getCNPJ();
        String lNumeroTelefone = obj.getNumeroTelefone();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Telefone SET CNPJ= ?,NumeroTelefone = ? WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
             
             objstmt.setString(1, lCNPJLocalidade);
             objstmt.setString(2, lNumeroTelefone);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Telefone obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lCNPJLocalidade = obj.getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Telefone  WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(2, lCNPJLocalidade);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

    }
    