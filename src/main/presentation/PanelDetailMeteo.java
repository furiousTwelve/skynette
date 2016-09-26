package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 
 * @author khadidja
 * @author Damien
 * @author audric
 * 
 *
 *         this window must describ the weather for montpellier city for seven
 *         days, lets' go!
 *
 */

public class PanelDetailMeteo extends JPanel {

	protected JPanel entete = new JPanel();
	protected JPanel panelGlobal = new JPanel(); // panelGlobal contains all the
													// composents

	protected JPanel panelNorth = new JPanel(); // panelNorth situated in the
												// orth of panelGlobal
												//

	protected JPanel panelCenter = new JPanel(); // panelNorth situated in the
													// center of panelGlobal
	protected JPanel panelSouth = new JPanel(); // panelNorth situated in the
												// south of panelGlobal

	protected JPanel panelSouth1 = new JPanel();
	protected JPanel panelSouth2 = new JPanel();
	protected JPanel panelSouth3 = new JPanel();
	protected JPanel panelSouth4 = new JPanel();
	protected ArrayList<PanelMeteo> listPanel = new ArrayList<>();

	protected PanelMeteo panelDay_3 = new PanelMeteo();
	protected PanelMeteo panelDay_2 = new PanelMeteo();
	protected PanelMeteo panelDay_1 = new PanelMeteo();
	protected PanelMeteo panelDay = new PanelMeteo();
	protected PanelMeteo panelNextDay1 = new PanelMeteo();
	protected PanelMeteo panelNextDay2 = new PanelMeteo();
	protected PanelMeteo panelNextDay3 = new PanelMeteo();
	
	protected JLabel hotestLabel = new JLabel("Hotest day of the year");
	protected JLabel coldestLabel = new JLabel("Coldest day of the year");
	protected JLabel maxAvgLabel = new JLabel("Max temperatures' average");
	protected JLabel minAvgLabel = new JLabel("Min temperatures' average");
	
	

	protected JPanel chartPanel = new JPanel();
	protected JLabel ville = new JLabel(" Montpellier town - France ");

	protected JLabel rainingDayIcon = new JLabel();

	ImageIcon iconRain = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\rain-1.png").getImage()
			.getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countRainingDays = new JLabel("43 Days");

	// protected JLabel empty = new JLabel();
	protected JLabel sunnyDaysIcone = new JLabel();
	ImageIcon iconSun = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage()
			.getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countSunnygDays = new JLabel(" 322 Days ");
	protected JLabel empty = new JLabel();
	// protected JLabel temperatureIcone1 = new JLabel();
	// ImageIcon icontemp1 = new ImageIcon(new
	// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(90,
	// 90, Image.SCALE_DEFAULT));
	ImageIcon iconWind = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\wind.png").getImage()
			.getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			// protected JLabel temperatureIcone2 = new JLabel();
			// ImageIcon icontemp2 = new ImageIcon(new
			// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(90,
			// 90, Image.SCALE_DEFAULT));
			// protected JLabel temperatureIcone3 = new JLabel();
			// ImageIcon icontemp3 = new ImageIcon(new
			// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(90,
			// 90, Image.SCALE_DEFAULT));

	// protected JLabel temperatureIcone4 = new JLabel();
	// ImageIcon icontemp4 = new ImageIcon(new
	// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage()
	// .getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	// protected JLabel temperatureIcone5 = new JLabel();
	// ImageIcon icontemp5 = new ImageIcon(new
	// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage()
	// .getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	// protected JLabel temperatureIcone6 = new JLabel();
	// ImageIcon icontemp6 = new ImageIcon(new
	// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage()
	// .getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	// protected JLabel temperatureIcone7 = new JLabel();
	// ImageIcon icontemp7 = new ImageIcon(new
	// ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage()
	// .getScaledInstance(90, 90, Image.SCALE_DEFAULT));

	// protected JLabel temperature1 = new JLabel("27°");
	// protected JLabel temperature2 = new JLabel("25°");
	// protected JLabel temperature3 = new JLabel("22°");
	// protected JLabel temperature4 = new JLabel("29°");
	// protected JLabel temperature5 = new JLabel("25°");
	// protected JLabel temperature6 = new JLabel("15°");
	// protected JLabel temperature7 = new JLabel("23°");

	protected JLabel HotestDay = new JLabel(" 39°");
	protected JLabel coldestDay = new JLabel(" 2°");

	// protected JLabel windDirection1 = new JLabel(" NNO ");
	// protected JLabel windSpeed1 = new JLabel("13km/h");
	//
	// protected JLabel windDirection2 = new JLabel(" NNO ");
	// protected JLabel windSpeed2 = new JLabel("19km/h");
	//
	// protected JLabel windDirection3 = new JLabel(" NNO ");
	// protected JLabel windSpeed3 = new JLabel("22km/h");
	//
	// protected JLabel windDirection4 = new JLabel(" NNO ");
	// protected JLabel windSpeed4 = new JLabel("15km/h");
	//
	// protected JLabel windDirection5 = new JLabel(" NNO ");
	// protected JLabel windSpeed5 = new JLabel("10km/h");
	//
	// protected JLabel windDirection6 = new JLabel(" NNO ");
	// protected JLabel windSpeed6 = new JLabel("25km/h");
	//
	// protected JLabel windDirection7 = new JLabel("NNO ");
	// protected JLabel windSpeed7 = new JLabel("60km/h");

