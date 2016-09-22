package main.presentation;

import javax.swing.JFrame;
public class FenetrePrincipale extends JFrame {


	private panelIcone icone = new panelIcone();

	private PanelDetails f= new PanelDetails();
	
	public  FenetrePrincipale(){
	    	this.setSize(1200,900);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.getAccessibleContext();
	        this.setVisible(true);

	        this.setContentPane(f);
	        this.setTitle("Skynette");
//	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
	        Countdown count = new Countdown(10);
	        count.start();

	}
	
	public static void main(String[] args) {
		new FenetrePrincipale();

	}

}
