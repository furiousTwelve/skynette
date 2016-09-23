package main.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;

import main.controller.Records;

public class mySQL {
	
	private Connection connection;
	private Statement statement;
	private String url= "jdbc:mysql://sta6101858:3306/skynette_1_0"; 
	private String login = "cdi";
	private String passwd = "cdi";
	
	public void Connexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, login,  passwd);
		} catch (Exception e) 
		{
			System.out.println("erreur de connexion à MySQL");
			e.printStackTrace();			
		}
		
		
		try 
		{
			statement = connection.createStatement();
		} catch (SQLException e) 
		{
			System.out.println("erreur de statement à MySQL");	
			
		}
		 
	}
	
	public Records[] RecordsGenerate(/* paramètres à définir */)
	{
		Records[] rec = new Records[7];
		ResultSet rs = null;
		
		try {
			statement = (Statement) connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Fill the 7 rows needed with the search request
		String sql = "SELECT * FROM;";
		try 
		{
			rs = ((Statement) connection).executeQuery(sql);
			
			int i = 0;
			while(rs.next())
			{
				rec[i] = (Records) rs;
				i++;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return rec;
	}

}
