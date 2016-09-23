package main.presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMeteo extends JPanel {

	// protected JPanel panelDay = new JPanel();
	protected JLabel weatherDaysIcone = new JLabel();
	ImageIcon iconWind = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\wind.png").getImage()
			.getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone1 = new JLabel();
	protected JLabel temperature = new JLabel("27°");
	protected JLabel windDirection = new JLabel(" NNO ");
	protected JLabel windSpeed = new JLabel("13km/h");
	protected JLabel windIcone = new JLabel(iconWind);
	
	protected JLabel date = new JLabel();
	GridLayout g2 = new GridLayout(6, 1);

	public PanelMeteo() {
		this.setLayout(g2);
		this.add(date);
		this.add(weatherDaysIcone);
       
		this.add(temperature);
		this.add(windIcone);
		this.add(windSpeed);
		this.add(windSpeed);
		this.setPreferredSize(new java.awt.Dimension(100, 50));
		this.setBackground(Color.WHITE);
		
		 date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 weatherDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 temperature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 windIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 windSpeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 windDirection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 

	}

}
