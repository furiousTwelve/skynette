package main.controller;

import com.mysql.jdbc.Blob;

/**
 * @author AnaisGueyte
 * @date 22/09/2016
 * @version skynette 0.1
 * 
 *          Creation of a class to create a structure of data needed to save
 *          those fetched from the database and to pass them into the PanelIcone
 *          via UpdateIcon() method.
 */
public class DatasForIcon {

	public Blob logoWeather;
	public float temperature;
	public String windDirection;
	public float windSpeed;

	public DatasForIcon() {

	}

	public DatasForIcon(Blob logoWeather, float temperature, String windDirection, float windSpeed) {
		this.logoWeather = logoWeather;// methode imageConvert
										// convertit un blob
										// en ImageIcon
		this.temperature = temperature;
		this.windDirection = windDirection;
		this.windSpeed = windSpeed;
	}

}
