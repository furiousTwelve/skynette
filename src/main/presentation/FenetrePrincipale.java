package main.presentation;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements MouseListener {

	private panelIcone icone = new panelIcone();

	private PanelDetails f= new PanelDetails();

	
	public  FenetrePrincipale(){
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
	    	this.setUndecorated(true);
	        this.getAccessibleContext();
	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
	        this.setTitle("Skynette"); 
	        icone.addMouseListener(this);
	        this.setContentPane(icone);
	        this.setVisible(true);
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
			this.setContentPane(f);
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