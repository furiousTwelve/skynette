package main.presentation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import java.awt.Image;
import java.awt.Toolkit;
import main.data.SQLite;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mysql.jdbc.Blob;

import main.controller.DatasForIcon;
import main.controller.Tools;
import main.controller.UpdateWindows;
import main.controller.dataTransfer;
import main.data.mySQL;




/**
 * Sets the main window of the application that will manage the interaction of the panels
 * @author Khadidja
 * @author Audric

 */

public class FenetrePrincipale extends JFrame implements MouseListener 
{
	/* *************************** VARIABLES ********************** */
	private PanelIcon icon = new PanelIcon();
	private PanelDetails fenetre = new PanelDetails();
	private Countdown count = new Countdown(8);
	DatasForIcon datas = new DatasForIcon();
	Color backcolor = new Color(1f, 0f, 0f, 0f);
	UpdateWindows updatewindows;
	// Pour le 2e timer (actualisation icone)
	public int secondPassed=6;
	public int secondTotal=secondPassed;
	
	// A effacer
	public int minuteAff = 0;
	public int secondeAff = 0;
	String secondeAffS = "";
	
	/**
	 *  constructor which defines size elements and start countdown
	 */

	
	public  FenetrePrincipale()
	{
		this.setSize(new Dimension(150, 300));
		int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		this.setLocation(x-150, y-300);
    	this.setUndecorated(true);
        this.getAccessibleContext();

        this.setIconImage(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
        this.setTitle("Skynette"); 
        icon.addMouseListener(this);
        this.setContentPane(icon);
        this.setVisible(true);
        setOpacity(0.95f);
        this.setBackground(backcolor);
        
        count.start();
     // Timer actualisation icone
     	Timer timerIcon = new Timer();
     	timerIcon.scheduleAtFixedRate(tache, 1000, 1000);
	}
	 
	/**
	 * Main part
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, IOException {


		FenetrePrincipale fenetre = new FenetrePrincipale();
		SQLite database = new SQLite();
		database.verifyDB();
		// Pour test Cyril
		mySQL BigDatabase = new mySQL();
		BigDatabase.Connexion();
		
		
		

	}


	public static ImageIcon imageConvert(Blob imageDb) throws SQLException, IOException
	{
		System.out.println(imageDb);
		ImageIcon iconeImage = null;
		File fichierTemp = new File("c:/imgtemp.png");
//		File fichierTemp2 = new File();
		String str = "imgtemp";
		File fichierTemp2 = fichierTemp.createTempFile(str, "png", new File("c:/"));
		byte[] imgData = null ;
		BufferedImage bImageFromConvert = null; 
		if(imageDb != null){
			System.out.println("salut 2");
			imgData = imageDb.getBytes(1,(int)imageDb.length());
			InputStream in = new ByteArrayInputStream(imgData);
			try {
				System.out.println("salut 3");
				bImageFromConvert = ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "png", fichierTemp2);
				iconeImage= new ImageIcon(fichierTemp2.getPath());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("salut 4");
			iconeImage =  new ImageIcon("JobJob.png");
		}
		
		boolean effacer = fichierTemp2.delete();
		System.out.println(effacer);
		return iconeImage;


	}

	@Override
	/**
	 * Event which detects mouse clicked and launch the big window OR come back to icon window
	 * 
	 */
	public void mouseClicked(MouseEvent e) 
	{
		// the state is : I am a small icon and I want to be bigger to display all my stuff
		if(e.getSource() == this.icon)
		{
			fenetre = new PanelDetails();
			this.getContentPane().removeAll();
			//Define size window based on user's screen size
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
			this.setSize(screenSize);
			this.setLocationRelativeTo(null);
			fenetre.addMouseListener(this);
			this.setContentPane(fenetre);
			this.validate();
		}
		
		// the state is : I aM big window and I want to be small to display only an icon
		if(e.getSource() == this.fenetre)
		{
			icon = new PanelIcon();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
			icon.addMouseListener(this);
			this.setContentPane(icon);
			this.validate();
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	 public TimerTask tache = new TimerTask() 
	    {     
	    	/**
	    	 * Decrements the seconds left in second Countdown for icon update.
	    	 * When countdown finished,icons will be update
	    	 * @author Anais & Cyril
	    	 */
	        @Override
	        public void run() 
	        {
	        	if(secondPassed <= 0)
	        	{
	        		secondPassed = secondTotal;
	        		updatewindows = new UpdateWindows();
	        		try {
						updatewindows.updateIcon();
					} catch (SQLException e) {
						e.printStackTrace();
					}

	        	}
	        	else
	        	{
	        		secondPassed--;
	        		displayRemainingTime(secondPassed);
	        	}
	        }
	    };
	    
	    
	    // A effacer
	    public String displayRemainingTime(int sec)
	    {
			String remainingTime = "";
	    	secondeAff = (sec%60);
			minuteAff = (sec - secondeAff)/60;
			if(secondeAff < 10)
			{
				secondeAffS = "0" + secondeAff;
				remainingTime = minuteAff + ":" + secondeAffS;
				System.out.println("Timer icon"+ minuteAff + ":" + secondeAffS);
			}
			return remainingTime;
	    }
}
