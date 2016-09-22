package main.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

}
