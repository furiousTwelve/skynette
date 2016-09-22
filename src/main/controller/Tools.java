package main.controller;

/**
 * Add tools to convert units, etc
 * @author Mathieu
 *
 */
public class Tools 
{
	/**
	 * Convert a degree (where the wind come from, ...) in a direction (N,S, E, W, NNW ...)
	 * Can be called without object instantiation
	 * @author Mathieu
	 * @param degree wind degree
	 * @return wind direction in string format
	 */
	public static String convertDegreesToDirection(float degree) 
	{
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
	
	public static String arrondirDate(String date) {
		String hourToChange = date.substring(11, 13);;
		String hourToKeep1 = date.substring(0, 11);
		
		String newDate = "";
		
		int  heures = Integer.parseInt(hourToChange);
		if (heures < 3) {
			hourToChange = "00:00:00";
		} else if(heures < 6) {
			hourToChange = "03:00:00";
		} else if(heures < 9) {
			hourToChange = "06:00:00";
		} else if(heures < 12) {
			hourToChange = "09:00:00";
		} else if(heures < 15) {
			hourToChange = "12:00:00";
		} else if(heures < 18) {
			hourToChange = "15:00:00";
		} else if(heures < 21) {
			hourToChange = "18:00:00";
		} else  {
			hourToChange = "21:00:00";
		}
		
		newDate = hourToKeep1 + hourToChange;
		
		return newDate;
	}
	
}

