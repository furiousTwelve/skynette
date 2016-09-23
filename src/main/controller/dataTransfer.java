package main.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

import main.controller.Tools;


/**
 * Allows us to make some transfer between the MySQL DBB and the SQLite's one
 * @author Mathieu
 *
 */
public class dataTransfer {

	//===============
	// ATTRIBUTES & CONSTRUCTOR(S)
	//===============

	private Records[] sevenRecordsTab;
	private String cityName = "";
	private String date;

	
	/**
	 * Constructor
	 */
	public dataTransfer() 
	{
		sevenRecordsTab = new Records[7];
	}
	
	public dataTransfer(String date, String name) {
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
	public dataTransfer updateSQLite(String date, String nameCity) {
		dataTransfer dataToSend = new dataTransfer(date, nameCity);
		dataTransfer dataToReturn = new dataTransfer();
		
		System.out.println("Test lancement updateSQLite : on est le " + date);

//		dataToReturn = recordsGenerate(dataToSend); //retourne un dataTransfer remplit
//		
////		Convert wind-degrees in wind-direction, using a static method from Tools
//		for (int i = 0; i < dataToReturn.sevenRecordsTab.length; i++) {
//			float degreeeees = sevenRecordsTab[i].getDeg();
//			String direct = sevenRecordsTab[i].getWindDirection();
//			direct = Tools.convertDegreesToDirection(degreeeees);
//			sevenRecordsTab[i].setWindDirection(direct);
//		}
		
		return dataToReturn;
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
		
}
