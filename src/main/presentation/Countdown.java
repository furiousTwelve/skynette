package main.presentation;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import main.controller.Tools;

import main.controller.dataTransfer;

/**
 * Class to countdown and call a service each time the countdown is finished
 * @author Damien
 */
public class Countdown 
{
	/* ******************** VARIABLES *************************** */
	public int secondPassed = 0;
	public int secondTotal;
	public int minuteAff = 0;
	public int secondeAff = 0;
	String secondeAffS = "";
	PanelIcon panicone = new PanelIcon();
	Timer timer;
	/**
	 * Constructor
	 * @param secondPassed
	 */
	public Countdown(int secondPassed)
	{
		timer = new Timer();
		this.secondPassed = secondPassed;
		this.secondTotal = secondPassed;
	}

    /**
     * Method to start the timer countdown
     */
    public void start()
    {  		
    	timer.scheduleAtFixedRate(tache, 1000, 1000);
    }    
    /**
     * Display timer task
     * @param sec
     * @return string of remaining time
     */
    public String displayRemainingTime(int sec)
    {
		String remainingTime = "";
    	secondeAff = (sec%60);
		minuteAff = (sec - secondeAff)/60;
		if(secondeAff < 10)
		{
			secondeAffS = "0" + secondeAff;
			remainingTime = minuteAff + ":" + secondeAffS;
			System.out.println(minuteAff + ":" + secondeAffS);
		}
		return remainingTime;
    }
    
	    public TimerTask tache = new TimerTask() 
	    {     
	    	/**
	    	 * Decrements the seconds left in our Countdown.
	    	 * When countdown finished, some other methods are launched, as .updateSQLite.
	    	 * @author Damien
	    	 * @authotr Mathieu
	    	 */
	        @Override
	        public void run() 
	        {
	        	if(secondPassed <= 0)
	        	{
	        		secondPassed = secondTotal;
	        		panicone.setPreferredSize(new Dimension(200,200));

	        		dataTransfer dataTransfer = new dataTransfer();
	        		
	        		//Création de la date et de l'heure du moment
//	        		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        		Date today = Calendar.getInstance().getTime();       
//	        		String reportDate = df.format(today);
//	        		System.out.println("Report Date: " + reportDate);
	        		Date date = new Date();
	        		String reportDate ="";
	        		
	        		//On la convertit en heure arrondie pour la BDD
	        		reportDate = Tools.arrondirDate(date);
	        		System.out.println("Report new Date :" + reportDate);
	        		
	        		dataTransfer.updateSQLite(reportDate, "Montpellier");
	        	}
	        	else
	        	{
	        		secondPassed--;
	        		displayRemainingTime(secondPassed);
	        	}
	        }
	    };
	    
	    
	  
	   
}

