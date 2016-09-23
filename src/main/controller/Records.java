package main.controller;
/**
 * This is the class who's got the main weather-records:
 * 	- temperature
 * 	- pressure ...
 * @author Mathieu
 */
public class Records {

	public float temp; //temperature, Kelvin
	public float pressure; //atmospheric pressure at sea level, hPa
	public int humidity; //humidity, %
	public float speed; //wind speed, m/s
	public float deg; // wind direction, degrees
	public float rain; //rain volume for the least 3 hours
	public int clouds; //cloudiness %
	public int snow; //snow volume for the least 3 hour
	public String weatherDescription; // Weather condition
	
	public void records() {
		
	}

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
	
}
