package main.controller;

import java.sql.Date;
import java.time.LocalDateTime;
/**
 * Allows us to make some transfer between the MySQL DBB and the SQLite's one
 * @author Mathieu
 *
 */
public class dataTransfer {

	private City[] sevenCityTab;
	private Records[] sevenRecordsTab;
	
	public dataTransfer() {
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
	}
	
	/**
	 * Asking a data set from our MySQL database.
	 * 
	 * @author Mathieu
	 * @param date
	 * @param nameCity
	 * @return dataTransfer
	 */
	public dataTransfer askDataFromMySQLBDD (Date date, String nameCity) {
		dataTransfer askData = new dataTransfer();
		return askData;
	}
	
	/**
	 * In order to update our SQLite BDD, asking data from our MySQL BDD and complete a dataTransfer Object with.
	 * 
	 * @author Mathieu
	 * @param date
	 * @param nameCity
	 * @return
	 */
	public dataTransfer updateSQLite(Date date, String nameCity) {
		dataTransfer dataFromMysql = new dataTransfer();	
		dataFromMysql = this.askDataFromMySQLBDD(date, nameCity);
		return dataFromMysql;
	}

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
