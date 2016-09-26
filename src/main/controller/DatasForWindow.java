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

	private ImageIcon runingDaysIcone;
	private float countRuningDays;
	private ImageIcon sunnyDaysIcone;
	private float countSunnygDays;
	private ImageIcon temperatureIcone1;
	private ImageIcon temperatureIcone2;
	private ImageIcon temperatureIcone3;
	private ImageIcon temperatureIcone4;
	private ImageIcon temperatureIcone5;
	private ImageIcon temperatureIcone6;
	private ImageIcon temperatureIcone7;
	private float temperature1;
	private float temperature2;
	private float temperature3;
	private float temperature4;
	private float temperature5;
	private float temperature6;
	private float temperature7;
	private float HotestDay;
	private float coldestDay;
	private String windDirection1;
	private float windSpeed1;
	private String windDirection2;
	private float windSpeed2;
	private String windDirection3;
	private float windSpeed3;
	private String windDirection4;
	private float windSpeed4;
	private String windDirection5;
	private float windSpeed5;
	private String windDirection6;
	private float windSpeed6;
	private String windDirection7;
	private float windSpeed7;
	private ImageIcon windIcone1;
	private ImageIcon windIcone2;
	private ImageIcon windIcone3;
	private ImageIcon windIcone4;
	private ImageIcon windIcone5;
	private ImageIcon windIcone6;
	private ImageIcon windIcone7;
	private float maxTemperatureAverage;
	private float minTemperatureAverage;
	
	

	// ******* SWEET SWEET CONSTRUCTOR ******* //

	public DatasForWindow(ImageIcon runingDaysIcone, float countRuningDays, ImageIcon sunnyDaysIcone,
			float countSunnygDays, ImageIcon temperatureIcone1, ImageIcon temperatureIcone2,
			ImageIcon temperatureIcone3, ImageIcon temperatureIcone4, ImageIcon temperatureIcone5,
			ImageIcon temperatureIcone6, ImageIcon temperatureIcone7, float temperature1, float temperature2,
			float temperature3, float temperature4, float temperature5, float temperature6, float temperature7,
			float HotestDay, float coldestDay, String windDirection1, float windSpeed1, String windDirection2,
			float windSpeed2, String windDirection3, float windSpeed3, String windDirection4, float windSpeed4,
			String windDirection5, float windSpeed5, String windDirection, float windSpeed6, String windDirection7,
			float windSpeed7, ImageIcon windIcone1, ImageIcon windIcone2, ImageIcon windIcone3, ImageIcon windIcone4, ImageIcon windIcone5
			, ImageIcon windIcone6, ImageIcon windIcone7, float maxTemperatureAverage, float minTemperatureAverage) {
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
		this.windDirection6 = windDirection6;
		this.windSpeed6 = windSpeed6;
		this.windDirection7 = windDirection7;
		this.windSpeed7 = windSpeed7;
		this.windIcone1 = windIcone1;
		this.windIcone2 = windIcone2;
		this.windIcone3 = windIcone3;
		this.windIcone4 = windIcone4;
		this.windIcone5 = windIcone5;
		this.windIcone6 = windIcone6;
		this.windIcone7 = windIcone7;
		this.maxTemperatureAverage = maxTemperatureAverage;
		this.minTemperatureAverage = minTemperatureAverage;
	}

	public DatasForWindow() {

	}
	
	
	
	// GETTERS & SETTERS
	

	public ImageIcon getRuningDaysIcone() {
		return runingDaysIcone;
	}

	public void setRuningDaysIcone(ImageIcon runingDaysIcone) {
		this.runingDaysIcone = runingDaysIcone;
	}

	public float getCountRuningDays() {
		return countRuningDays;
	}

	public void setCountRuningDays(float countRuningDays) {
		this.countRuningDays = countRuningDays;
	}

	public ImageIcon getSunnyDaysIcone() {
		return sunnyDaysIcone;
	}

	public void setSunnyDaysIcone(ImageIcon sunnyDaysIcone) {
		this.sunnyDaysIcone = sunnyDaysIcone;
	}

	public float getCountSunnygDays() {
		return countSunnygDays;
	}

	public void setCountSunnygDays(float countSunnygDays) {
		this.countSunnygDays = countSunnygDays;
	}

	public ImageIcon getTemperatureIcone1() {
		return temperatureIcone1;
	}

	public void setTemperatureIcone1(ImageIcon temperatureIcone1) {
		this.temperatureIcone1 = temperatureIcone1;
	}

	public ImageIcon getTemperatureIcone2() {
		return temperatureIcone2;
	}

	public void setTemperatureIcone2(ImageIcon temperatureIcone2) {
		this.temperatureIcone2 = temperatureIcone2;
	}

	public ImageIcon getTemperatureIcone3() {
		return temperatureIcone3;
	}

	public void setTemperatureIcone3(ImageIcon temperatureIcone3) {
		this.temperatureIcone3 = temperatureIcone3;
	}

	public ImageIcon getTemperatureIcone4() {
		return temperatureIcone4;
	}

	public void setTemperatureIcone4(ImageIcon temperatureIcone4) {
		this.temperatureIcone4 = temperatureIcone4;
	}

	public ImageIcon getTemperatureIcone5() {
		return temperatureIcone5;
	}

	public void setTemperatureIcone5(ImageIcon temperatureIcone5) {
		this.temperatureIcone5 = temperatureIcone5;
	}

	public ImageIcon getTemperatureIcone6() {
		return temperatureIcone6;
	}

	public void setTemperatureIcone6(ImageIcon temperatureIcone6) {
		this.temperatureIcone6 = temperatureIcone6;
	}

	public ImageIcon getTemperatureIcone7() {
		return temperatureIcone7;
	}

	public void setTemperatureIcone7(ImageIcon temperatureIcone7) {
		this.temperatureIcone7 = temperatureIcone7;
	}

	public float getTemperature1() {
		return temperature1;
	}

	public void setTemperature1(float temperature1) {
		this.temperature1 = temperature1;
	}

	public float getTemperature2() {
		return temperature2;
	}

	public void setTemperature2(float temperature2) {
		this.temperature2 = temperature2;
	}

	public float getTemperature3() {
		return temperature3;
	}

	public void setTemperature3(float temperature3) {
		this.temperature3 = temperature3;
	}

	public float getTemperature4() {
		return temperature4;
	}

	public void setTemperature4(float temperature4) {
		this.temperature4 = temperature4;
	}

	public float getTemperature5() {
		return temperature5;
	}

	public void setTemperature5(float temperature5) {
		this.temperature5 = temperature5;
	}

	public float getTemperature6() {
		return temperature6;
	}

	public void setTemperature6(float temperature6) {
		this.temperature6 = temperature6;
	}

	public float getTemperature7() {
		return temperature7;
	}

	public void setTemperature7(float temperature7) {
		this.temperature7 = temperature7;
	}

	public float getHotestDay() {
		return HotestDay;
	}

	public void setHotestDay(float hotestDay) {
		HotestDay = hotestDay;
	}

	public float getColdestDay() {
		return coldestDay;
	}

	public void setColdestDay(float coldestDay) {
		this.coldestDay = coldestDay;
	}

	public String getWindDirection1() {
		return windDirection1;
	}

	public void setWindDirection1(String windDirection1) {
		this.windDirection1 = windDirection1;
	}

	public float getWindSpeed1() {
		return windSpeed1;
	}

	public void setWindSpeed1(float windSpeed1) {
		this.windSpeed1 = windSpeed1;
	}

	public String getWindDirection2() {
		return windDirection2;
	}

	public void setWindDirection2(String windDirection2) {
		this.windDirection2 = windDirection2;
	}

	public float getWindSpeed2() {
		return windSpeed2;
	}

	public void setWindSpeed2(float windSpeed2) {
		this.windSpeed2 = windSpeed2;
	}

	public String getWindDirection3() {
		return windDirection3;
	}

	public void setWindDirection3(String windDirection3) {
		this.windDirection3 = windDirection3;
	}

	public float getWindSpeed3() {
		return windSpeed3;
	}

	public void setWindSpeed3(float windSpeed3) {
		this.windSpeed3 = windSpeed3;
	}

	public String getWindDirection4() {
		return windDirection4;
	}

	public void setWindDirection4(String windDirection4) {
		this.windDirection4 = windDirection4;
	}

	public float getWindSpeed4() {
		return windSpeed4;
	}

	public void setWindSpeed4(float windSpeed4) {
		this.windSpeed4 = windSpeed4;
	}

	public String getWindDirection5() {
		return windDirection5;
	}

	public void setWindDirection5(String windDirection5) {
		this.windDirection5 = windDirection5;
	}

	public float getWindSpeed5() {
		return windSpeed5;
	}

	public void setWindSpeed5(float windSpeed5) {
		this.windSpeed5 = windSpeed5;
	}

	public String getWindDirection6() {
		return windDirection6;
	}

	public void setWindDirection6(String windDirection) {
		this.windDirection6 = windDirection;
	}

	public float getWindSpeed6() {
		return windSpeed6;
	}

	public void setWindSpeed6(float windSpeed6) {
		this.windSpeed6 = windSpeed6;
	}

	public String getWindDirection7() {
		return windDirection7;
	}

	public void setWindDirection7(String windDirection7) {
		this.windDirection7 = windDirection7;
	}

	public float getWindSpeed7() {
		return windSpeed7;
	}

	public void setWindSpeed7(float windSpeed7) {
		this.windSpeed7 = windSpeed7;
	}

	public ImageIcon getWindIcone1() {
		return windIcone1;
	}

	public void setWindIcone1(ImageIcon windIcone) {
		this.windIcone1 = windIcone;
	}

	public float getMaxTemperatureAverage() {
		return maxTemperatureAverage;
	}

	public void setMaxTemperatureAverage(float maxTemperatureAverage) {
		this.maxTemperatureAverage = maxTemperatureAverage;
	}

	public float getMinTemperatureAverage() {
		return minTemperatureAverage;
	}

	public void setMinTemperatureAverage(float minTemperatureAverage) {
		this.minTemperatureAverage = minTemperatureAverage;
	}

	public ImageIcon getWindIcone2() {
		return windIcone2;
	}

	public void setWindIcone2(ImageIcon windIcone2) {
		this.windIcone2 = windIcone2;
	}

	public ImageIcon getWindIcone3() {
		return windIcone3;
	}

	public void setWindIcone3(ImageIcon windIcone3) {
		this.windIcone3 = windIcone3;
	}

	public ImageIcon getWindIcone4() {
		return windIcone4;
	}

	public void setWindIcone4(ImageIcon windIcone4) {
		this.windIcone4 = windIcone4;
	}

	public ImageIcon getWindIcone5() {
		return windIcone5;
	}

	public void setWindIcone5(ImageIcon windIcone5) {
		this.windIcone5 = windIcone5;
	}

	public ImageIcon getWindIcone6() {
		return windIcone6;
	}

	public void setWindIcone6(ImageIcon windIcone6) {
		this.windIcone6 = windIcone6;
	}

	public ImageIcon getWindIcone7() {
		return windIcone7;
	}

	public void setWindIcone7(ImageIcon windIcone7) {
		this.windIcone7 = windIcone7;
	}

	
}
