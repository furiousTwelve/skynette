package main.controller;

import java.sql.Date;
import java.time.LocalDateTime;

public class dataTransfer {

	private City[] sevenCityTab;
	private Records[] sevenRecordsTab;
	
	public dataTransfer() {
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
	}
	
	public dataTransfer askDataFromMySQLBDD (Date date, String nameCity) {
		dataTransfer askData = new dataTransfer();
		return askData;
	}
	
	public dataTransfer updateSQLite(Date date, String nameCity) {
		dataTransfer dataFromMysql = new dataTransfer();
		dataFromMysql.sevenCityTab = this.askDataFromMySQLBDD(date, nameCity).getSevenCityTab();
		dataFromMysql.sevenRecordsTab = this.askDataFromMySQLBDD(date, nameCity).getSevenRecordsTab();				
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
