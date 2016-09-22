package main.presentation;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMeteo extends JPanel{
	
	protected JPanel panelDay = new JPanel();
	protected JLabel sunnyDaysIcone = new JLabel();
	ImageIcon iconWind = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\wind.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone1 = new JLabel();
	protected JLabel temperature = new JLabel("27°");
	protected JLabel windDirection = new JLabel(" NNO ");
	protected JLabel windSpeed1 = new JLabel("13km/h");
	protected JLabel windIcone = new JLabel(iconWind);
	GridLayout g2 = new GridLayout(6, 1);
	
	
	public PanelMeteo(){
		panelDay.setLayout(g2);
		
	}
	
	
	
	

}
