package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author khadidja
 * 
 *
 *         this window must describ the weather for montpellier city for seven
 *         days, lets' go!
 *
 */
public class PanelDetails extends JPanel {
	protected JPanel panelGlobal = new JPanel(); // panelGlobal contains all the composents
													
	protected JPanel panelNorth = new JPanel(); // panelNorth situated in the orth of panelGlobal
												
	protected JPanel panelCenter = new JPanel(); // panelNorth situated in the
													// center of panelGlobal
	protected JPanel panelSouth = new JPanel(); // panelNorth situated in the
												// south of panelGlobal

	protected JPanel panelDay_3 = new JPanel();
	protected JPanel panelDay_2 = new JPanel();
	protected JPanel panelDay_1 = new JPanel();
	protected JPanel panelDay = new JPanel();
	protected JPanel panelNextDay1 = new JPanel();
	protected JPanel panelNextDay2 = new JPanel();
	protected JPanel panelNextDay3 = new JPanel();

	protected JPanel chartPanel = new JPanel();

	protected JLabel runingDaysIcone = new JLabel();
	ImageIcon iconRain = new ImageIcon(new ImageIcon("C:\\Users\\34011-82-04\\git\\skynette\\icon_weather\\rain-1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countRuningDays = new JLabel("13 jours");
	

	// protected JLabel empty = new JLabel();

	protected JLabel sunnyDaysIcone = new JLabel();
	ImageIcon iconSun = new ImageIcon(new ImageIcon("C:\\Users\\34011-82-04\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

	protected JLabel countSunnygDays = new JLabel("275 jours ");

	protected JLabel empty = new JLabel();

	protected JLabel temperatureIcone1 = new JLabel();
	ImageIcon icontemp1 = new ImageIcon(new ImageIcon("C:\\Users\\34011-82-04\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone2 = new JLabel();
	protected JLabel temperatureIcone3 = new JLabel();
	protected JLabel temperatureIcone4 = new JLabel();
	protected JLabel temperatureIcone5 = new JLabel();
	protected JLabel temperatureIcone6 = new JLabel();
	protected JLabel temperatureIcone7 = new JLabel();
	
	

	protected JLabel temperature1 = new JLabel("27°");
	protected JLabel temperature2 = new JLabel();
	protected JLabel temperature3 = new JLabel();
	protected JLabel temperature4 = new JLabel();
	protected JLabel temperature5 = new JLabel();
	protected JLabel temperature6 = new JLabel();
	protected JLabel temperature7 = new JLabel();

	protected JLabel HotestDay = new JLabel();
	protected JLabel coldestDay = new JLabel();

	protected JLabel windDirection1 = new JLabel();
	protected JLabel windSpeed1 = new JLabel("13km/h");

	protected JLabel windDirection2 = new JLabel();
	protected JLabel windSpeed2 = new JLabel("19km/h");

	protected JLabel windDirection3 = new JLabel();
	protected JLabel windSpeed3 = new JLabel("22km/h");

	protected JLabel windDirection4 = new JLabel();
	protected JLabel windSpeed4 = new JLabel("15km/h");

	protected JLabel windDirection5 = new JLabel();
	protected JLabel windSpeed5 = new JLabel("10km/h");

	protected JLabel windDirection6 = new JLabel();
	protected JLabel windSpeed6 = new JLabel("25km/h");

	protected JLabel windDirection7 = new JLabel();
	protected JLabel windSpeed7 = new JLabel("60km/h");

	protected JLabel windIcone = new JLabel();

	protected JLabel maxTemperatureAverage = new JLabel();
	protected JLabel minTemperatureAverage = new JLabel();

	// Layout to be used
	GridLayout g = new GridLayout(1, 7);
	GridLayout g1 = new GridLayout(2, 7);
	GridLayout g2 = new GridLayout(4, 1);

	BorderLayout b = new BorderLayout();

	public PanelDetails() {
		run();
	}

	public void run() {
		temperature1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelCenter.setBackground(Color.WHITE);
		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
		chartPanel.setBackground(Color.WHITE);
		panelGlobal.setLayout(b);
		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelGlobal.add(panelCenter, BorderLayout.CENTER);
		panelGlobal.add(panelSouth, BorderLayout.SOUTH);

		// PanelNorth's Construction
		panelNorth.setLayout(g1);
		runingDaysIcone.setIcon(iconRain);
		sunnyDaysIcone.setIcon(iconSun);
		panelNorth.add(runingDaysIcone);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(sunnyDaysIcone);

		panelNorth.add(countRuningDays);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(empty);
		panelNorth.add(countSunnygDays);
		g1.setHgap(2000);

		// setLayout for panelCenter's panels
		panelCenter.setLayout(g);
		 panelDay_3.setLayout(g2);
		 panelDay_2.setLayout(g2);
		 panelDay_1.setLayout(g2);
		panelDay.setLayout(g2);
		 panelNextDay1.setLayout(g2);
		 panelNextDay2.setLayout(g2);
		panelNextDay3.setLayout(g2);

		// panelCenter's Construction

		// panel 3 days ago
		//panelDay_3.setBackground(Color.CYAN);
		temperatureIcone1.setIcon(icontemp1);
		panelDay_3.add(temperatureIcone1);
		panelDay_3.add(temperature1);
		panelDay_3.add(windIcone);
		panelDay_3.add(windSpeed1);
		panelDay_3.add(windDirection1);
		
		
		 
		 
		// panel 2 days ago
		panelDay_2.add(temperatureIcone2);
		panelDay_2.add(temperature2);

		panelDay_2.add(windIcone);
		panelDay_2.add(windSpeed2);
		panelDay_2.add(windDirection2);
		
		

		// panel 1 day ago
		panelDay_1.add(temperatureIcone3);
		panelDay_1.add(temperature3);

		panelDay_1.add(windIcone);
		panelDay_1.add(windSpeed3);
		panelDay_1.add(windDirection3);

		
		
		// panel of the day
		panelDay.add(temperatureIcone4);
		panelDay.add(temperature4);

		panelDay.add(windIcone);
		panelDay.add(windSpeed4);
		panelDay.add(windDirection4);
		
       
        
		// panel of the next day
		panelNextDay1.add(temperatureIcone5);
		panelNextDay1.add(temperature5);

		panelNextDay1.add(windIcone);
		panelNextDay1.add(windSpeed5);
		panelNextDay1.add(windDirection5);

		// panel 2 days after
		panelNextDay2.add(temperatureIcone6);
		panelNextDay2.add(temperature6);

		panelNextDay2.add(windIcone);
		panelNextDay2.add(windSpeed6);
		panelNextDay2.add(windDirection1);

		// panel 3 days after
		panelNextDay3.add(temperatureIcone7);
		panelNextDay3.add(temperature7);

		panelNextDay3.add(windIcone);
		panelNextDay3.add(windSpeed7);
		panelNextDay3.add(windDirection7);

		panelCenter.add(panelDay_3);
		panelCenter.add(panelDay_2);
		panelCenter.add(panelDay_1);
		panelCenter.add(panelDay);
		panelCenter.add(panelNextDay1);
		panelCenter.add(panelNextDay2);
		panelCenter.add(panelNextDay3);
		
		//space between columns,
		g.setHgap(50);
		g1.setHgap(50);

		// panelSouth's Construction
		panelSouth.setLayout(g);
		panelSouth.add(HotestDay);
		panelSouth.add(coldestDay);
		panelSouth.add(empty);
		panelSouth.add(maxTemperatureAverage);
		panelSouth.add(minTemperatureAverage);

		// construction of the graphic panel

		// add panels to (this)
		this.add(panelGlobal);
		this.add(chartPanel);
	}

}
