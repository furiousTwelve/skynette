package main.controller;
/**
 * This is the class which's got the main weather-records:
 * 	- temperature
 * 	- pressure ...
 * @author Mathieu
 */

public class Records {


	public float temp; //temperature, Kelvin
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
	public Records() {
		
	}

	
	//========================
	//GETTERS AND SETTERS
	//========================

	public float getTemp() {
		return temp;
	}


	public void setTemp(float temp) {
		this.temp = temp;
	}


	public float getPressure() {
		return pressure;
	}


	public void setPressure(float pressure) {
		this.pressure = pressure;
	}


	public int getHumidity() {
		return humidity;
	}


	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public float getDeg() {
		return deg;
	}


	public void setDeg(float deg) {
		this.deg = deg;
	}


	public float getRain() {
		return rain;
	}


	public void setRain(float rain) {
		this.rain = rain;
	}


	public int getClouds() {
		return clouds;
	}


	public void setClouds(int clouds) {
		this.clouds = clouds;
	}


	public int getSnow() {
		return snow;
	}


	public void setSnow(int snow) {
		this.snow = snow;
	}


	public String getWeatherDescription() {
		return weatherDescription;
	}


	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}


	public String getWindDirection() {
		return windDirection;
	}


	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	

}
