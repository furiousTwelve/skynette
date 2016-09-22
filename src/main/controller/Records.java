package main.controller;
/**
 * This is the class which's got the main weather-records:
 * 	- temperature
 * 	- pressure ...
 * @author Mathieu
 */

public class Records {

	private float temp; //temperature, Kelvin
	private float pressure; //atmospheric pressure at sea level, hPa
	private int humidity; //humidity, %
	private float speed; //wind speed, m/s
	private float deg; // wind direction, degrees
	private float rain; //rain volume for the least 3 hours
	private int clouds; //cloudiness %
	private int snow; //snow volume for the least 3 hour
	private String weatherDescription; // Weather condition
	private String windDirection = "";	
	
	/**
	 * Constructor
	 */
	public Records() {}
}
