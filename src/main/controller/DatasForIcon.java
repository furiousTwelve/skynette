package main.controller;

import java.sql.Blob;

/**
 * Creation of a class to create a structure of data needed to save those
 * fetched from the database and to pass them into the PanelIcone via
 * UpdateIcon() method.
 * 
 * @author AnaisGueyte
 * @date 22/09/2016
 * @version skynette 0.1
 * 
 * 
 */
public class DatasForIcon {

	public Blob logoWeather;
	public float temperature;
	public String windDirection;
	public float windSpeed;

	public DatasForIcon() {

	}

	public DatasForIcon(Blob logoWeather, float temperature, String windDirection, float windSpeed) {
		this.logoWeather = logoWeather;
		this.temperature = temperature;
		this.windDirection = windDirection;
		this.windSpeed = windSpeed;
	}

}
