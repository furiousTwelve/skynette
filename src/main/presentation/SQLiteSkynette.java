package main.presentation;
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
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class SQLiteSkynette{
	
  public static void main( String args[] ) throws Throwable{
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Creation databa successfully, well done !");
    
    stmt = c.createStatement();
    
    String chaine="";
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
  	public void recupere(){
  		Connection c = null;
  		Statement stmt = null;
  		try {
  			stmt = c.createStatement();
  			int i = stmt.executeUpdate("INSERT INTO city VALUES (") ;
	
  			} catch (SQLException e) 
  		{
  			e.printStackTrace();
  		}  
  	}
}