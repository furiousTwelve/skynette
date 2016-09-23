package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
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
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * 
 * @author khadidja
 * 
 *
 *         this window must describ the weather for montpellier city for seven
 *         days, lets' go!
 *
 */

public class PanelDetails extends JPanel implements ActionListener, MouseListener {

	protected JPanel entete = new JPanel();
	protected JPanel panelGlobal = new JPanel(); // panelGlobal contains all the
													// composents

	protected JPanel panelNorth = new JPanel(); // panelNorth situated in the
												// orth of panelGlobal

	protected JPanel panelCenter = new JPanel(); // panelNorth situated in the
													// center of panelGlobal
	protected JPanel panelSouth = new JPanel(); // panelNorth situated in the
												// south of panelGlobal

	protected JPanel panelSouth1 = new JPanel();
	protected JPanel panelSouth2 = new JPanel();
	protected JPanel panelSouth3 = new JPanel();
	protected JPanel panelSouth4 = new JPanel();

	protected JPanel panelDay_3 = new JPanel();
	protected JPanel panelDay_2 = new JPanel();
	protected JPanel panelDay_1 = new JPanel();
	protected JPanel panelDay = new JPanel();
	protected JPanel panelNextDay1 = new JPanel();
	protected JPanel panelNextDay2 = new JPanel();
	protected JPanel panelNextDay3 = new JPanel();

	protected JPanel chartPanel = new JPanel();
	protected JLabel ville = new JLabel(" Montpellier town - France ");

	protected JLabel rainingDayIcon = new JLabel();

