package main.presentation;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
	// ATTRIBUTS DE LA CLASSE
		public int secondPassed = 0;
		public int minuteAff = 0;
		public int secondeAff = 0;
		String secondeAffS = "";
		panelIcone panicone = new panelIcone();
		
		
		//Constructeur pour mon héritage Stress
		public Countdown(int secondPassed)
		{
			this.secondPassed = secondPassed;
		}
		
		
	    Timer timer = new Timer();
	    public TimerTask tache = new TimerTask() 
	    {     
	        @Override
	        public void run() 
	        {
	        	if(secondPassed <= 0)
	        	{
	        		secondPassed = 10;
	        		panicone.setPreferredSize(new Dimension(200,200));
	        		
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
