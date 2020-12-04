package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.lote;
import model.bean.Dadosdaentrega;

/**
 *
 * @author sampa
 */



public class DadosdaentregaDAO {


    
    public void inserir (Dadosdaentrega obj){
		
		
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdLote = obj.getLote().getIDlote();
        String lStatusLote = obj.getStatusLote();
        Date lDatadeSolicitacao = obj.getDatadeSolicitacao();
        Date lDatadeEntrega = obj.getDatadeEntrega();
        
        objBD.conectar();
        
        
        
        try {
            
             String sql = ("INSERT INTO Dadosdaentrega ( IdLote,StatusLote,DatadeSolicitacao, DatadeEntrega) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdLote);
             stmt.setString(2, lStatusLote);
             stmt.setString(3, lDatadeSolicitacao);
             stmt.setInt(4, lDatadeEntrega);
             
             
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
          
           
        int lIdLote = obj.getLote().getIDlote();
        String lStatusLote = obj.getStatusLote();
        Date lDatadeSolicitacao = obj.getDatadeSolicitacao();
        Date lDatadeEntrega = obj.getDatadeEntrega();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Dadosdaentrega SET IdLote = ?, StatusLote = ?,DatadeSolicitacao = ?,DatadeEntrega = ? WHERE IdLote = ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
			    
             objstmt.setInt(1, lIdLote);
             objstmt.setString(2, lStatusLote);
             objstmt.setString(3, lDatadeSolicitacao);
             objstmt.setInt(4, lDatadeEntrega);
            
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Dadosdaentrega obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdLote = obj.getIdLote();
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
	


		
		