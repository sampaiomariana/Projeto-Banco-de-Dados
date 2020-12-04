
package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.lote;
import model.bean.Destino;

/**
 *
 * @author sampa
 */



public class loteDAO {


    
    public void inserir (lote obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdLote = obj.getIdLote();
        String lFornecedor = obj.getFornecedor();
        float lValor = obj.getValor();
        String lCNPJDestino = obj.getDestino().getCNPJ();
        objBD.conectar();
        
  
              
        try {
            
             String sql = ("INSERT INTO lote ( IdLote,Fornecedor,Valor,CNPJ) VALUES  (?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

			
             
             stmt.setInt(1, lIdLote);
             stmt.setString(2, lFornecedor);
             stmt.setFloat(3, lValor);
             stmt.setInt(4, lCNPJDestino);
             stmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do insert"+ex.getMessage());
        }
		
	
	public ResultSet selecionar (){
        
        ConectarBD objBD = new ConectarBD();
      
        
        objBD.conectar();
        try {
            
            String sql = "SELECT lote.* FROM lote " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (lote obj){
         
          ConectarBD objBD = new ConectarBD();
          
      
        int lIdLote = obj.getIdLote();
        String lFornecedor = obj.getFornecedor();
        float lValor = obj.getValor();
        String lCNPJDestino = obj.getDestino().getCNPJ();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  lote SET IdLote= ?,Fornecedor = ?,Valor = ?, CNPJ = ? WHERE IdLote = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
             
			   
             objstmt.setInt(1, lIdLote);
             objstmt.setString(2, lFornecedor);
             objstmt.setFloat(3, lValor);
             objstmt.setInt(4, lCNPJDestino);
             objstmt.execute();
			 
            
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (lote obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdLote = obj.getIdLote();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM lote WHERE IdItem = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(4, lIdLote);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

     
    
    
	
	}
    




























