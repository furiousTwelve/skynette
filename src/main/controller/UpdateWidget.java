package main.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.presentation.panelIcone;

/**
 * @author AnaisGueyte
 * @date 21/09/2016
 * @version skynette 0.1
 * 
 *          This class aims to update the widget whenever the timer goes off and
 *          update the widget with fresh data fetched from SQLite database
 *
 */
public class UpdateWidget {

	panelIcone panIcon = new panelIcone();

	// CONSTRUCTOR //

	public UpdateWidget() {

	}

	/**
	 * @author AnaisGueyte
	 * @date 22/09/2016
	 * @version skynette 0.1
	 * 
	 *          Method to update the desktop icon every 30 min when the
	 *          countdown reaches 0. This method must be call in the MainWindow
	 *          whenever the countdown = 0.
	 *
	 */
	public void updateIcon() {

		// ************ FIRST ****************//
		// code to call database, select data such as "blob" image, int
		// temperature related to the current weather or last data inserted into
		// the mysql database

		// ************ SECOND ****************//
		// Those are the data from panelIcone that must be updated.

		/*
		 * ImageIcon meteo; 
		 * JLabel temp; 
		 * JLabel directionVent; 
		 * JLabel vitesseVent;
		 */

		// ************ THIRD ****************//
		// update the data into PanelIcone.
		
		//panIcon.setMeteo(/*new ImageIcon meteo*/);

		

	}

}
