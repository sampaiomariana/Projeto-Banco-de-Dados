/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		String sql = "select * from item";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		
		int rows = stmt.executeUpdate(sql );
		
		if(rows > 0) {
			
			System.out.println("Um novo item foi incluido no Banco de Dados.");
		}
				
		conexao.close();
		
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
		
			
	

}
}
    