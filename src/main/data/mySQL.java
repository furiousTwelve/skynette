package main.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;

import main.controller.Records;
import main.controller.dataTransfer;

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
	
	public dataTransfer RecordsGenerate(dataTransfer dataToSend)
	{
		ResultSet rs = null;
		Records rec = null;
		int j = 0;
		
		String dateToExtract = dataToSend.getDate();
		String hour = dateToExtract.substring(11,13);
		
		try {
			statement = (Statement) connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Fill the 7 rows needed with the search request
		String sql = "SELECT * FROM WeatherData "
				   + "INNER JOIN ImgTable ON ImgTable.idImg = WeatherData.idImg "
				   + "INNER JOIN City ON City.idCity = WeatherData.idCity "
				   + "WHERE dateTime between date_sub(now(), interval 3 day) AND date_add(now(), interval 3 day) "
				   + "AND dateTime LIKE concat('%','" + hour + "','%') "
				   + "AND City.cityName = 'Montpellier' "
				   + "ORDER BY dateTime;";
		try 
		{
			rs = statement.executeQuery(sql);
			while(rs.next())
			{
				rec = new Records();
				rec.setClouds(rs.getInt("clouds"));
				rec.setDeg(rs.getFloat("windDirection"));
				rec.setHumidity(rs.getInt("humidity"));
				rec.setPressure(rs.getFloat("pressure"));
				rec.setRain(rs.getFloat("rainfall"));
				rec.setSnow(rs.getInt("snow"));
				rec.setSpeed(rs.getFloat("windSpeed"));
				rec.setTemp(rs.getFloat("temperature"));
				rec.setWeatherDescription(rs.getString("forecast"));
				
				dataToSend.sevenRecordsTab[j] = rec;
				System.out.println("1 row assigned to SQLite returns");
				j++;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		
		for(int i = 0; i <= j ; i++)
		{
			rec = new Records();
			dataToSend.getSevenRecordsTab()[i] = new Records();
			rec.setClouds(0);
			rec.setDeg(0);
			rec.setHumidity(0);
			rec.setPressure(0);
			rec.setRain(0);
			rec.setSnow(0);
			rec.setSpeed(0);
			rec.setTemp(0);
			rec.setWeatherDescription("");
			
			dataToSend.getSevenRecordsTab()[i] = rec;
		}

		return dataToSend;
	}

}
