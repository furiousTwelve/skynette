package main.presentation;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

<<<<<<< HEAD

	private panelIcone icone = new panelIcone();

	private PanelDetails f= new PanelDetails();
=======
private PanelDetails f= new PanelDetails();
>>>>>>> origin/features/controller/anais-10
	
	public  FenetrePrincipale(){
	    	this.setSize(1200,700);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.getAccessibleContext();
	        this.setVisible(true);

	        this.setContentPane(f);
	        this.setTitle("Skynette");
	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));

	}
	 
	
	public static void main(String[] args) {
		
		new FenetrePrincipale();

	}

}
