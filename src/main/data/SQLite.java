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


import java.util.ArrayList;
import org.sqlite.*;
import main.controller.City;
import main.controller.Records;
import main.controller.dataTransfer;

public class SQLite {

	protected Connection c = null;
	protected Statement stmt = null;

	public void verifyDB() {

		File laBase = new File("./meteoSkynette.db");
		if (laBase.exists()) {
			// Run the insertion
			System.out.println("Insertion en cours...");
			//Connexion();
			
			// Pourquoi ce code ? on demande juste de vérifier la DB sinon création... Cyril
			//dataTransfer data = new dataTransfer();

			//insertDataFromMySQL(data.getCityName(), data.getSevenRecordsTab());
		} else {
			try {
				System.out.println("je me cree");

				Connexion();
				creationDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * This will create then connect you to the database
	 * 
	 * @author Benjamin
	 * @version 1.0
	 */
	public void Connexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		//System.out.println("Creation database successfully, well done !");
		try {			
			this.stmt = this.c.createStatement();
			System.out.println("valeur stmt :"+stmt);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void close() {
        try {
            this.c.close();
            this.stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * This will run the script that will create the tables
	 * 
	 * @author Benjamin
	 * @version 1.0
	 */
	public void creationDB() throws SQLException {

		System.out.println("ici creation");
		String chaine = "";
		String fichier = "script_SQLite.sql";
		// to move to the git repertory later


		// Read the file
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {

				System.out.println(ligne);

				

				chaine += ligne + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		stmt.executeUpdate(chaine);
		
	}

	/**
	 * This fill the tables with the values we need
	 * 
	 * @author Benjamin
	 * @version 1.0
	 */
	// Insert data to our several Tabs
	public void insertDataFromMySQL(String name,ArrayList<Records>  records) {
		 
		System.out.println("insert data : nom de la ville :"+name);
		
		this.Connexion();
		System.out.println("ouvre connection");
		for (int i = 0; i < records.size(); i++) {
			
			
			
			System.out.println(records.get(i).getDateDay());
			System.out.println(records.get(i).getTemp());
			System.out.println(records.get(i).getPressure());
			System.out.println(records.get(i).getSpeed());
			System.out.println(records.get(i).getWindDirection());
			System.out.println(records.get(i).getRain());
			System.out.println(records.get(i).getClouds());
			System.out.println(records.get(i).getLogoWeather());
			
			Date dateDay = records.get(i).getDateDay();
			float temp = records.get(i).getTemp();
			float pressure = records.get(i).getPressure();
			float speed = records.get(i).getSpeed();
			String direction = records.get(i).getWindDirection();
			float rain = records.get(i).getRain();
			int cloud = records.get(i).getClouds();
			int snow = records.get(i).getSnow();
			Blob logo = records.get(i).getLogoWeather();
			String sql = "INSERT INTO WeatherData (dateDay, temperature, pressure, windSpeed, windDirection, rainfall, clouds, snow) VALUES ('"
					+ dateDay + "' , " + temp + " , " + pressure + " , " + speed + " ,'" + direction + "' , " + rain
					+ " , " + cloud + " , " + snow + ");";
			
System.out.println("requete : "+sql);
			System.out.println("valeur stmt :"+this.stmt);
			
			try {
				
				int j = this.stmt.executeUpdate(sql);
				System.out.println("valeur de j :"+j);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		System.out.println("je ferme la connection");
		this.close();
	}




	// /**
	// * This method allows to fetch datas for the main window
	// * @author Benjamin Champetier
	// * @author Florent Valadier
	// * @return sevenRecords Records[7]
	// */
	// public Records[] DataForWindow(){
	// Records[] sevenRecords = new Records[7];
	// String sql = "SELECT dateDay, temperature, pressure, windSpeed,
	// windDirection, rainfall, clouds, snow, idImg, imgWind FROM WeatherData
	// ORDER BY dateDay;";
	// int i = 0;
	// try {
	// ResultSet res = stmt.executeQuery(sql);
	// while(res.next()){
	// Records rec = new Records();
	// rec.setDateDay(res.getDate("dateDay"));
	// rec.setTemp(res.getFloat("temperature"));
	// rec.setPressure(res.getFloat("pressure"));
	// rec.setSpeed(res.getFloat("windSpeed"));
	// rec.setWindDirection(res.getString("windDirection"));
	// rec.setRain(res.getFloat("rain"));
	// rec.setClouds(res.getInt("clouds"));
	// rec.setSnow(res.getInt("snow"));
	// rec.setLogoWeather(res.getBlob("idImg"));
	// rec.setLogoWind(res.getBlob("imgWind"));
	// sevenRecords[i] = rec;
	// }
	// }
	// catch (SQLException e)
	// {
	// e.printStackTrace();
	// }
	//
	// return sevenRecords;
	// }


	/**
	 * This method allows to fetch datas for the main window
	 * 
	 * @author Benjamin Champetier
	 * @author Florent Valadier
	 * @return sevenRecords Records[7]
	 */

  	
  	/**
  	 * This method allows to fetch datas for the main window
  	 * @author Benjamin Champetier
  	 * @author Florent Valadier
  	 * @return sevenRecords Records[7]
  	 */
  	public ArrayList<Records> DataForWindow(){
  		ArrayList<Records> sevenRecords = new ArrayList<Records>();
  		this.Connexion();
  		String sql = "SELECT dateDay, temperature, pressure, windSpeed, windDirection, rainfall, clouds, snow, idImg FROM WeatherData ORDER BY dateDay;";
  		int i = 0;
  		try {
  			System.out.println("avant select");
			ResultSet res = stmt.executeQuery(sql);
			System.out.println("valeur stmt "+stmt);
			System.out.println("valeur res :"+res.getRow());
			while (res.next()) {
				System.out.println("valeur i"+i);
				System.out.println("valeur temp"+res.getFloat("temperature"));
				i++;
				Records rec = new Records();
			//	rec.setDateDay(res.getDate("dateDay"));
				rec.setTemp(res.getFloat("temperature"));
				rec.setPressure(res.getFloat("pressure"));
				rec.setSpeed(res.getFloat("windSpeed"));
				rec.setWindDirection(res.getString("windDirection"));
				rec.setRain(res.getFloat("rainfall"));
				rec.setClouds(res.getInt("clouds"));
				rec.setSnow(res.getInt("snow"));
			//	rec.setLogoWeather(res.getBlob("idImg"));
			//	rec.setLogoWind(res.getBlob("imgWind"));
				sevenRecords.add(rec);
				System.out.println("ca passe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
  		
  	//	this.close();
		return sevenRecords;
	}

	/**
	 * This method allows to update the table Preview with datas for the preview
	 * window
	 * 
	 * @author Benjamin Champetier
	 * @author Florent Valadier
	 * @param iconeTemps
	 * @param temperature
	 * @param windDirection
	 * @param windSpeed
	 */
	public void insertPreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed,
			String idCity) {
		String sql = "INSERT INTO Preview ( idCity, iconeTemps, temperature, windDirection, windSpeed) VALUES ("
				+ idCity + "," + iconeTemps + " , " + temperature + " , '" + windDirection + "' , " + windSpeed + ");";
		try {
			int j = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("erreur !!!");

		}
	}

	public void updatePreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed,
			String idCity) {

		String sql = "UPDATE Preview SET iconeTemps = " + iconeTemps + ", temperature = " + temperature

				+ ", windDirection = '" + windDirection + "', windSpeed = " + windSpeed + " WHERE idCity = '" + idCity
				+ "';";
		try {
			int j = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method allows to select datas from Preview table to update the
	 * preview window
	 * 
	 * @author Benjamin Champetier
	 * @author Florent Valadier
	 * @param iconeTemps
	 * @param temperature
	 * @param windDirection
	 * @param windSpeed
	 */
	public void DataForPreview(Blob iconeTemps, float temperature, String windDirection, Float windSpeed) {
		String sql = "SELECT iconeTemps, temperature, windDirection, windSpeed FROM Preview;";
		try {
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				iconeTemps = res.getBlob("iconeTemps");
				temperature = res.getFloat("temperature");
				windDirection = res.getString("windIrection");
				windSpeed = res.getFloat("windSpeed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method insert a city into the table City if it doesn't exist
	 * 
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
	public void insertCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay, float amplitudeMax,
			float amplitudeMin) {
		String sql = "INSERT INTO City (idCity, cityName, longitude, latitude, rainDay, sunDay, coldestDay, hottestDay, amplitudeMax, amplitudeMin, countryName) VALUES ('"
				+ city.getId() + "', '" + city.getName() + "', " + city.getLon() + ", " + city.getLat() + ", " + rainDay
				+ ", " + sunDay + ", " + coldestDay + ", " + hottestDay + ", " + amplitudeMax + ", " + amplitudeMin
				+ ", '" + city.getCountry() + "');";
		try {
			int j = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method update
	 * 
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
	public void updateCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay, float amplitudeMax,
			float amplitudeMin) {
		String sql = "UPDATE City SET cityName = '" + city.getName() + "' , longitude = " + city.getLon()
				+ ", latitude = " + city.getLat() + ", rainDay = " + rainDay + ", sunDay = " + sunDay
				+ ", coldestDay = " + coldestDay + ", hottestDay = " + hottestDay + ", amplitudeMax = " + amplitudeMax
				+ ", amplitudeMin = " + amplitudeMin + ", countryName = " + city.getCountry() + "WHERE idCity = '"
				+ city.getId() + "';";
		try {
			int j = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method modify the values of the parameters to update datas for city
	 * on main windows
	 * 
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
	public void selectDataCity(City city, int rainDay, int sunDay, float hottestDay, float coldestDay,
			float amplitudeMax, float amplitudeMin, Blob imgRain, Blob imgSun) {
		String sql = "SELECT * FROM City;";
		try {
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}