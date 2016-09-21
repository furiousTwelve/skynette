package main.presentation;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

	private panelIcone icone = new panelIcone();
	private PanelDetails f= new PanelDetails();
	
	public  FenetrePrincipale(){
	    	this.setSize(800, 200);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.getAccessibleContext();
	        this.setVisible(true);
	        this.setContentPane(icone);
	}
	 
	
	public static void main(String[] args) {
		new FenetrePrincipale();

	}

}
