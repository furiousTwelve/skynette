package main.controller;

import java.sql.Date;
import java.time.LocalDateTime;

public class GestionBDD {

	private City[] sevenCityTab;
	private Records[] sevenRecordsTab;
	
	public GestionBDD() {
		sevenCityTab = new City[7];
		sevenRecordsTab = new Records[7];
	}
	
	public GestionBDD askDataFromMySQLBDD (Date date, String nameCity) {
		GestionBDD askData = new GestionBDD();
		return askData;
	}
	
	public void updateSQLite() {
		
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
