package main.presentation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Panel qui s'affiche en bas à droite de l'écran au lancement de l'application avec un résumé de la météo
 * @author Audric
 *
 */

public class panelIcone extends JPanel {

	
	private JLabel imageDescription;
	private JLabel temp;
	private JLabel directionVent;
	private JLabel vitesseVent;
	private Font font;
	private PanelDetails panDetail; 
	
	public panelIcone(){
		//this.setBackground(Color.WHITE);
		font = new Font("Arial",Font.BOLD,20);
		//Constitution du panel avec l'image
		ImageIcon meteo = new ImageIcon("cloudy.png");
		Image img = meteo.getImage();
		Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newmeteo = new ImageIcon(newimg);
		imageDescription = new JLabel(newmeteo);
		Color back = new Color(1f,0f,0f,0.2f);
		
		
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new FlowLayout());
		panelDescription.add(imageDescription);

		//Constitution du panel avec la température
		temp = new JLabel("20°C");
		temp.setFont(font);

		JPanel panelTemp = new JPanel();
		panelTemp.setLayout(new FlowLayout());
		panelTemp.add(temp);
		
		//Constitution du panel avec la direction du vent
		directionVent = new JLabel("NE");
		directionVent.setFont(font);
		
		JPanel panelDirVent = new JPanel();
		panelDirVent.setLayout(new FlowLayout());
		panelDirVent.add(directionVent);
		
		//Constitution du panel avec la vitesse du vent
		vitesseVent = new JLabel("50km/h");
		vitesseVent.setFont(font);
		
		JPanel panelVitVent = new JPanel();
		panelVitVent.setLayout(new FlowLayout());
		panelVitVent.add(vitesseVent);
		
		//Constitution du panelCentral
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		panelCentral.add(panelDescription);
		panelCentral.add(panelTemp);
		panelCentral.add(panelDirVent);
		panelCentral.add(panelVitVent);
		
		//Constitution du panel général
		this.setLayout(new BorderLayout());
		this.add(panelCentral, BorderLayout.CENTER);
		this.setVisible(true);
		this.setBackground(back);
		
	}

	public JLabel getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(JLabel imageDescription) {
		this.imageDescription = imageDescription;
	}

	public JLabel getTemp() {
		return temp;
	}

	public void setTemp(JLabel temp) {
		this.temp = temp;
	}

	public JLabel getDirectionVent() {
		return directionVent;
	}

	public void setDirectionVent(JLabel directionVent) {
		this.directionVent = directionVent;
	}

	public JLabel getVitesseVent() {
		return vitesseVent;
	}

	public void setVitesseVent(JLabel vitesseVent) {
		this.vitesseVent = vitesseVent;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public PanelDetails getPanDetail() {
		return panDetail;
	}

	public void setPanDetail(PanelDetails panDetail) {
		this.panDetail = panDetail;
	}
	
}