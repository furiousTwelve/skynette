package main.presentation;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements MouseListener {

	private panelIcone icone = new panelIcone();

	private PanelDetails f = new PanelDetails();

	
	public  FenetrePrincipale(){
			
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
	    	this.setUndecorated(true);
	        this.getAccessibleContext();

	        this.setVisible(true);

	        this.setContentPane(icone);
	        this.setTitle("Skynette");
	   
	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\planet-earth.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

	}
	 
	public static void main(String[] args) {

		FenetrePrincipale fenetre = new FenetrePrincipale();
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.icone){
			f = new PanelDetails();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(1500, 800));
			this.setLocationRelativeTo(null);
			f.addMouseListener(this);
			this.setContentPane(f);
			this.validate();
		}
		if(e.getSource() == this.f){
			icone = new panelIcone();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
			icone.addMouseListener(this);
			this.setContentPane(icone);
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
