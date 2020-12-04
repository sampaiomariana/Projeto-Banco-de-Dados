package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobd.bean.Casoscovid;


/**
 *
 * @author sampa
 */



public class CasoscovidDAO {


    
    public void inserir (Casoscovid obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        
        int lQuantidadeInternados = obj.getQuantidadedeInternados();
        int lQuantidadeCurados = obj.getQuantidadedeCurados();
        int lQuantidadedeMortes = obj.getQuantidadedeMortes();
	String lCNPJ_D = obj.getDestino().getCNPJ();
        
        objBD.conectar();
        
        
        
        try {
            
             String sql = ("INSERT INTO Casoscovid ( CNPJ, QuantidadedeInternados,QuantidadeCurados,QuantidadedeMortes) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
           
             stmt.setInt(1, lQuantidadeInternados);
             stmt.setInt(2, lQuantidadeCurados);
             stmt.setInt(3, lQuantidadedeMortes);
             stmt.setString(4, lCNPJ_D);
             
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
            
            String sql = "SELECT Casoscovid.* FROM Casoscovid " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Casoscovid obj){
         
          ConectarBD objBD = new ConectarBD();
		
	String lCNPJ_D = obj.getDestino().getCNPJ();			
        int lQuantidadeInternados = obj.getQuantidadedeInternados();
        int lQuantidadeCurados = obj.getQuantidadedeCurados();
        int lQuantidadedeMortes = obj.getQuantidadedeMortes();
	
		   
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Casoscovid SET CNPJ = ?, QuantidadeInternados  = ?,QuantidadeCurados = ?, QuantidadedeMortes = ?, CNPJ = ?  WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
              
            objstmt.setString(1, lCNPJ_D);
          
             objstmt.setInt(2, lQuantidadeInternados);
             objstmt.setInt(3, lQuantidadeCurados);
             objstmt.setInt(4, lQuantidadedeMortes);
             
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Casoscovid obj){  
        ConectarBD objBD = new ConectarBD();
      
        String lCNPJ = obj.getDestino().getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Casoscovid WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setString(5, lCNPJ);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

     
		
    }