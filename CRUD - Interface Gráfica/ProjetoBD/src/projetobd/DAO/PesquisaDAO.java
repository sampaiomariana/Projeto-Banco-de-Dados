package projetobd.DAO;

import java.sql.Connection;
import projetobd.connection.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import projetobd.bean.Pesquisa;
import projetobd.bean.PesquisadorChefe;
import projetobd.bean.Localidade;


/**
 *
 * @author sampa
 */



public class PesquisaDAO {


    
    public void inserir (Pesquisa obj){
       
       
        ConectarBD objBD = new ConectarBD();
        
        int lIdPesquisa = obj.getIdPesquisa();
        int lNumerodeVoluntarios = obj.getNumerodeVoluntarios();
        float lTaxadeEficacia = obj.getTaxadeEficacia();
        Date lDatadeInicio = obj.getDatadeInicio();
        Date lDatadeTermino = obj.getDatadeTermino();
	int lCadastroPesquisador = obj.getPesquisador().getCadastroPesquisador();
	String lCNPJLocalidade = obj.getLocalidade().getCNPJ();
        
        objBD.conectar();
       
        
        
        try {
            
             String sql = ("INSERT INTO Pesquisa ( IdPesquisa,NumerodeVoluntarios,TaxadeEficacia,DatadeInicio,DatadeTermino,CadastroPesquisador,CNPJ) VALUES  (?,?,?,?,?,?,?)");
        
            
             PreparedStatement stmt = objBD.conexao.prepareStatement(sql);

             
             stmt.setInt(1, lIdPesquisa);
             stmt.setInt(2, lNumerodeVoluntarios);
             stmt.setFloat(3, lTaxadeEficacia);
             stmt.setDate(4, (java.sql.Date) lDatadeInicio);
             stmt.setDate(5, (java.sql.Date) lDatadeTermino);
            stmt.setInt (6, lCadastroPesquisador);
            stmt.setString (7, lCNPJLocalidade);
             
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
            
            String sql = "SELECT Pesquisa.* FROM Pesquisa " ;
        
            PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            ResultSet rs =  objstmt.executeQuery();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do select "+ex.getMessage());
        }
        return null;
          
        
    }

    
   public void atualizar (Pesquisa obj){
         
          ConectarBD objBD = new ConectarBD();
          
		int lIdPesquisa = obj.getIdPesquisa();
        int lNumerodeVoluntarios = obj.getNumerodeVoluntarios();
        float lTaxadeEficacia = obj.getTaxadeEficacia();
        Date lDatadeInicio = obj.getDatadeInicio();
        Date lDatadeTermino = obj.getDatadeTermino();
	int lCadastroPesquisador = obj.getPesquisador().getCadastroPesquisador();
	String lCNPJLocalidade = obj.getLocalidade().getCNPJ();
        
        objBD.conectar();
     try {
            
            String sql = "UPDATE  Pesquisa SET IdPesquisa = ?, NumerodeVoluntarios = ?,TaxadeEficacia = ?, DatadeInicio = ?, DatadeTermino = ?, CadastroPesquisador = ?, CNPJ = ? ,  WHERE IdPesquisa= ?" ;
        
			
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
             
             objstmt.setInt(1, lIdPesquisa);
             objstmt.setInt(2, lNumerodeVoluntarios);
             objstmt.setFloat(3, lTaxadeEficacia);
             objstmt.setDate(4, (java.sql.Date) lDatadeInicio);
             objstmt.setDate(5, (java.sql.Date) lDatadeTermino);
            objstmt.setInt (6, lCadastroPesquisador);
            objstmt.setString (7, lCNPJLocalidade);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução do update"+ex.getMessage());
        }
    }

    public void deletar (Pesquisa obj){  
        ConectarBD objBD = new ConectarBD();
      
        int lIdPesquisa = obj.getIdPesquisa();
        objBD.conectar();
        try {
            
            String sql = "DELETE FROM Pesquisa WHERE IdPesquisa = ?" ;
        
             PreparedStatement  objstmt = objBD.conexao.prepareStatement(sql);
            
             objstmt.setInt(7, lIdPesquisa);
             
             objstmt.execute();
             
             JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na execução"+ex.getMessage());
        }
    }

    }
    