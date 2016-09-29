package main.controller;

import java.sql.Blob;
import java.sql.Date;

/**
 * 
 * 
 * /** This is the class which's got the main weather-records: <br>
 * - temperature <br>
 * - pressure ... 
 * @author Mathieu
 */

public class Records {

	private Date dateDay;

	private float temp; // temperature, Kelvin
	private float pressure; // atmospheric pressure at sea level, hPa
	private float speed; // wind speed, m/s
	private float deg; // wind direction, degrees
	private float rain; // rain volume for the least 3 hours
	private int clouds; // cloudiness %
	private int snow; // snow volume for the least 3 hour
	private String weatherDescription; // Weather condition
	private int humidity;
	private String windDirection = "";
	private Blob logoWeather;
	private Blob logoWind = null;

	/**
	 * Constructor
	 * @author Mathieu
	 */
	public Records() {
		this.temp = 0;
		this.pressure = 0;
		this.speed = 0;
		this.deg = 0;
		this.rain = 0;
		this.clouds = 0;
		this.snow = 0;
		this.weatherDescription = "";
		this.humidity = 0;
	}

	// ========================
	// GETTERS AND SETTERS
	// ========================

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

	public Blob getLogoWeather() {
		return logoWeather;
	}

	public void setLogoWeather(Blob logoWeather) {
		this.logoWeather = logoWeather;
	}

	public Date getDateDay() {
		return dateDay;
	}

	public void setDateDay(Date dateDay) {
		this.dateDay = dateDay;
	}

	public Blob getLogoWind() {
		return logoWind;
	}

	public void setLogoWind(Blob logoWind) {
		this.logoWind = logoWind;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

}
