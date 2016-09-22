package main.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author AnaisGueyte
 * @date 21/09/2016
 * @version skynette 0.1
 * 
 *          This class aims to update the widget whenever the timer goes off and
 *          big Window with fresh data fetched from SQLite database
 *
 */
public class UpdateWindows {

	// VARIABLES //

	DataForIcon datas = new DataForIcon();
	DataForWindow bigDatas = new DataForWindow();

	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version skynette 0.1
	 * 
	 *          Method to update the desktop icon every 30 min when the
	 *          countdown reaches 0. This method must be called in the
	 *          MainWindow whenever the countdown = 0. First we call on the
	 *          SQLiteBDD method to fetch the data needed. Add them into an
	 *          object of type DataForIcon (internal class declared below) and
	 *          return that variable for the update of panelIcone
	 * 
	 * @return Object type DataForIcon named "datas"
	 */

	public DataForIcon updateIcon() {

		// >> Appel de la methode base de donnée pour recuper les données
		// >> Mettre a jour le nom de la classe bdd et la methode.

		/*
		 * 
		 * SQLiteBDD sqlitebdd = new SQLiteBDD(); datas =
		 * sqlite.methodeWitchFetcdata();
		 */

		return datas;

	}

	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version skynette 0.1
	 * 
	 *          Method to refresh datas of the main window when its open via the
	 *          widget. This methode must be called with the listener in the
	 *          PanelIcone class. First we call on the SQLiteBDD method to fetch
	 *          the data needed. Add them into an object of type DataForWindow
	 *          (internal class declared below) and return that variable for the
	 *          update of panelDetails.
	 * 
	 * @return Object type DataForWindow named "bigDatas"
	 */

	public DataForWindow updateMainWindow() {

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
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version skynette 0.1
	 * 
	 *          Creation of a private and internal class to create a structure
	 *          of data needed to save those fetched from the databse and to
	 *          pass them into the PanelIcone (Widget of datas).
	 */

	private class DataForIcon {

		ImageIcon logoWeather;
		JLabel temperature;
		JLabel windDirection;
		JLabel windSpeed;
		// ArrayList<DataForIcon> list = new ArrayList<DataForIcon>(); DO i need
		// this ?

		public DataForIcon(ImageIcon logoWeather, JLabel temperature, JLabel windDirection, JLabel windSpeed) {
			this.logoWeather = logoWeather;
			this.temperature = temperature;
			this.windDirection = windDirection;
			this.windSpeed = windSpeed;
		}

		public DataForIcon() {

		}

	}

	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version skynette 0.1
	 * 
	 *          Creation of a private and internal class to create a structure
	 *          of data needed to save those fetched from the databse and to
	 *          pass them into the PanelDetails (BigWindow of datas).
	 */

	private class DataForWindow {

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

		// Sweet sweet CONSTRUCTOR //

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

		public DataForWindow() {

		}

	}

}