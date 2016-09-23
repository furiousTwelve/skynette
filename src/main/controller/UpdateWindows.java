package main.controller;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.mysql.jdbc.Blob;

import main.data.ShuttleDatas;

/**
 * This class aims to update the widget whenever the timer goes off and
 * big Window with fresh data fetched from SQLite database
 * This class aims to update the widget whenever the timer goes off and big
 * Window with fresh data fetched from SQLite database
 * 
 * @author AnaisGueyte
 * @date 21/09/2016
 * @version 0.1
 */
public class UpdateWindows {

	// ******* VARIABLES ******* //

	DatasForIcon datas = new DatasForIcon();
	DatasForWindow bigDatas = new DatasForWindow();

	// ******* METHOD ******* //

	/**
	 *  Method to update the desktop icon every 30 min when the
	 *  countdown reaches 0. This method must be called in the
	 *  MainWindow whenever the countdown = 0. First we call on the
	 *  SQLiteBDD method to fetch the data needed. Add them into an
	 *  object of type DataForIcon (internal class declared below) and
	 *  return that variable for the update of panelIcone
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version 0.1
	 * @return Object type DataForIcon named "datas"
	 * @throws SQLException 
	 */

	
		// >> Appel de la methode base de donnée pour recuper les données
		// >> Mettre a jour le nom de la classe bdd et la methode.

		/*
		 * 
		 * SQLiteBDD sqlitebdd = new SQLiteBDD(); datas =
		 * sqlite.methodeWitchFetcdata();
		 */
	public DatasForIcon updateIcon() throws SQLException {

	 
		 ShuttleDatas shuttledatas = new ShuttleDatas(); 
		  datas = shuttledatas.fetchFreshData();

		return datas;
	}

	/**
	 * Method to refresh datas of the main window when its open via the
	 * widget. This methode must be called with the listener in the
	 * PanelIcone class. First we call on the SQLiteBDD method to fetch
	 * the data needed. Add them into an object of type DataForWindow
	 * (internal class declared below) and return that variable for the
	 *  update of panelDetails.
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version 0.1
	 * @return Object type DataForWindow named "bigDatas"
	 */

	public DatasForWindow updateMainWindow() 
	{
		// >> Appel de la methode base de donnée pour recuper les données
		// >> Mettre a jour le nom de la classe bdd et la methode.

		/*
		 * 
		 * SQLiteBDD sqlitebdd = new SQLiteBDD(); 
		 * bigDatas =
		 * sqlite.methodeWitchFetcdataForTheBigWindow();
		 */
		return bigDatas;
	}

	// ***************** EXTERNAL CLASSES ***************** //

	/**
	 * Creation of a private and internal class to create a structure
	 * of data needed to save those fetched from the databse and to
	 * pass them into the PanelIcone (Widget of datas).
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version 0.1       
	 */
	private class DataForIcon 
	{
		ImageIcon logoWeather;
		JLabel temperature;
		JLabel windDirection;
		JLabel windSpeed;
		// ArrayList<DataForIcon> list = new ArrayList<DataForIcon>(); DO i need
		// this ?
		
		/**
		 * Constructor
		 */
		public DataForIcon() {}

		/**
		 * Display stuff for weather view
		 * @param logoWeather icon for weather
		 * @param temperature label for temperature
		 * @param windDirection label for wind direction
		 * @param windSpeed label for wind speed
		 */
		public DataForIcon(ImageIcon logoWeather, JLabel temperature, JLabel windDirection, JLabel windSpeed) 
		{
			this.logoWeather = logoWeather;
			this.temperature = temperature;
			this.windDirection = windDirection;
			this.windSpeed = windSpeed;
		}
	} // end to internal class DataForIcon

	/**
	 * Creation of a private and internal class to create a structure
	 * of data needed to save those fetched from the databse and to
	 * pass them into the PanelDetails (BigWindow of datas).
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version 0.1        
	 */
	private class DataForWindow 
	{
		// DECLARATION OF ALL THE VARIABLES NEEDED IN THE BIGWINDOW //
		JLabel runingDaysIcone;
		JLabel countRuningDays;
		JLabel sunnyDaysIcone;
		JLabel countSunnygDays;
		JLabel temperatureIcone1;
		JLabel temperatureIcone2;
		JLabel temperatureIcone3;
		JLabel temperatureIcone4;
		JLabel temperatureIcone5;
		JLabel temperatureIcone6;
		JLabel temperatureIcone7;
		JLabel temperature1;
		JLabel temperature2;
		JLabel temperature3;
		JLabel temperature4;
		JLabel temperature5;
		JLabel temperature6;
		JLabel temperature7;
		JLabel HotestDay;
		JLabel coldestDay;
		JLabel windDirection1;
		JLabel windSpeed1;
		JLabel windDirection2;
		JLabel windSpeed2;
		JLabel windDirection3;
		JLabel windSpeed3;
		JLabel windDirection4;
		JLabel windSpeed4;
		JLabel windDirection5;
		JLabel windSpeed5;
		JLabel windDirection;
		JLabel windSpeed6;
		JLabel windDirection7;
		JLabel windSpeed7;
		JLabel windIcone;
		JLabel maxTemperatureAverage;
		JLabel minTemperatureAverage;

