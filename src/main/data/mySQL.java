package main.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.controller.Records;
import main.controller.dataTransfer;
/**
 * 
 * @author Lionel Chialvo et Martinez Alban
 * @version 1.0
 * @date 26/09/2016 
 *
 */
public class mySQL {
	
	private Connection connection;
	private Statement statement;
	private String url= "jdbc:mysql://10.111.61.13:3306/skynette_1_0"; 
	private String login = "cdi";
	private String passwd = "cdi";
	
	/**
	 * Method using driver for database connexion
	 * @author Lionel Chialvo
	 * @author Alban Martinez
	 * @date : 26/09/2016
	 */
	public void Connexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, login,  passwd);
			System.out.println("Connexion mysql ok");
		} 
		catch (Exception e) 
		{
			System.out.println("erreur de connexion à MySQL");
			e.printStackTrace();			
		}
		
		try 
		{
			statement = connection.createStatement();
		} 
		catch (SQLException e) 
		{
			System.out.println("erreur de statement à MySQL");	
		}
		 
	}
	/**
	 * Method to generate records
	 * @param dataToSend
	 * @return dataToSend
	 * @author Lionel Chialvo
	 * @author Alban Martinez
	 */
	public dataTransfer RecordsGenerate(dataTransfer dataToSend)
	{
		ResultSet rs = null;
		Records rec = null;
		
		System.out.println("We generate here hahaha");
		
		String dateToExtract = dataToSend.getDate();
		String hour = dateToExtract.substring(11,13);
		
		for(int i = 0; i < 7; i++)
		{
			// here we initialize records 
			dataToSend.sevenRecordsTab[i] = new Records();
			rec = new Records();
			rec.setDateDay(null);
			rec.setClouds(0);
			rec.setDeg(0);
			rec.setPressure(0);
			rec.setRain(0);
			rec.setSnow(0);
			rec.setSpeed(0);
			rec.setTemp(0);
			rec.setHumidity(0);
			rec.setLogoWeather(null);
			dataToSend.sevenRecordsTab[i] = rec;
		}
		
		try 
		{
			statement = (Statement) connection.createStatement();
		} 
		catch (SQLException e1) 
		{
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
		
		System.out.println("ici");
		
		int j = 0;
		try 
		{
			rs = statement.executeQuery(sql);
			System.out.println(hour);
			while(rs.next())
			{
				// here we fill records 
				rec = new Records();
				rec.setDateDay(rs.getDate("dateTime"));
				rec.setClouds(rs.getInt("clouds"));
				rec.setDeg(rs.getFloat("windDirection"));
				rec.setPressure(rs.getFloat("pressure"));
				rec.setRain(rs.getFloat("rainfall"));
				rec.setSnow(rs.getInt("snow"));
				rec.setSpeed(rs.getFloat("windSpeed"));
				rec.setTemp(rs.getFloat("temperature"));
				rec.setHumidity(rs.getInt("humidity"));
				rec.setLogoWeather( rs.getBlob("forecastImg"));
				System.out.println(rec.getDateDay().toString());
				System.out.println(rec.getClouds());
				System.out.println(rec.getDeg());
				System.out.println(rec.getPressure());
				System.out.println(rec.getRain());
				System.out.println(rec.getSnow());
				
				
				dataToSend.sevenRecordsTab[j] = rec;
				System.out.println("1 row assigned to SQLite returns");
				j++;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dataToSend;
	}

}
