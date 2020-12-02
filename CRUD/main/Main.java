/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	public static void main (String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:8111/covid";
		String User = "root";
		String password = "";
		
		try {
		Connection conexao = DriverManager.getConnection(jdbcURL, User, password);
		
		//Create 
		String sql = "INSERT INTO Item (IdItem, Nome, Tipodeitem, Producaohistorica, Producaodoultimomes)\n" +
"VALUES ('3479', 'Bamlanivimab', 'Medicamento', '108708', '32531') ";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		
		int rows = stmt.executeUpdate(sql );
		
		if(rows > 0) {
			
			System.out.println("Um novo item foi incluido no Banco de Dados.");
		}
				
		conexao.close();
		
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
		
		try {
		Connection conexao = DriverManager.getConnection(jdbcURL, User, password);
		
		//Select
		String sql = "SELECT * FROM item ";
		Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                while (rs.next()){
                 
                 
                int IdItem = rs.getInt(1);
                String Nome = rs.getString(2);
                String Tipodeitem = rs.getString(3);
                int Producaohistorica = rs.getInt(4);
                int Producaodoultimomes = rs.getInt(5);
                
                    System.out.println(IdItem +":" + Nome + "," + Tipodeitem + "," +Producaohistorica + "," +Producaodoultimomes);
                }
		conexao.close();
		
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
                
               try {
		Connection conexao = DriverManager.getConnection(jdbcURL, User, password);
		
		//Update
		String sql = "UPDATE item SET Nome = 'Respirador 02' WHERE Tipodeitem = 'Respirador'";
		
		Statement stmt = conexao.createStatement();
		
		
		int rows = stmt.executeUpdate(sql );
		
		if(rows > 0) {
			
			System.out.println("Um novo item foi atualizado no Banco de Dados.");
		}
				
		conexao.close();
		
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
                
                try {
		Connection conexao = DriverManager.getConnection(jdbcURL, User, password);
		
                int IdItem = 326;
		//Delete
		String sql = "DELETE FROM item WHERE IdItem = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
               
		stmt.setInt(1,IdItem);
		
		int rows = stmt.executeUpdate();
		
		if(rows > 0) {
			
			System.out.println("Um novo item foi excluido no Banco de Dados.");
		}
				
		conexao.close();
		
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
                
               
			
	

}
}
    