package main.controller;

import java.text.DateFormat;
/**
 * Allows us to make some transfer between the MySQL DBB and the SQLite's one
 * @author Mathieu
 *
 */
public class dataTransfer 
{
	private City[] sevenCityTab;               //Array of 7 days (tab) for a city
	private Records[] sevenRecordsTab;         //Array of 7 records (from a city)
	
	/**
	 * Constructor
	 */
	public dataTransfer() 
	{
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
	}
	
	/**
	 * Asking a data set from our MySQL database.
	 * @author Mathieu
	 * @param date date day 
	 * @param nameCity city's name
	 * @return dataTransfer get data
	 */
	public dataTransfer askDataFromMySQLBDD (DateFormat date, String nameCity) 
	{
		dataTransfer askData = new dataTransfer();
		return askData;
	}
	
	/**
	 * In order to update our SQLite BDD, asking data from our MySQL BDD and complete a dataTransfer Object with.
	 * 
	 * @author Mathieu
	 * @param date date day
	 * @param nameCity city's name
	 * @return
	 */
	public dataTransfer updateSQLite(DateFormat date, String nameCity) 
	{
		dataTransfer dataFromMysql = new dataTransfer();	
		dataFromMysql = this.askDataFromMySQLBDD(date, nameCity);
		System.out.println("Test DateFormat : on est le " + date.format(new java.util.Date())); //FIXME for test only
		return dataFromMysql;
	}

	/**
	 * Get the 7 days for a city
	 * @return array of 7 days
	 */
	public City[] getSevenCityTab() 
	{
		return sevenCityTab;
	}
	
	/**
	 * Set the 7 days of a city
	 * @param sevenCityTab array of 7 days
	 */

	public void setSevenCityTab(City[] sevenCityTab) 
	{
		this.sevenCityTab = sevenCityTab;
	}
	
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
