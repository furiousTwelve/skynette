package main.data;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

import main.controller.DatasForIcon;
import main.controller.DatasForWindow;

/**
 * @author AnaisGueyte
 * @date 22/09/2016
 * @version Skynette 0.1
 * 
 *          This claims aims to pass fresh datas from SQLite database to the
 *          controller methods updateIcon() & updateMainWindow() and update the
 *          datas in the widget and main Window
 *
 */

public class ShuttleDatas {
	
	DatasForIcon datas = new DatasForIcon();
	DatasForWindow bigDatas = new DatasForWindow();
	

	// ******* CONSTRUCTOR ******* //

	public ShuttleDatas() {

	}

	// ******* METHOD ******* //

	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version Skynette 0.1
	 * 
	 *          This method connects to the SQLite database to fetch 4 datas
	 *
	 */

	public DatasForIcon fetchFreshData() throws SQLException {

		Connection c = null;
		Statement stmt = null;
		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Connection databa successfully, well done !");

		stmt = c.createStatement();

		String sql = "SELECT forecastImg, temperature, windDirection, windSpeed FROM WeatherData INNER JOIN ImgTable ON weatherData.idimg = ImgTable.idimg WHERE datetime < NOW() ORDER BY datetime DESC LIMIT 1;";
		ResultSet res = (ResultSet) stmt.executeQuery(sql);

		// Not sure about the "WHERE datetime < NOW()" method to pick up the
		// latest insert of weather data.

		while (res.next()){
			datas.logoWeather = (com.mysql.jdbc.Blob) res.getBlob(1);
			datas.temperature = res.getFloat(2);
			datas.windDirection = res.getString(3);
			datas.windSpeed = res.getFloat(4);
		}
		return datas;
		
	}
	
	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version Skynette 0.1
	 * 
	 *          This method connects to the SQLite database to fetch 4 datas
	 *
	 */
	
/*	public DatasForIcon fetchFreshDataForMainWindow() throws SQLException {

		Connection c = null;
		Statement stmt = null;
		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:meteoSkynette.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Connection databa successfully, well done !");

		stmt = c.createStatement();

		String sql = "SELECT forecastImg, temperature, windDirection, windSpeed FROM WeatherData INNER JOIN ImgTable ON weatherData.idimg = ImgTable.idimg WHERE datetime < NOW() ORDER BY datetime DESC LIMIT 1;";
		ResultSet res = (ResultSet) stmt.executeQuery(sql);

		// Not sure about the "WHERE datetime < NOW()" method to pick up the
		// latest insert of weather data.

		while (res.next()){
			bigDatas.logoWeather = (com.mysql.jdbc.Blob) res.getBlob(1);
			bigDatas.temperature = res.getFloat(2);
			bigDatas.windDirection = res.getString(3);
			bigDatas.windSpeed = res.getFloat(4);
		}
		return datas;
			
		finally {
			c.close();
		}
		
	}*/
	
}
