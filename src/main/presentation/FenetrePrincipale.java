package main.presentation;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * Sets the main window of the application that will manage the interaction of the panels
 * @author Khadidja
 * @author Audric
 *
 */

public class FenetrePrincipale extends JFrame implements MouseListener {


	private PanelIcon icon = new PanelIcon();
	private PanelDetails f = new PanelDetails();
	private Countdown count = new Countdown(8);
	
	
	public  FenetrePrincipale(){
			
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
	    	this.setUndecorated(true);
	        this.getAccessibleContext();

	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\planet-earth.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	        this.setTitle("Skynette"); 
	        icon.addMouseListener(this);
	        this.setContentPane(icon);
	        this.setVisible(true);
	        setOpacity(0.95f);
	        
	        count.start();
	}
	 
	public static void main(String[] args) {

		FenetrePrincipale fenetre = new FenetrePrincipale();
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.icon){
			f = new PanelDetails();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(2000, 1000));
			this.setLocationRelativeTo(null);
			f.addMouseListener(this);
			this.setContentPane(f);
			this.validate();
		}
		if(e.getSource() == this.f){
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
