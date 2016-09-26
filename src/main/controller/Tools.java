package main.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.mysql.jdbc.Blob;

/**
 * Add tools to convert units, etc
 * 
 * @author Mathieu
 *
 */

public class Tools {
	
	/**
	 * Convert a degree (where the wind come from, ...) in a direction (N,S, E,
	 * W, NNW ...) Can be called without object instantiation
	 * 
	 * @author Mathieu
	 * @param degree
	 *            wind degree
	 * @return wind direction in string format
	 */
	
	public static String convertDegreesToDirection(float degree) {
		String direction = "";
		// degree should be between 0 and 360
		if ((degree < 0.0f) || (degree > 360.0f)) {

			if (degree <= 11.25f) {
				direction = "N";
			} else if (degree <= 33.75f) {
				direction = "NNE";
			} else if (degree <= 56.25f) {
				direction = "NE";
			} else if (degree <= 78.75f) {
				direction = "ENE";
			} else if (degree <= 101.25f) {
				direction = "E";
			} else if (degree <= 123.75f) {
				direction = "ESE";
			} else if (degree <= 146.25f) {
				direction = "SE";
			} else if (degree <= 168.75f) {
				direction = "SSE";
			} else if (degree <= 191.25f) {
				direction = "S";
			} else if (degree <= 213.75f) {
				direction = "SSW";
			} else if (degree <= 236.25f) {
				direction = "SW";
			} else if (degree <= 258.75f) {
				direction = "WSW";
			} else if (degree <= 281.25f) {
				direction = "W";
			} else if (degree <= 303.75f) {
				direction = "WNW";
			} else if (degree <= 326.25f) {
				direction = "NW";
			} else if (degree <= 348.75f) {
				direction = "NNW";
			} else {
				direction = "N";
			}
		}

		return direction;
	}

	/**
	 * Rounding date to the format who's needed for search into the MySQL_BDD
	 * 
	 * @author Mathieu
	 * @param Date
	 * @return String
	 */
	public static String arrondirDate(Date dateEtHeure) {

		// Format de date souhaité :
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));

		// Passage de notre paramètre Date en String
		String date = sdf.format(dateEtHeure);

		// Manip de notre String afin d'extraire la partie à modifier, et la
		// partie à garder intacte
		String hoursToConvert = date.substring(11, 13);
		String minToConvert = date.substring(14, 16);
		String dateToKeep = date.substring(0, 11);
		String dateToAdd = "";

		// On transforme HH:mm en quantité d'heures (décimal)
		float hours = (float) Integer.parseInt(hoursToConvert);
		float min = (float) Integer.parseInt(minToConvert);
		float minIntoPartofHour = min / 60;
		float newHour = hours + minIntoPartofHour;

		long dateEtHeure2 = 0;
		System.out.println("Contrôle Date avant transfo. : " + date);

		// Traitement de l'arrondi désiré
		if (newHour < 1.5) {
			dateToAdd = "00:00:00";
		} else if (newHour < 4.5) {
			dateToAdd = "03:00:00";
		} else if (newHour < 7.5) {
			dateToAdd = "06:00:00";
		} else if (newHour < 10.5) {
			dateToAdd = "09:00:00";
		} else if (newHour < 13.5) {
			dateToAdd = "12:00:00";
		} else if (newHour < 16.5) {
			dateToAdd = "15:00:00";
		} else if (newHour < 19.5) {
			dateToAdd = "18:00:00";
		} else if (newHour < 22.5) {
			dateToAdd = "21:00:00";
		} else {
			dateEtHeure2 = dateEtHeure.getTime() + (1000 * 60 * 60 * 24);
			dateToAdd = "00:00:00";
		}

		// Assemblage de la nouvelle date
		if (dateEtHeure2 != 0) {
			Date newDateEtHeure = new Date(dateEtHeure2);
			String newDate = sdf.format(newDateEtHeure);
			dateToKeep = newDate.substring(0, 11);
		}

		date = dateToKeep + dateToAdd;
		System.out.println("Contrôle Date après transfo. : " + date);

		return date;

	}

	/**
	 * Method that converts a blob into an ImageIcon. Needed to insert blob from
	 * Json file to the mysql database.
	 * Method created for the project Jobjob and reused here.
	 * 
	 * @author AnaisGueyte
	 * @author Florent Valladier
	 * @date 26/09/2016
	 *
	 */

	public static ImageIcon imageConvert(Blob imageDb) throws SQLException, IOException {
		System.out.println(imageDb);
		ImageIcon iconeImage = null;
		File fichierTemp = new File("c:/imgtemp.png");
		// File fichierTemp2 = new File();
		String str = "imgtemp";
		File fichierTemp2 = fichierTemp.createTempFile(str, "png", new File("c:/"));
		byte[] imgData = null;
		BufferedImage bImageFromConvert = null;
		if (imageDb != null) {
			System.out.println("salut 2");
			imgData = imageDb.getBytes(1, (int) imageDb.length());
			InputStream in = new ByteArrayInputStream(imgData);
			try {
				System.out.println("salut 3");
				bImageFromConvert = ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "png", fichierTemp2);
				iconeImage = new ImageIcon(fichierTemp2.getPath());

			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else {
			System.out.println("salut 4");
			iconeImage = new ImageIcon("JobJob.png");
		}

		boolean effacer = fichierTemp2.delete();
		System.out.println(effacer);
		return iconeImage;

	}
}