		// ArrayList<DataForWindow> list = new ArrayList<DataForWindow>(); DO i
		// need
		// this ?
		
		/**
		 * Constructor
		 */
		public DataForWindow() {}

		/**
		 * Sweet sweet CONSTRUCTOR 
		 * @param runingDaysIcone
		 * @param countRuningDays
		 * @param sunnyDaysIcone
		 * @param countSunnygDays
		 * @param temperatureIcone1
		 * @param temperatureIcone2
		 * @param temperatureIcone3
		 * @param temperatureIcone4
		 * @param temperatureIcone5
		 * @param temperatureIcone6
		 * @param temperatureIcone7
		 * @param temperature1
		 * @param temperature2
		 * @param temperature3
		 * @param temperature4
		 * @param temperature5
		 * @param temperature6
		 * @param temperature7
		 * @param HotestDay
		 * @param coldestDay
		 * @param windDirection1
		 * @param windSpeed1
		 * @param windDirection2
		 * @param windSpeed2
		 * @param windDirection3
		 * @param windSpeed3
		 * @param windDirection4
		 * @param windSpeed4
		 * @param windDirection5
		 * @param windSpeed5
		 * @param windDirection
		 * @param windSpeed6
		 * @param windDirection7
		 * @param windSpeed7
		 * @param windIcone
		 * @param maxTemperatureAverage
		 * @param minTemperatureAverage
		 */
		public DataForWindow(JLabel runingDaysIcone, JLabel countRuningDays, JLabel sunnyDaysIcone,
				JLabel countSunnygDays, JLabel temperatureIcone1, JLabel temperatureIcone2, JLabel temperatureIcone3,
				JLabel temperatureIcone4, JLabel temperatureIcone5, JLabel temperatureIcone6, JLabel temperatureIcone7,
				JLabel temperature1, JLabel temperature2, JLabel temperature3, JLabel temperature4, JLabel temperature5,
				JLabel temperature6, JLabel temperature7, JLabel HotestDay, JLabel coldestDay, JLabel windDirection1,
				JLabel windSpeed1, JLabel windDirection2, JLabel windSpeed2, JLabel windDirection3, JLabel windSpeed3,
				JLabel windDirection4, JLabel windSpeed4, JLabel windDirection5, JLabel windSpeed5,
				JLabel windDirection, JLabel windSpeed6, JLabel windDirection7, JLabel windSpeed7, JLabel windIcone,
				JLabel maxTemperatureAverage, JLabel minTemperatureAverage) {
			this.runingDaysIcone = runingDaysIcone;
			this.countRuningDays = countRuningDays;
			this.sunnyDaysIcone = countRuningDays;
			this.countSunnygDays = countRuningDays;
			this.temperatureIcone1 = temperatureIcone1;
			this.temperatureIcone2 = temperatureIcone2;
			this.temperatureIcone3 = temperatureIcone3;
			this.temperatureIcone4 = temperatureIcone4;
			this.temperatureIcone5 = temperatureIcone5;
			this.temperatureIcone6 = temperatureIcone6;
			this.temperatureIcone7 = temperatureIcone7;
			this.temperature1 = temperature1;
			this.temperature2 = temperature2;
			this.temperature3 = temperature3;
			this.temperature4 = temperature4;
			this.temperature5 = temperature5;
			this.temperature6 = temperature6;
			this.temperature7 = temperature6;
			this.HotestDay = HotestDay;
			this.coldestDay = coldestDay;
			this.windDirection1 = windDirection1;
			this.windSpeed1 = windSpeed1;
			this.windDirection2 = windDirection2;
			this.windSpeed2 = windSpeed2;
			this.windDirection3 = windDirection3;
			this.windSpeed3 = windSpeed3;
			this.windDirection4 = windDirection4;
			this.windSpeed4 = windSpeed4;
			this.windDirection5 = windDirection5;
			this.windSpeed5 = windSpeed5;
			this.windDirection = windDirection;
			this.windSpeed6 = windSpeed6;
			this.windDirection7 = windDirection7;
			this.windSpeed7 = windSpeed7;
			this.windIcone = windIcone;
			this.maxTemperatureAverage = maxTemperatureAverage;
			this.minTemperatureAverage = minTemperatureAverage;
		}
	} // end of internal class DataForWindow


	/*public DatasForWindow updateMainWindow() {

		ShuttleDatas shuttledatas = new ShuttleDatas(); 
		  bigDatas = shuttledatas.fetchFreshData();

		return bigDatas;

	}*/


}