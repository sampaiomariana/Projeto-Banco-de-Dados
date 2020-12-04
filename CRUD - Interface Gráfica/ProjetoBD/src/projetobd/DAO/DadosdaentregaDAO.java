package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import projetobd.bean.lote;
import projetobd.bean.Dadosdaentrega;

/**
 *
 * @author sampa
 */



public class DadosdaentregaDAO {


    
    public void inserir (Dadosdaentrega obj){
		
		
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdLote = obj.getLote().getIdLote();
        String lStatusLote = obj.getStatusLote();
        Date lDatadeSolicitacao = obj.getDatadeSolicitacao();
        Date lDatadeEntrega = obj.getDatadeEntegra();
        
        objBD.conectar();
        
        
        
        try {
            
             String sql = ("INSERT INTO Dadosdaentrega ( IdLote,StatusLote,DatadeSolicitacao, DatadeEntrega) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdLote);
             stmt.setString(2, lStatusLote);
             stmt.setDate(3, (java.sql.Date) lDatadeSolicitacao);
             stmt.setDate(4, (java.sql.Date) lDatadeEntrega);
             
             
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
            
            String sql = "SELECT Dadosdaentrega.* FROM Dadosdaentrega " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Dadosdaentrega obj){
         
          ConectarBD objBD = new ConectarBD();
          
           
        int lIdLote = obj.getLote().getIdLote();
        String lStatusLote = obj.getStatusLote();
        Date lDatadeSolicitacao = obj.getDatadeSolicitacao();
        Date lDatadeEntrega = obj.getDatadeEntegra();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Dadosdaentrega SET IdLote = ?, StatusLote = ?,DatadeSolicitacao = ?,DatadeEntrega = ? WHERE IdLote = ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
			    
             objstmt.setInt(1, lIdLote);
             objstmt.setString(2, lStatusLote);
             objstmt.setDate(3, (java.sql.Date) lDatadeSolicitacao);
             objstmt.setDate(4, (java.sql.Date) lDatadeEntrega);
            
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Dadosdaentrega obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdLote = obj.getLote().getIdLote();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Dadosdaentrega WHERE IdLote = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
				/*1 ou 4?*/
             objstmt.setInt(4, lIdLote);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

     
		
}
	


		
		