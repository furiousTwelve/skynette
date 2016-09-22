package main.presentation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Panel that appears at the bottom right of the screen to launch the application with a summary of the weather
 * @author Audric
 *
 */

public class PanelIcon extends JPanel {

	
	private JLabel descriptionPicture;
	private JLabel temp;
	private JLabel windDirection;
	private JLabel windSpeed;
	private Font font;
	private PanelDetails panDetail; 
	
	public PanelIcon(){
		
		font = new Font("Arial",Font.BOLD,20);
		
		//forming the panel with the picture
		ImageIcon meteo = new ImageIcon("cloudy.png");
		Image img = meteo.getImage();
		Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newmeteo = new ImageIcon(newimg);
		descriptionPicture = new JLabel(newmeteo);		
		
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new FlowLayout());
		panelDescription.add(descriptionPicture);
		panelDescription.setBackground(Color.WHITE);

		//forming the panel with the temperature
		temp = new JLabel("20°C");
		temp.setFont(font);

		JPanel panelTemp = new JPanel();
		panelTemp.setLayout(new FlowLayout());
		panelTemp.add(temp);
		panelTemp.setBackground(Color.WHITE);
		
		//forming the panel with the wind direction
		windDirection = new JLabel("NE");
		windDirection.setFont(font);
		
		JPanel panelWindDir = new JPanel();
		panelWindDir.setLayout(new FlowLayout());
		panelWindDir.add(windDirection);
		panelWindDir.setBackground(Color.WHITE);
		
		//forming the panel with the wind speed
		windSpeed = new JLabel("50km/h");
		windSpeed.setFont(font);
		
		JPanel panelWindSpeed = new JPanel();
		panelWindSpeed.setLayout(new FlowLayout());
		panelWindSpeed.add(windSpeed);
		panelWindSpeed.setBackground(Color.WHITE);
		
		//forming the central panel
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		panelCentral.add(panelDescription);
		panelCentral.add(panelTemp);
		panelCentral.add(panelWindDir);
		panelCentral.add(panelWindSpeed);
		
		//forming the general panel
		this.setLayout(new BorderLayout());
		this.add(panelCentral, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

	public JLabel getImageDescription() {
		return descriptionPicture;
	}

	public void setImageDescription(JLabel imageDescription) {
		this.descriptionPicture = imageDescription;
	}

	public JLabel getTemp() {
		return temp;
	}

	public void setTemp(JLabel temp) {
		this.temp = temp;
	}

	public JLabel getDirectionVent() {
		return windDirection;
	}

	public void setDirectionVent(JLabel directionVent) {
		this.windDirection = directionVent;
	}

	public JLabel getVitesseVent() {
		return windSpeed;
	}

	public void setVitesseVent(JLabel vitesseVent) {
		this.windSpeed = vitesseVent;
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