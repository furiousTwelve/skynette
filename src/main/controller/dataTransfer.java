package main.controller;


import main.data.SQLite;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

import main.controller.Tools;
import main.data.mySQL;



/**
 * Allows us to make some transfer between the MySQL DBB and the SQLite's one
 * @author Mathieu
 */
public class dataTransfer {

	//===============
	// ATTRIBUTES & CONSTRUCTOR(S)
	//===============

	public Records[] sevenRecordsTab;
	private String cityName = "";
	private String date;

	
	/**
	 * Constructor
	 */
	public dataTransfer() 
	{

		this.sevenRecordsTab = new Records[7];

	}
	
	/**
	 * Constructor with two parameters
	 * @author Mathieu
	 * @param date
	 * @param name
	 */
	public dataTransfer(String date, String name) {
		sevenRecordsTab = new Records[7];


		
		//just for testing with false values but doesn't seems to work !
		sevenRecordsTab[0].setTemp(30);
		sevenRecordsTab[0].setPressure(20);
		sevenRecordsTab[0].setSpeed(20);
		sevenRecordsTab[0].setDeg(40);
		sevenRecordsTab[0].setRain(50);
		sevenRecordsTab[0].setClouds(60);
		sevenRecordsTab[0].setSnow(40);
		sevenRecordsTab[0].setWeatherDescription("fort");
		
		this.cityName = name;
		this.date = date;
		
		SQLite BDDSQLite = new SQLite();
		BDDSQLite.insertDataFromMySQL(this.cityName, sevenRecordsTab);
		//SQLite laBDDlegere = new SQLite();
		//laBDDlegere.insertDataFromMySQL(sevenCityTab, sevenRecordsTab);
	}
	
	public void dataTransfer()
	{
		SQLite BDDSQLite = new SQLite();
		BDDSQLite.insertDataFromMySQL(cityName, sevenRecordsTab);
	}

	
	
	//===============
	// METHODS
	//===============

	/**
	 * In order to update our SQLite BDD, we ask data from our MySQL BDD.
	 * Giving two String, a date and a city's name, this methods gives us a dataTransfert-Object who's got all the temperature and pression data 
	 * @author Mathieu
	 * @param date
	 * @param nameCity
	 * @return dataTransfer
	 */
	public dataTransfer updateSQLite(String date, String nameCity) {
		dataTransfer dataToSend = new dataTransfer(date, nameCity);
		dataTransfer dataToReturn = new dataTransfer();
		
		System.out.println("Test lancement updateSQLite : on est le " + date);

		mySQL BigDatabase = new mySQL();
		BigDatabase.Connexion();
		dataToReturn = BigDatabase.RecordsGenerate(dataToSend); //retourne un dataTransfer remplit
		
//		Convert wind-degrees in wind-direction, using a static method from Tools
		for (int i = 0; i < dataToReturn.sevenRecordsTab.length; i++) {
			float degreeeees = sevenRecordsTab[i].getDeg();
			String direct = sevenRecordsTab[i].getWindDirection();
			direct = Tools.convertDegreesToDirection(degreeeees);
			sevenRecordsTab[i].setWindDirection(direct);
		}

		
		return dataToReturn;
	}

	/**
	 * That's the method who's ask SQLite DBB for data, in order to dispatch them, after, in the presentation layer
	 * @author Mathieu
	 * @return dataTransfer
	 * @param void
	 */
	public dataTransfer dataFromSQLite() {
		dataTransfer dataFromSQLite = new dataTransfer();
		
//		dataFromSQLite = ********.methoderemplissageDepuisSQLite();
		
		return dataFromSQLite;
	}
	
	//========================
	// GETTERS AND SETTERS
	//========================
	
	/**
	 * Get the 7 records for each 7 days
	 * @author Mathieu
	 * @return array of records
	 */
	public Records[] getSevenRecordsTab() 
	{
		return sevenRecordsTab;
	}
	
	/**
	 * Set the 7 records
	 * @author Mathieu
	 * @param sevenRecordsTab
	 */
	public void setSevenRecordsTab(Records[] sevenRecordsTab) 
	{
		this.sevenRecordsTab = sevenRecordsTab;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
		
}
