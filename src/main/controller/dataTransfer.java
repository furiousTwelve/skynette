package main.controller;


import main.data.SQLite;

import java.awt.List;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
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

	private Records[] sevenRecordsTab;
	private ArrayList<Records> listRecords = new ArrayList<Records>();
	private String cityName = "";
	private String date;

	
	/**
	 * Constructor
	 */
	public dataTransfer() 
	{

		this.sevenRecordsTab = new Records[7];
		this.cityName = "Montpellier";

	}
	
	/**
	 * Constructor with two parameters
	 * @param date
	 * @param name
	 */
	public dataTransfer(String date, String name) {

		this.sevenRecordsTab = new Records[7];
		this.cityName = name;
		this.date = date;
		

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
		for (int i = 0; i < dataToReturn.listRecords.size(); i++) {
			System.out.println("Test " + i);
			float degreeeees = dataToReturn.getListRecords().get(i).getDeg();
//			dataToReturn.getSevenRecordsTab()[i].setWindDirection(Tools.convertDegreesToDirection(degreeeees));
			dataToReturn.getListRecords().get(i).setWindDirection(Tools.convertDegreesToDirection(degreeeees));
			System.out.println("Conversion degreeeeees en Direction : " + degreeeees + " -----> " + dataToReturn.getSevenRecordsTab()[i].getWindDirection() );
		}
		
		System.out.println("Test updateSQLite : Fin");
		
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
		
		SQLite SQLiteObject = new SQLite();
//		dataFromSQLite.setSevenRecordsTab(SQLiteObject.DataForWindow());
		dataFromSQLite.setListRecords(SQLiteObject.DataForWindow());
				
		return dataFromSQLite;
	}
	
	//========================
	// GETTERS AND SETTERS
	//========================
	
	/**
	 * Get the 7 records for each 7 days
	 * @return array of records
	 */
	public Records[] getSevenRecordsTab() 
	{
		return sevenRecordsTab;
	}
	
	/**
	 * Set the 7 records
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
	
	public ArrayList<Records> getListRecords() {
		return listRecords;
	}

	public void setListRecords(ArrayList<Records> listRecords) {
		this.listRecords = listRecords;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
		
}
