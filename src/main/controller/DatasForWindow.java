package main.controller;

import javax.swing.ImageIcon;

/**
 * @author AnaisGueyte
 * @date 22/09/2016
 * @version Skynette 0.1
 * 
 *          Creation of a class to structure datas needed to save those fetched
 *          from the database and to pass them into the PanelDetails (BigWindow
 *          of datas) via UpdateMainWindow() method.
 */

public class DatasForWindow {

	// DECLARATION OF ALL THE VARIABLES NEEDED IN THE BIGWINDOW //

	ImageIcon runingDaysIcone;
	float countRuningDays;
	ImageIcon sunnyDaysIcone;
	float countSunnygDays;
	ImageIcon temperatureIcone1;
	ImageIcon temperatureIcone2;
	ImageIcon temperatureIcone3;
	ImageIcon temperatureIcone4;
	ImageIcon temperatureIcone5;
	ImageIcon temperatureIcone6;
	ImageIcon temperatureIcone7;
	float temperature1;
	float temperature2;
	float temperature3;
	float temperature4;
	float temperature5;
	float temperature6;
	float temperature7;
	float HotestDay;
	float coldestDay;
	String windDirection1;
	float windSpeed1;
	String windDirection2;
	float windSpeed2;
	String windDirection3;
	float windSpeed3;
	String windDirection4;
	float windSpeed4;
	String windDirection5;
	float windSpeed5;
	String windDirection;
	float windSpeed6;
	String windDirection7;
	float windSpeed7;
	ImageIcon windIcone;
	float maxTemperatureAverage;
	float minTemperatureAverage;

	// ******* SWEET SWEET CONSTRUCTOR ******* //

	public DatasForWindow(ImageIcon runingDaysIcone, float countRuningDays, ImageIcon sunnyDaysIcone,
			float countSunnygDays, ImageIcon temperatureIcone1, ImageIcon temperatureIcone2,
			ImageIcon temperatureIcone3, ImageIcon temperatureIcone4, ImageIcon temperatureIcone5,
			ImageIcon temperatureIcone6, ImageIcon temperatureIcone7, float temperature1, float temperature2,
			float temperature3, float temperature4, float temperature5, float temperature6, float temperature7,
			float HotestDay, float coldestDay, String windDirection1, float windSpeed1, String windDirection2,
			float windSpeed2, String windDirection3, float windSpeed3, String windDirection4, float windSpeed4,
			String windDirection5, float windSpeed5, String windDirection, float windSpeed6, String windDirection7,
			float windSpeed7, ImageIcon windIcone, float maxTemperatureAverage, float minTemperatureAverage) {
		this.runingDaysIcone = runingDaysIcone;
		this.countRuningDays = countRuningDays;
		this.sunnyDaysIcone = sunnyDaysIcone;
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

	public DatasForWindow() {

	}

}