	protected JLabel maxTemperatureAverage = new JLabel("25°");
	protected JLabel minTemperatureAverage = new JLabel("15°");
	protected Font font;

	// Layout to be used
	GridLayout g = new GridLayout(1, 7);
	GridLayout g1 = new GridLayout(2, 3);
	GridLayout g2 = new GridLayout(6, 1);
	GridLayout g3 = new GridLayout(3, 7);
	GridLayout g4 = new GridLayout(1, 4);
	GridLayout g5 = new GridLayout(2, 1);

	BorderLayout b = new BorderLayout();

	public PanelDetailMeteo() {
		run();
	}

	public JPanel createChartPanel() {
		String titre = "";
		String titre_x = "Hours/24h";
		String titre_y = "temperature/ pressure";

		XYDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createXYLineChart(titre, titre_x, titre_y, dataset);
		return new ChartPanel(chart);
	}

	protected XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries temp = new XYSeries("temperature ");
		XYSeries press = new XYSeries("pressure ");

		temp.add(1, 25);
		temp.add(2, 27);
		temp.add(3, 17);
		temp.add(4, 21);
		temp.add(5, 24);
		temp.add(6, 28);
		temp.add(7, 39);
		dataset.addSeries(temp);

		press.add(1, 13);
		press.add(2, 33);
		press.add(3, 15);
		press.add(4, 22);
		press.add(5, 9);
		press.add(6, 10);
		press.add(7, 17);
		dataset.addSeries(press);
		return dataset;
		/*
		 * the methode to draw the graph using the data base try {
		 * 
		 * dataSource = (DataSource)new InitialContext().lookup(
		 * "java:jdbc + the source"); } catch (sqlException e) {
		 * e.printStackTrace(); } if (dataSource != null) { Connection
		 * connection; try { // Connection to datasource connection
		 * =dataSource.getConnection();
		 * 
		 * // Query statement setting Statement statement
		 * =onnection.createStatement(); String Requete =
		 * "SELECT temerature, pression drom nomTable where date = todate" ;to
		 * verify with database team while(resultSet.next()) { //getString(n°of
		 * the attribut (temperature, pression)
		 * 
		 * 
		 * dataset.addValue(resultSet.getFloat(1),getFloat(2) ); }
		 * connection.close();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
	}

	public void run() {
		// this list will be used to update the 7 panels' meteo
		
		listPanel.add(panelDay_3);
		listPanel.add(panelDay_2);
		listPanel.add(panelDay_1);
		listPanel.add(panelDay);
		listPanel.add(panelNextDay1);
		listPanel.add(panelNextDay2);
		listPanel.add(panelNextDay3);
		
		// center the label in the rows of the gridlayout
		
		rainingDayIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		ville.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		sunnyDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countRainingDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countSunnygDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		maxTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		HotestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		coldestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		coldestLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		hotestLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minAvgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		maxAvgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		
		font = new Font("Arial", Font.BOLD, 36);
		ville.setFont(font);

		entete.add(ville);
		entete.setBackground(Color.WHITE);
		chartPanel = createChartPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));

		panelSouth1.setBackground(Color.WHITE);
		panelSouth2.setBackground(Color.WHITE);
		panelSouth3.setBackground(Color.WHITE);
		panelSouth4.setBackground(Color.WHITE);
		panelCenter.setBackground(Color.WHITE);
		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
		chartPanel.setBackground(Color.WHITE);
		panelGlobal.setLayout(b);
		

		// PanelNorth's Construction
		panelNorth.setLayout(g1);
		rainingDayIcon.setIcon(iconRain);
		sunnyDaysIcone.setIcon(iconSun);
		panelNorth.add(rainingDayIcon);
		panelNorth.add(ville);
		panelNorth.add(sunnyDaysIcone);
		panelNorth.add(countRainingDays);
		panelNorth.add(empty);
		panelNorth.add(countSunnygDays);
		g.setHgap(1200);

		// setLayout for panelCenter's panels
		panelCenter.setLayout(g);
		panelDay.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));

		// panelCenter's Construction
		// panelCenter.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
		// Color.DARK_GRAY));
		 entete.setPreferredSize(new java.awt.Dimension(900, 50));
		// // panel 3 days ago
		// panelDay_3.setBackground(Color.lightGray);
		// panelDay_3.date.setText(" date");
		// // iconSun par defaut
		// panelDay_3.weatherDaysIcone.setIcon(iconSun);
		// panelDay_3.temperature.setText(" 27 °");
		// panelDay_3.windSpeed.setText("25kM ");
		// panelDay_3.windDirection.setText("NNO");
		//
		// // panel 2 days ago
		// panelDay_2.setBackground(Color.lightGray);
		// temperatureIcone2.setIcon(icontemp2);
		// panelDay_2.add(new JLabel(" "));
		// panelDay_2.setBackground(Color.lightGray);
		// panelDay_2.date.setText("date ");
		// // iconSun par defaut
		// panelDay_2.weatherDaysIcone.setIcon(iconSun);
		// panelDay_2.temperature.setText(" ");
		// panelDay_2.windSpeed.setText(" ");
		// panelDay_2.windDirection.setText("");
		//
		// // panel 1 day ago
		// panelDay_1.setBackground(Color.lightGray);
		// temperatureIcone3.setIcon(icontemp3);
		// panelDay_1.setBackground(Color.lightGray);
		// panelDay_1.date.setText(" ");
		// // iconSun par defaut
		// panelDay_1.weatherDaysIcone.setIcon(iconSun);
		// panelDay_1.temperature.setText(" ");
		// panelDay_1.windSpeed.setText(" ");
		// panelDay_1.windDirection.setText("");

		// panel of the day
		// panelDay.setBackground(Color.lightGray);
		// temperatureIcone4.setIcon(icontemp4);
		// panelDay.setBackground(Color.lightGray);
		// panelDay.date.setText(" ");
		// // iconSun par defaut
		// panelDay.weatherDaysIcone.setIcon(iconSun);
		// panelDay.temperature.setText(" ");
		// panelDay.windSpeed.setText(" ");
		// panelDay.windDirection.setText("");

		// panel of the next day

		// temperatureIcone5.setIcon(icontemp5);
		// panelNextDay1.setBackground(Color.lightGray);
		// panelNextDay1.date.setText(" ");
		// // iconSun par defaut
		// panelNextDay1.weatherDaysIcone.setIcon(iconSun);
		// panelNextDay1.temperature.setText(" 23");
		// // panelNextDay1.windIcone
		// panelNextDay1.windSpeed.setText(" ");
		// panelNextDay1.windDirection.setText("");
		//
		// // panel 2 days after
		// panelNextDay2.setBackground(Color.lightGray);
		// temperatureIcone6.setIcon(icontemp6);
		//
		// panelNextDay2.date.setText(" ");
		// // iconSun par defaut
		// panelNextDay2.weatherDaysIcone.setIcon(iconSun);
		// panelNextDay2.temperature.setText(" ");
		// panelNextDay2.windSpeed.setText(" ");
		// panelNextDay2.windDirection.setText("");

		// panel 3 days after

		// temperatureIcone7.setIcon(icontemp7);
		// panelNextDay3.add(new JLabel(" "));
		// panelNextDay3.add(temperatureIcone7);
		// panelNextDay3.add(temperature7);
		//
		// panelNextDay3.setBackground(Color.lightGray);
		// panelNextDay3.date.setText(" ");
		// // iconSun par defaut
		// panelNextDay3.weatherDaysIcone.setIcon(iconSun);
		// panelNextDay3.temperature.setText(" ");
		// panelNextDay3.windSpeed.setText(" ");
		// panelNextDay3.windDirection.setText("");
		//
		panelCenter.add(panelDay_3);
		// panelDay_3.setPreferredSize(new java.awt.Dimension(100, 50));
		panelCenter.add(panelDay_2);
		// panelDay_2.setPreferredSize(new java.awt.Dimension(100, 70));
		panelCenter.add(panelDay_1);
		// panelDay_1.setPreferredSize(new java.awt.Dimension(100, 50));
		panelCenter.add(panelDay);
		// panelDay.setPreferredSize(new java.awt.Dimension(100, 50));
		panelCenter.add(panelNextDay1);
		// panelNextDay1.setPreferredSize(new java.awt.Dimension(100, 50));
		panelCenter.add(panelNextDay2);
		// panelNextDay2.setPreferredSize(new java.awt.Dimension(100, 50));
		panelCenter.add(panelNextDay3);
		// panelNextDay3.setPreferredSize(new java.awt.Dimension(100, 50));

		// space between columns,
		g.setHgap(50);
		g1.setHgap(50);

		// panelSouth's Construction

		panelSouth.setLayout(g4);
		g4.setHgap(50);
		panelSouth1.setLayout(g5);
		panelSouth1.add(hotestLabel);
		panelSouth1.add(HotestDay);
		panelSouth2.setLayout(g5);
		panelSouth2.add(coldestLabel);
		panelSouth2.add(coldestDay);
		panelSouth3.setLayout(g5);
		panelSouth3.add(maxAvgLabel);
		panelSouth3.add(maxTemperatureAverage);
		panelSouth4.setLayout(g5);
		panelSouth4.add(minAvgLabel);
		panelSouth4.add(minTemperatureAverage);

		
		panelSouth.add(panelSouth1);
		panelSouth.add(panelSouth2);
		panelSouth.add(panelSouth3);
		panelSouth.add(panelSouth4);
		g.setHgap(50);
		
		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelGlobal.add(panelCenter, BorderLayout.CENTER);
		panelGlobal.add(panelSouth, BorderLayout.SOUTH);
		// add panels to (this)
		//this.setLayout(b);
		//this.add(entete);
		this.add(panelGlobal);
		this.add(chartPanel);
	}

}
