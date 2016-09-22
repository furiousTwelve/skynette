package main.presentation;

import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Timer;
import java.util.TimerTask;

import main.controller.dataTransfer;

public class Countdown {
	// ATTRIBUTS DE LA CLASSE
		public int secondPassed = 0;
		public int secondTotal;
		public int minuteAff = 0;
		public int secondeAff = 0;
		String secondeAffS = "";
		PanelIcon panicone = new PanelIcon();
		
		
		//Constructeur pour mon héritage Stress
		public Countdown(int secondPassed)
		{
			this.secondPassed = secondPassed;
			this.secondTotal = secondPassed;
		}
		
		
	    Timer timer = new Timer();
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
	        		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
	        		dataTransfer.updateSQLite(shortDateFormat, "Montpellier");
	        	}
	        	else
	        	{
	        		secondPassed--;
	        		affichage(secondPassed);
	        	}
	        }
	    };
	    // DELAI TIMER
	    public void start()
	    {
	    	timer.scheduleAtFixedRate(tache, 1000, 1000);
	    }
	    
	    // CONVERTIR LE TIMER : SECONDES => MINUTES/SECONDES
	    public String affichage(int sec)
	    {
			String res = "";
	    	secondeAff = (sec%60);
			minuteAff = (sec - secondeAff)/60;
			if(secondeAff < 10)
			{
				secondeAffS = "0" + secondeAff;
				res = minuteAff + ":" + secondeAffS;
				System.out.println(minuteAff + ":" + secondeAffS);
			}
			else
			{
				res = minuteAff + ":" + secondeAff;
	        	System.out.println(minuteAff + ":" + secondeAff);
			}
			return res;
	    }
}
