package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobd.bean.Item;
import projetobd.bean.Destino;
import projetobd.bean.HistoricodeConsumo;

/**
 *
 * @author sampa
 */



public class HistoricodeConsumoDAO {


    
    public void inserir (HistoricodeConsumo obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        String lCNPJDestino = obj.getDestino().getCNPJ();
        int lMes = obj.getMes();
        int  lIdItem = obj.getItem().getIdItem();
        int lQuantidadeMensal = obj.getQuantidadeMensal();
        objBD.conectar();
        
        
        try {
            
             String sql = ("INSERT INTO HistoricodeConsumo (CNPJ, Mes, IdItem, QuantidadeMensal) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             stmt.setString (1, lCNPJDestino);
             stmt.setInt(2, lMes);
             stmt.setInt(3, lIdItem);
             stmt.setInt(4, lQuantidadeMensal);
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
            
            String sql = "SELECT HistoricodeConsumo.* FROM HistoricodeConsumo " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (HistoricodeConsumo obj){
         
          ConectarBD objBD = new ConectarBD();
          
         
        String lCNPJDestino = obj.getDestino().getCNPJ();
        int lMes = obj.getMes();
        int  lIdItem = obj.getItem().getIdItem();
        int lQuantidadeMensal = obj.getQuantidadeMensal();
        objBD.conectar();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  HistoricodeConsumo SET CNPJ = ?, Mes = ?,IdItem = ?, QuantidadeMensal = ? WHERE CNPJ = ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
			 objstmt.setString (1, lCNPJDestino);
             objstmt.setInt(2, lMes);
             objstmt.setInt(3, lIdItem);
             objstmt.setInt(4, lQuantidadeMensal);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (HistoricodeConsumo obj){  
        ConectarBD objBD = new ConectarBD();
      
       String lCNPJDestino = obj.getDestino().getCNPJ();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM HistoricodeConsumo WHERE CNPJ = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setString(4, lCNPJDestino);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

     
    
    }
