package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Casoscovid;
import model.bean.Destino;
/**
 *
 * @author sampa
 */



public class CasoscovidDAO {


    
    public void inserir (Casoscovid obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        String lCNPJ = obj.getCNPJ();
        int lQuantidadeInternados = obj.getQuantidadeInternados();
        int lQuantidadeCurados = obj.getQuantidadeCurados();
        int lQuantidadedeMortes = obj.getQuantidadedeMortes();
		String lCNPJ_D = obj.getDestino().getCNPJ();
        
        objBD.conectar();
        
        
        
        try {
            
             String sql = ("INSERT INTO Casoscovid ( CNPJ, QuantidadeInternados,QuantidadeCurados,QuantidadedeMortes, CNPJ) VALUES  (?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setString(1, lCNPJ);
             stmt.setInt(2, lQuantidadeInternados);
             stmt.setInt(3, lQuantidadeCurados);
             stmt.setInt(4, lQuantidadedeMortes);
             stmt.setString(5, lCNPJ_D);
             
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
		
		String lCNPJ = obj.getCNPJ();
        int lQuantidadeInternados = obj.getQuantidadeInternados();
        int lQuantidadeCurados = obj.getQuantidadeCurados();
        int lQuantidadedeMortes = obj.getQuantidadedeMortes();
		String lCNPJ_D = obj.getDestino().getCNPJ();		
		   
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Casoscovid SET CNPJ = ?, QuantidadeInternados  = ?,QuantidadeCurados = ?, QuantidadedeMortes = ?, CNPJ = ?  WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
              
			 objstmt.setString(1, lCNPJ);
             objstmt.setInt(2, lQuantidadeInternados);
             objstmt.setInt(3, lQuantidadeCurados);
             objstmt.setInt(4, lQuantidadedeMortes);
             objstmt.setString(5, lCNPJ_D);
          
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Casoscovid obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lCNPJ = obj.getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Casoscovid WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(5, lCNPJ);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

     
		
    }