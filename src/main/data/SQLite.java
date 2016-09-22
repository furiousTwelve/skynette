package main.data;
/**
 * This class has for purspose to create a SQLite database in order to get data from SQL main data
 */

/**
 * @author Benjamin
 * version 1.0
 * return the SQLite data from the SQL script data
 * param Get the data from SQL main data script
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class SQLite{
	
	protected Connection c = null;
	protected Statement stmt = null;
	
	public void verifyDB()
	{
		File laBase = new File("./meteoSkynette.db");
		if(laBase.exists())
		{
			// execute les insert
			System.out.println("Insertion en cours...");
			Connexion();
			insertDataFromMySQL();
		}
		else
		{
			try 
			{
				Connexion();
				creationDB();
			} 
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}
		}
	}
	
	
	public void Connexion()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Creation databa successfully, well done !");
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
	}
	
	public void creationDB() throws SQLException
	{
 
    String chaine="";
    // A deplacer
	String fichier ="U:/Partage/15-Projet Skynette/Donnees/script_creationBDDSQL_Final_1.2ben.sql";
	
	//lecture du fichier texte	
	try{
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;
		while ((ligne=br.readLine())!=null){
			//System.out.println(ligne);
			chaine+=ligne+"\n";
		}
		br.close(); 
	}		
	catch (Exception e){
		System.out.println(e.toString());
	}
	stmt.executeUpdate(chaine);
  }
	
  	public void insertDataFromMySQL()
  	{
  		
//		try {
//
//			int i = stmt.executeUpdate("INSERT INTO city VALUES (")"";
//
//		} catch (SQLException e) 
//		{
//			e.printStackTrace();
//		} 
  	}
}