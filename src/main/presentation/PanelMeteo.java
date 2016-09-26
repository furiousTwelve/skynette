package main.presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 *  
 * @author khadidja
 * @author Damien
 * @author audric
 *
 */
public class PanelMeteo extends JPanel implements  MouseListener{

	protected JPanel panelDay = new JPanel();
	protected JLabel sunnyDaysIcon = new JLabel();
	protected JLabel temperatureIcone1 = new JLabel();
	ImageIcon iconWind = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\wind.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	ImageIcon icontemp = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	protected JLabel weatherDaysIcone = new JLabel(icontemp);
	protected JLabel temperature = new JLabel("27�");
	protected JLabel windDirection = new JLabel(" NNO ");
	protected JLabel windSpeed = new JLabel("13km/h");
	protected JLabel windIcone = new JLabel(iconWind);
	protected JLabel date = new JLabel(" ");
	GridLayout g2 = new GridLayout(6, 1);
    
	public PanelMeteo() {

		this.setLayout(g2);
		this.add(date);
		this.add(weatherDaysIcone);
		this.add(temperature);
		this.add(windIcone);
		this.add(windSpeed);
		this.add(windSpeed);
		this.setPreferredSize(new java.awt.Dimension(200, 500));
		this.setBackground(new Color(1f, 1f, 1f, 0.7f));

		date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		weatherDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	}

	public ImageIcon getIconWind() {
		return iconWind;
	}

	public void setIconWind(ImageIcon iconWind) {
		this.iconWind = iconWind;
	}

	public ImageIcon getIcontemp() {
		return icontemp;
	}

	public void setIcontemp(ImageIcon icontemp) {
		this.icontemp = icontemp;
	}

	public JLabel getWeatherDaysIcone() {
		return weatherDaysIcone;
	}

	public void setWeatherDaysIcone(JLabel weatherDaysIcone) {
		this.weatherDaysIcone = weatherDaysIcone;
	}

	public JLabel getTemperature() {
		return temperature;
	}

	public void setTemperature(JLabel temperature) {
		this.temperature = temperature;
	}

	public JLabel getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(JLabel windDirection) {
		this.windDirection = windDirection;
	}

	public JLabel getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(JLabel windSpeed) {
		this.windSpeed = windSpeed;
	}

	public JLabel getWindIcone() {
		return windIcone;
	}

	public void setWindIcone(JLabel windIcone) {
		this.windIcone = windIcone;
	}

	public JLabel getDate() {
		return date;
	}

	public void setDate(JLabel date) {
		this.date = date;
	}

	public GridLayout getG2() {
		return g2;
	}

	public void setG2(GridLayout g2) {
		this.g2 = g2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
