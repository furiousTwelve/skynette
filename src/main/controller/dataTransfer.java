package main.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDateTime;
/**
 * Allows us to make some transfer between the MySQL DBB and the SQLite's one
 * @author Mathieu
 *
 */
public class dataTransfer {

	//===============
	// ATTRIBUTES & CONSTRUCTOR(S)
	//===============
	private City[] sevenCityTab;
	private Records[] sevenRecordsTab;
	private String cityName = "";
	private DateFormat date;
	
	public dataTransfer() {
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
	}
	
	public dataTransfer(DateFormat date, String name) {
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
		this.cityName = name;
		this.date = date;
	}
	
	
	//===============
	// METHODS
	//===============

	/**
	 * In order to update our SQLite BDD, we ask data from our MySQL BDD.
	 * 
	 * @author Mathieu
	 * @param date
	 * @param nameCity
	 * @return dataTransfer
	 */
	public dataTransfer updateSQLite(DateFormat date, String nameCity) {
		dataTransfer dataToSend = new dataTransfer();
		dataTransfer dataToReturn = new dataTransfer();
		
		System.out.println("Test lancement updateSQLite : on est le " + date.format(new java.util.Date()));
		dataToReturn = methoderecupDonneesByALBAN(date, nameCity); //retourne un dataTransfer remplit
		
		//Convert wind-degrees in wind-direction
		for (int i = 0; i < dataToReturn.sevenRecordsTab.length; i++) {
			float degreeeees = sevenRecordsTab[i].getDeg();
			String direct = sevenRecordsTab[i].getWindDirection();
			direct = this.convertDegreesToDirection(degreeeees);
			sevenRecordsTab[i].setWindDirection(direct);
		}
		
		return dataToReturn;
	}

	
	
	//========================
	// GETTERS AND SETTERS
	//========================
	public City[] getSevenCityTab() {
		return sevenCityTab;
	}
	public void setSevenCityTab(City[] sevenCityTab) {
		this.sevenCityTab = sevenCityTab;
	}
	public Records[] getSevenRecordsTab() {
		return sevenRecordsTab;
	}
	public void setSevenRecordsTab(Records[] sevenRecordsTab) {
		this.sevenRecordsTab = sevenRecordsTab;
	}
		
}
