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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
//		File laBase = new File("./meteoSkynette.db");
//		if(laBase.exists())
//		{
//			// Run the insertion
//			System.out.println("Insertion en cours...");
//			Connexion();
//			dataTransfer data = new dataTransfer();
//			insertDataFromMySQL(data.getCityName(), data.getSevenRecordsTab());
//		}
//		else
//		{
//			try 
//			{
//				Connexion();
//				creationDB();
//			} 
//			catch (SQLException e) 
//			{				
//				e.printStackTrace();
//			}
//		}
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
	String fichier ="./script_creationBDDSQL_Final_1.2ben.sql";
	
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

  		for (int i = 0; i < records.length; i++) {
  			Date dateDay = records[i].getDateDay();
  			float temp = records[i].getTemp();
  	  		float pressure=records[i].getPressure();
  	  		float speed=records[i].getSpeed();
  	  		String direction = records[i].getWindDirection();
  	  		float rain=records[i].getRain();
  	  		int cloud=records[i].getClouds();
  	  		int snow=records[i].getSnow();
  	  		Blob logo = records[i].getLogoWeather();
  	  		String sql = "INSERT INTO WeatherData ( dateDay, temperature, pressure, windSpeed, windDirection, rainfall, clouds, snow, idImg) VALUES ("+
  	  		dateDay+" , "+temp+" , "+pressure+" , "+speed+" , "+direction+" , "+rain+" , "+cloud+" , "+snow+" , "+logo+");";	
  	  		
  			try {
  				int j = stmt.executeUpdate(sql);
  				//int j = stmt.executeUpdate("INSERT INTO WeatherData VALUES (idWD, dateTime, temperature, windspeed, windDirection, gustMax, rainfall, presssure, snow, clouds, humidity, idCity, idImg )");
  			} 
  			catch (SQLException e) 
  			{
  				e.printStackTrace();
  			}
		}

  		
  	}
  	
  	/**
  	 * This method allows to fetch datas for the main window
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @return sevenRecords Records[7]
  	 */
  	public Records[] DataForWindow(){
  		Records[] sevenRecords = new Records[7];
  		String sql = "SELECT dateDay, temperature, pressure, windSpeed, windDirection, rainfall, clouds, snow, idImg, imgWind FROM WeatherData ORDER BY dateDay;";
  		int i = 0;
  		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()){
				Records rec = new Records();
				rec.setDateDay(res.getDate("dateDay"));
				rec.setTemp(res.getFloat("temperature"));
				rec.setPressure(res.getFloat("pressure"));
				rec.setSpeed(res.getFloat("windSpeed"));
				rec.setWindDirection(res.getString("windDirection"));
				rec.setRain(res.getFloat("rain"));
				rec.setClouds(res.getInt("clouds"));
				rec.setSnow(res.getInt("snow"));
				rec.setLogoWeather(res.getBlob("idImg"));
				rec.setLogoWind(res.getBlob("imgWind"));
				sevenRecords[i] = rec;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  		
		return sevenRecords;
  	}
  	
  	/**
  	 * This method allows to update the table Preview with datas for the preview window
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @param iconeTemps
  	 * @param temperature
  	 * @param windDirection
  	 * @param windSpeed
  	 */
  	public void insertPreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed, String idCity){
  		String sql = "INSERT INTO Preview ( idCity, iconeTemps, temperature, windDirection, windSpeed) VALUES ("+idCity+","+iconeTemps+" , "+temperature+" , '"+windDirection+"' , "+windSpeed+");";
  		try {
				int j = stmt.executeUpdate(sql);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
  	}
  	
  	public void updatePreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed, String idCity){
  		String sql = "UPDATE Preview SET iconeTemps = "+iconeTemps+", temperature = "+temperature+", windDirection = '"+windDirection+"', windSpeed = "+windSpeed+" WHERE idCity = '"+idCity+"';";
  		try {
			int j = stmt.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  	}
  	
  	/**
  	 * This method allows to select datas from Preview table to update the preview window
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @param iconeTemps
  	 * @param temperature
  	 * @param windDirection
  	 * @param windSpeed
  	 */
  	public void DataForPreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed){
  		String sql = "SELECT iconeTemps, temperature, windDirection, windSpeed FROM Preview;";
  		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()){
				iconeTemps = res.getBlob("iconeTemps");
				temperature = res.getFloat("temperature");
				windDirection = res.getString("windIrection");
				windSpeed = res.getFloat("windSpeed");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  	}
  	
  	/**
  	 * This method insert a city into the table City if it doesn't exist
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @param city
  	 * @param rainDay
  	 * @param sunDay
  	 * @param hottestDay
  	 * @param coldestDay
  	 * @param amplitudeMax
  	 * @param amplitudeMin
  	 */
  	public void insertCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay, float amplitudeMax, float amplitudeMin){
  		String sql = "INSERT INTO City (idCity, cityName, longitude, latitude, rainDay, sunDay, coldestDay, hottestDay, amplitudeMax, amplitudeMin, countryName) VALUES ('"+city.getId()+"', '"+city.getName()+"', "+
  				city.getLon()+", "+city.getLat()+", "+rainDay+", "+sunDay+", "+coldestDay+", "+hottestDay+", "+amplitudeMax+", "+amplitudeMin+", '"+city.getCountry()+"');";
  		try {
			int j = stmt.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  	}
  	
  	/**
  	 * This method update 
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @param city
  	 * @param rainDay
  	 * @param sunDay
  	 * @param hottestDay
  	 * @param coldestDay
  	 * @param amplitudeMax
  	 * @param amplitudeMin
  	 */
  	public void updateCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay, float amplitudeMax, float amplitudeMin ){
  		String sql = "UPDATE City SET cityName = '"+city.getName()+"' , longitude = "+city.getLon()+", latitude = "+city.getLat()+", rainDay = "+rainDay+", sunDay = "+sunDay+", coldestDay = "+coldestDay
  				+", hottestDay = "+hottestDay+", amplitudeMax = "+amplitudeMax+", amplitudeMin = "+amplitudeMin+", countryName = "+city.getCountry()+"WHERE idCity = '"+city.getId()+"';";
  		try {
			int j = stmt.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  	}
  	
  	/**
  	 * this method modify the values of the parameters to update datas for city on main windows
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @param city
  	 * @param rainDay
  	 * @param sunDay
  	 * @param hottestDay
  	 * @param coldestDay
  	 * @param amplitudeMax
  	 * @param amplitudeMin
  	 * @param imgRain
  	 * @param imgSun
  	 * @param imgWind
  	 */
  	public void selectDataCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay, float amplitudeMax, float amplitudeMin, Blob imgRain, Blob imgSun ){
  		String sql = "SELECT * FROM City;";
  		try {
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()){
				city.setCountry(res.getString("countryName"));
				city.setId(res.getString("idCity"));
				city.setName(res.getString("cityName"));
				city.setLon(res.getFloat("longitude"));
				city.setLat(res.getFloat("latitude"));
				rainDay = res.getInt("rainDay");
				sunDay = res.getInt("sunDay");
				hottestDay = res.getFloat("hottestDay");
				coldestDay = res.getFloat("coldestDay");
				amplitudeMax = res.getFloat("amplitudeMax");
				amplitudeMin = res.getFloat("amplitudeMin");
				imgRain = res.getBlob("imgRain");
				imgSun = res.getBlob("imgSun");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
  	}
}