package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetobd.bean.Financiamento;
import projetobd.bean.Pesquisa;
/**
 *
 * @author sampa
 */



public class FinanciamentoDAO {


    
    public void inserir (Financiamento obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdFinanciamento = obj.getIdFinanciamento();
        String lCPFouCNPJ = obj.getCPFouCNPJ ();
        String lPublicoouPrivado= obj.getPublicoouPrivado();
        int lValor = obj.getValor();
        int lIdPesquisa = obj.getPesquisa().getIdPesquisa();
        
        objBD.conectar();
        

        
        
        
        try {
            
             String sql = ("INSERT INTO Financiamento ( IdFinanciamento,CPFouCNPJ,PublicoouPrivado,Valor,IdPesquisa) VALUES  (?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdFinanciamento);
             stmt.setString(2, lCPFouCNPJ);
             stmt.setString(3, lPublicoouPrivado);
             stmt.setInt(4, lValor);
             stmt.setInt(5, lIdPesquisa);
             
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
            
            String sql = "SELECT Financiamento.* FROM Financiamento " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Financiamento obj){
         
          ConectarBD objBD = new ConectarBD();
         
        int lIdFinanciamento = obj.getIdFinanciamento();
        String lCPFouCNPJ = obj.getCPFouCNPJ ();
        String lPublicoouPrivado= obj.getPublicoouPrivado();
        int lValor = obj.getValor();
        int lIdPesquisa = obj.getPesquisa().getIdPesquisa();  
       
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Financiamento SET IdFinanciamento= ?, CPFouCNPJ= ?,PublicoouPrivado= ?, Valor = ?, IdPesquisa = ?  WHERE IdItem = ?" ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
			  
             objstmt.setInt(1, lIdFinanciamento);
             objstmt.setString(2, lCPFouCNPJ);
             objstmt.setString(3, lPublicoouPrivado);
             objstmt.setInt(4, lValor);
             objstmt.setInt(5, lIdPesquisa);
            
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Financiamento obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdFinanciamento = obj.getIdFinanciamento();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Financiamento WHERE IdFinanciamento = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(5, lIdFinanciamento);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução "+ex.getMessage());
        }
    }

     
    
   
		
    }
    