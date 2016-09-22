package main.presentation;


import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import main.data.SQLite;



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
	private Countdown count = new Countdown(2);
	
	
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
        
        count.start();
	}
	 

	/**
	 * Main part
	 * @param args
	 */
	
	public static void main(String[] args) throws SQLException {

		FenetrePrincipale fenetre = new FenetrePrincipale();
		SQLite database = new SQLite();
		database.verifyDB();

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
		
		// the state is : I a big window and I want to be small to display only an icon
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

}
