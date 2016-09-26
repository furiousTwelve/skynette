package main.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import main.controller.DatasForIcon;

/**
 * This claims aims to pass fresh datas from SQLite database to the controller
 * methods updateIcon() and update the datas in the widget.
 * 
 * @author AnaisGueyte
 * @date 22/09/2016
 * @version Skynette 0.1
 * 
 *
 */

public class ShuttleDatas {

	DatasForIcon datas = new DatasForIcon();

	// ******* CONSTRUCTOR ******* //

	public ShuttleDatas() {

	}

	// ******* METHOD ******* //

	/**
	 * 
	 * This method connects to the SQLite database to fetch 4 datas
	 * 
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version Skynette 0.1
	 * 
	 * 
	 *
	 */

	public DatasForIcon fetchFreshData() throws SQLException {
		SQLite lighterBDD = new SQLite();
		lighterBDD.Connexion();

		String sql = "SELECT iconeTemps, temperature, windDirection, windSpeed FROM Preview";

		ResultSet res = lighterBDD.stmt.executeQuery(sql);

		while (res.next()) {
			datas.logoWeather = res.getBlob(1);
			datas.temperature = res.getFloat(2);
			datas.windDirection = res.getString(3);
			datas.windSpeed = res.getFloat(4);
		}
		return datas;

	}

}
