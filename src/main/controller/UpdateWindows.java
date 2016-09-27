package main.controller;

import java.sql.SQLException;
import main.data.ShuttleDatas;

/**
 * This class aims to update the widget whenever the timer goes off and big
 * Window with fresh data fetched from SQLite database This class aims to update
 * the widget whenever the timer goes off and big Window with fresh data fetched
 * from SQLite database
 * 
 * @author AnaisGueyte
 * @date 21/09/2016
 * @version 0.1
 */
public class UpdateWindows {

	// ******* VARIABLES ******* //

	DatasForIcon datas = new DatasForIcon();


	// ******* METHOD ******* //

	/**
	 * Method to update the desktop icon every 30 min when the countdown reaches
	 * 0. This method must be called in the MainWindow whenever the countdown =
	 * 0. First we call on the SQLiteBDD method to fetch the data needed. Add
	 * them into an object of type DataForIcon (internal class declared below)
	 * and return that variable for the update of panelIcone
	 * 
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version 0.1
	 * @return Object type DataForIcon named "datas"
	 * @throws SQLException
	 */

	public DatasForIcon updateIcon() throws SQLException {

		ShuttleDatas shuttledatas = new ShuttleDatas();
		datas = shuttledatas.fetchFreshData();


		return datas;
	}

}