	ImageIcon iconRain = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\rain-1.png").getImage()
			.getScaledInstance(70, 70, Image.SCALE_DEFAULT));

	ImageIcon iconRain2 = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\rain-1.png").getImage()
			.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	protected JLabel countRainingDays = new JLabel("Aucune info");

	ImageIcon iconSun2 = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\rain-1.png").getImage()
			.getScaledInstance(100, 100, Image.SCALE_DEFAULT));

	// protected JLabel empty = new JLabel();

	protected JLabel sunnyDaysIcone = new JLabel();

	ImageIcon iconSun = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countSunnygDays = new JLabel("aucune info ");
	protected JLabel empty = new JLabel();
	protected JLabel temperatureIcone1 = new JLabel();
	protected JLabel temperatureIcone2 = new JLabel();
	protected JLabel temperatureIcone3 = new JLabel();
	ImageIcon icontemp3 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone4 = new JLabel();
	ImageIcon icontemp4 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone5 = new JLabel();
	ImageIcon icontemp5 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone6 = new JLabel();
	ImageIcon icontemp6 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone7 = new JLabel();
	ImageIcon icontemp7 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	ImageIcon icontemp1 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	ImageIcon iconWind = new ImageIcon(new ImageIcon("./icon_weather/wind.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	ImageIcon iconWindDir = new ImageIcon(new ImageIcon("./icon_weather/Wind Direction.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
	ImageIcon icontemp2 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperature1 = new JLabel("27°");
	protected JLabel temperature2 = new JLabel("25°");
	protected JLabel temperature3 = new JLabel("22°");
	protected JLabel temperature4 = new JLabel("29°");
	protected JLabel temperature5 = new JLabel("25°");
	protected JLabel temperature6 = new JLabel("15°");
	protected JLabel temperature7 = new JLabel("23°");

	protected JLabel HotestDay = new JLabel(" 39°");
	protected JLabel coldestDay = new JLabel(" 2°");

	protected JLabel windDirection1 = new JLabel(" NNO ");
	protected JLabel windSpeed1 = new JLabel("13km/h");

	protected JLabel windDirection2 = new JLabel(" NNO ");
	protected JLabel windSpeed2 = new JLabel("19km/h");

	protected JLabel windDirection3 = new JLabel(" NNO ");
	protected JLabel windSpeed3 = new JLabel("22km/h");

	protected JLabel windDirection4 = new JLabel(" NNO ");
	protected JLabel windSpeed4 = new JLabel("15km/h");

	protected JLabel windDirection5 = new JLabel(" NNO ");
	protected JLabel windSpeed5 = new JLabel("10km/h");

	protected JLabel windDirection6 = new JLabel(" NNO ");
	protected JLabel windSpeed6 = new JLabel("25km/h");

	protected JLabel windDirection7 = new JLabel("NNO ");
	protected JLabel windSpeed7 = new JLabel("60km/h");

	protected JLabel windIcone1 = new JLabel(iconWind);
	protected JLabel windIcone2 = new JLabel(iconWind);
	protected JLabel windIcone3 = new JLabel(iconWind);
	protected JLabel windIcone4 = new JLabel(iconWind);
	protected JLabel windIcone5 = new JLabel(iconWind);
	protected JLabel windIcone6 = new JLabel(iconWind);
	protected JLabel windIcone7 = new JLabel(iconWind);

	protected JLabel windDirIcone1 = new JLabel(iconWindDir);
	protected JLabel windDirIcone2 = new JLabel(iconWindDir);
	protected JLabel windDirIcone3 = new JLabel(iconWindDir);
	protected JLabel windDirIcone4 = new JLabel(iconWindDir);
	protected JLabel windDirIcone5 = new JLabel(iconWindDir);
	protected JLabel windDirIcone6 = new JLabel(iconWindDir);
	protected JLabel windDirIcone7 = new JLabel(iconWindDir);

	protected JLabel maxTemperatureAverage = new JLabel("25°");
	protected JLabel minTemperatureAverage = new JLabel("15°");

	protected Font font;
	protected Font font2;

	protected JLabel hotestDayLabel = new JLabel("Hotest day of the year");
	protected JLabel coldestDayLabel = new JLabel("Coldest day of the year");
	protected JLabel maxAvgTempLabel = new JLabel("Max temperatures' average");
	protected JLabel minAvgTempLabel = new JLabel("Min temperatures' average");

	protected Image img;

	// Layout to be used
	GridLayout g = new GridLayout(1, 7);
	GridLayout g1 = new GridLayout(2, 7);
	GridLayout g2 = new GridLayout(7, 1);
	GridLayout g3 = new GridLayout(3, 7);
	GridLayout g4 = new GridLayout(1, 4);
	GridLayout g5 = new GridLayout(2, 1);

	BorderLayout b = new BorderLayout();

	// new colour
	Color background = new Color(0f, 0.3f, 1f, 0.5f);

	/**
	 * Constructor which call the run methods
	 */

	public PanelDetails() {

		run();
	}

	// Work in progress for the backgroundPanel
	// public void paint(Graphics g)
	// {
	// // Draws the img to the BackgroundPanel.
	// g.drawImage(img, 0, 0, null);
	// }

	public JPanel createChartPanel() {
		String titre = "";
		String titre_x = "Hour/24";
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
		 * the methode to draw the graph using the data base
		 *  try {
		 * 
		 * dataSource = (DataSource)new InitialContext().lookup("java:jdbc + the source");
		 * } 
		 * catch (sqlException e) { e.printStackTrace(); } if (dataSource !=
		 * null)
		 *  {
		 * Connection connection;
		 *  try { // Connection to datasource connection =dataSource.getConnection();
		 
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

		font = new Font("Arial", Font.BOLD, 36);
		font2 = new Font("Arial", Font.BOLD, 15);
		ville.setFont(font);

		entete.add(ville);
		entete.setBackground(Color.WHITE);

		// work in progress for the background of the panel
		img = Toolkit.getDefaultToolkit().createImage("./icon_weather/sky.jpg");

		chartPanel = createChartPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 300));

		temperatureIcone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperatureIcone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		temperature1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		windDirection1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windDirection7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		windSpeed1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windSpeed7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		panelSouth1.setBackground(Color.WHITE);
		panelSouth2.setBackground(Color.WHITE);
		panelSouth3.setBackground(Color.WHITE);
		panelSouth4.setBackground(Color.WHITE);
		panelCenter.setBackground(Color.WHITE);
		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);

		chartPanel.setBackground(Color.WHITE);
		panelGlobal.setLayout(b);
		// panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelGlobal.add(panelCenter, BorderLayout.CENTER);
		panelGlobal.add(panelSouth, BorderLayout.SOUTH);

		// PanelNorth's Construction
		// panelNorth.setLayout(g1);
		// rainingDayIcon.setIcon(iconRain);
		// sunnyDaysIcone.setIcon(iconSun);
		// panelNorth.add(rainingDayIcon);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		// panelNorth.add(sunnyDaysIcone);
		//
		// panelNorth.add(countRainingDays);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		// panelNorth.add(empty);
		//
		// panelNorth.add(countSunnygDays);
		// g1.setHgap(2000);

		// setLayout for panelCenter's panels
		panelCenter.setLayout(g);
		panelDay_3.setLayout(g2);
		panelDay_2.setLayout(g2);
		panelDay_1.setLayout(g2);
		panelDay.setLayout(g2);

		panelDay.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));

		panelDay.setPreferredSize(new java.awt.Dimension(200, 50));
		panelNextDay1.setLayout(g2);
		panelNextDay2.setLayout(g2);
		panelNextDay3.setLayout(g2);

		// panelCenter's Construction

		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("EEEE, d MMM yyyy");

		// panel 3 days ago
		panelDay_3.setBackground(Color.lightGray);

		long threeDaysAgo = today.getTime() - (3 * 1000 * 60 * 60 * 24);
		JLabel date6 = new JLabel(formater.format(threeDaysAgo));
		panelDay_3.add(date6);

		temperatureIcone1.setIcon(icontemp1);
		panelDay_3.add(temperatureIcone1);
		panelDay_3.add(temperature1);
		panelDay_3.add(windIcone1);
		panelDay_3.add(windSpeed1);
		panelDay_3.add(windDirIcone1);
		panelDay_3.add(windDirection1);

		// panel 2 days ago

		panelDay_2.setBackground(Color.lightGray);

		long twoDaysAgo = today.getTime() - (2 * 1000 * 60 * 60 * 24);
		JLabel date5 = new JLabel(formater.format(twoDaysAgo));
		panelDay_2.add(date5);

		temperatureIcone2.setIcon(icontemp2);
		panelDay_2.add(temperatureIcone2);
		panelDay_2.add(temperature2);

		panelDay_2.add(windIcone2);
		panelDay_2.add(windSpeed2);
		panelDay_2.add(windDirIcone2);
		panelDay_2.add(windDirection2);

		// panel 1 day ago

		panelDay_1.setBackground(Color.lightGray);

		long oneDayAgo = today.getTime() - (1000 * 60 * 60 * 24);
		JLabel date4 = new JLabel(formater.format(oneDayAgo));
		panelDay_1.add(date4);

		temperatureIcone3.setIcon(icontemp3);
		panelDay_1.add(temperatureIcone3);
		panelDay_1.add(temperature3);

		panelDay_1.add(windIcone3);
		panelDay_1.add(windSpeed3);
		panelDay_1.add(windDirIcone3);
		panelDay_1.add(windDirection3);

		// panel of the day

		JLabel date = new JLabel(formater.format(today));
		panelDay.add(date);

		temperatureIcone4.setIcon(icontemp4);
		panelDay.add(temperatureIcone4);
		panelDay.add(temperature4);

		panelDay.add(windIcone4);
		panelDay.add(windSpeed4);
		panelDay.add(windDirIcone4);
		panelDay.add(windDirection4);

		// panel of the next day

		panelNextDay1.setBackground(Color.lightGray);

		long nextDay = today.getTime() + (1000 * 60 * 60 * 24);
		JLabel date1 = new JLabel(formater.format(nextDay));
		panelNextDay1.add(date1);

		temperatureIcone5.setIcon(icontemp5);
		panelNextDay1.add(temperatureIcone5);
		panelNextDay1.add(temperature5);

		panelNextDay1.add(windIcone5);
		panelNextDay1.add(windSpeed5);
		panelNextDay1.add(windDirIcone5);
		panelNextDay1.add(windDirection5);

		// panel 2 days after

		panelNextDay2.setBackground(Color.lightGray);

		long twoDaysAfter = today.getTime() + (2 * 1000 * 60 * 60 * 24);
		JLabel date2 = new JLabel(formater.format(twoDaysAfter));
		panelNextDay2.add(date2);

		temperatureIcone6.setIcon(icontemp6);
		panelNextDay2.add(temperatureIcone6);
		panelNextDay2.add(temperature6);

		panelNextDay2.add(windIcone6);
		panelNextDay2.add(windSpeed6);
		panelNextDay2.add(windDirIcone6);
		panelNextDay2.add(windDirection6);

		// panel 3 days after

		panelNextDay3.setBackground(Color.lightGray);

		long threeDaysAfter = today.getTime() + (3 * 1000 * 60 * 60 * 24);
		JLabel date3 = new JLabel(formater.format(threeDaysAfter));
		panelNextDay3.add(date3);

		temperatureIcone7.setIcon(icontemp7);
		panelNextDay3.add(temperatureIcone7);
		panelNextDay3.add(temperature7);

		panelNextDay3.add(windIcone7);
		panelNextDay3.add(windSpeed7);
		panelNextDay3.add(windDirIcone7);
		panelNextDay3.add(windDirection7);

		date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date.setFont(font2);
		date1.setFont(font2);
		date2.setFont(font2);
		date3.setFont(font2);
		date4.setFont(font2);
		date5.setFont(font2);
		date6.setFont(font2);
		temperature1.setFont(font2);
		temperature2.setFont(font2);
		temperature3.setFont(font2);
		temperature4.setFont(font2);
		temperature5.setFont(font2);
		temperature6.setFont(font2);
		temperature7.setFont(font2);
		windSpeed1.setFont(font2);
		windSpeed2.setFont(font2);
		windSpeed3.setFont(font2);
		windSpeed4.setFont(font2);
		windSpeed5.setFont(font2);
		windSpeed6.setFont(font2);
		windSpeed7.setFont(font2);
		windDirection1.setFont(font2);
		windDirection2.setFont(font2);
		windDirection3.setFont(font2);
		windDirection4.setFont(font2);
		windDirection5.setFont(font2);
		windDirection6.setFont(font2);
		windDirection7.setFont(font2);

		panelCenter.add(panelDay_3);
		panelCenter.add(panelDay_2);
		panelCenter.add(panelDay_1);
		panelCenter.add(panelDay);
		panelCenter.add(panelNextDay1);
		panelCenter.add(panelNextDay2);
		panelCenter.add(panelNextDay3);

		// space between columns,
		g.setHgap(50);
		g1.setHgap(50);

		// panelSouth's Construction

		panelSouth.setLayout(g4);
		g4.setHgap(50);
		panelSouth1.setLayout(g5);
		panelSouth1.add(new JLabel("Hotest day of the year"));
		panelSouth1.add(HotestDay);
		panelSouth2.setLayout(g5);
		panelSouth2.add(new JLabel("Coldest day of the year"));
		panelSouth2.add(coldestDay);
		panelSouth3.setLayout(g5);
		panelSouth3.add(new JLabel("Max temperatures' average"));
		panelSouth3.add(maxTemperatureAverage);
		panelSouth4.setLayout(g5);
		panelSouth4.add(new JLabel("Min temperatures' average"));
		panelSouth4.add(minTemperatureAverage);

		panelSouth.add(panelSouth1);
		panelSouth.add(panelSouth2);
		panelSouth.add(panelSouth3);
		panelSouth.add(panelSouth4);

		// add panels to (this)
		this.add(entete);
		this.add(panelGlobal);
		this.add(chartPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

}