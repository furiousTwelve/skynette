package main.data;
/**
 * This class has for purspose to create a SQLite database in order to get data from SQL main data
 * @author Benjamin
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import main.controller.City;
import main.controller.Records;
import main.controller.dataTransfer;

public class SQLite{
	
	protected Connection c = null;
	protected Statement stmt = null;
	
	public void verifyDB()
	{
		File laBase = new File("./meteoSkynette.db");
		if(laBase.exists())
		{
			// Run the insertion
			System.out.println("Insertion en cours...");
			Connexion();
			dataTransfer data = new dataTransfer();
			insertDataFromMySQL(data.getCityName(), data.getSevenRecordsTab());
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
	
	/**
	 * This will create then connect you to the database
	 * @author Benjamin
	 * @version 1.0
	 */
	public void Connexion()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Creation database successfully, well done !");
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
	}
	/**
	 * This will run the script that will create the tables
	 * @author Benjamin
	 * @version 1.0
	 */
	public void creationDB() throws SQLException
	{
 
    String chaine="";
    // to move to the git repertory later
	String fichier ="U:/Partage/15-Projet Skynette/Donnees/script_creationBDDSQL_Final_1.2ben.sql";
	
	//Read the file	
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
	/**
	 * This fill the tables with the values we need
	 * @author Benjamin
	 * @version 1.0
	 */	
	//Insert data to our several Tabs
  	public void insertDataFromMySQL(String name, Records[] records)
  	{
  		float temp = records[0].getTemp();
  		float pressure=records[0].getPressure();
  		int humidity=records[0].getHumidity();
  		float speed=records[0].getSpeed();
  		float deg=records[0].getDeg();
  		float rain=records[0].getRain();
  		int cloud=records[0].getClouds();
  		int snow=records[0].getSnow();
  		String description = records[0].getWeatherDescription();
  		String sql = "INSERT INTO WeatherData ( temperature, windspeed, windDirection, rainfall, pressure, snow, clouds, humidity, idWD, dateTime, gustMax, idCity, idImg) VALUES ("+
  		temp+" , "+speed+" , "+deg+" , "+rain+" , "+pressure+" , "+snow+" , "+cloud+" , "+humidity+" , "+4+" , '2016-09-23 09:00:00', "+null+" , '34000' , "+123+");";	
  		
		try {
			int i = stmt.executeUpdate(sql);
			System.out.println(i);
			//int j = stmt.executeUpdate("INSERT INTO WeatherData VALUES (idWD, dateTime, temperature, windspeed, windDirection, gustMax, rainfall, presssure, snow, clouds, humidity, idCity, idImg )");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
  	}
}