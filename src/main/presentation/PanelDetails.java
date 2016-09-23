package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 * This window must describe the weather for montpellier city for seven days, lets' go!
 * @author khadidja
 */


public class PanelDetails extends JPanel implements ActionListener, MouseListener 
{
	protected JPanel panelGlobal = new JPanel(); // panelGlobal contains all the composents
	protected JPanel panelNorth = new JPanel(); // panelNorth situated in the orth of panelGlobal
	protected JPanel panelCenter = new JPanel(); // panelNorth situated in the center of panelGlobal
	protected JPanel panelSouth = new JPanel(); // panelNorth situated in the south of panelGlobal
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
	protected JLabel runingDaysIcone = new JLabel();
	ImageIcon iconRain = new ImageIcon(new ImageIcon("./icon_weather/rain-1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countRuningDays = new JLabel("13 jours");
	// protected JLabel empty = new JLabel();
	protected JLabel sunnyDaysIcone = new JLabel();
	ImageIcon iconSun = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countSunnygDays = new JLabel("275 jours ");
	protected JLabel empty = new JLabel("       ", 10);
	protected JLabel temperatureIcone1 = new JLabel();
	ImageIcon icontemp1 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone2 = new JLabel();
	ImageIcon icontemp2 = new ImageIcon(new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
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

	protected JLabel windIcone = new JLabel();

	protected JLabel maxTemperatureAverage = new JLabel("25°");
	protected JLabel minTemperatureAverage = new JLabel("15°");
	
	protected JLabel hotestDayLabel = new JLabel("Hotest day of the year");
	protected JLabel coldestDayLabel = new JLabel("Coldest day of the year");
	protected JLabel maxAvgTempLabel = new JLabel("Max temperatures' average");
	protected JLabel minAvgTempLabel = new JLabel("Min temperatures' average");

	// Layout to be used
	GridLayout g = new GridLayout(1, 7);
	GridLayout g1 = new GridLayout(2, 2);
	GridLayout g2 = new GridLayout(4, 1);
	GridLayout g3 = new GridLayout(3, 7);
	GridLayout g4 = new GridLayout(1, 4);
	GridLayout g5 = new GridLayout(2, 1);

	BorderLayout b = new BorderLayout();
	
	//new colour
	Color background = new Color(0f, 0.3f, 1f, 0.5f);
	
	
	/**
	 * Constructor which call the run methods
	 */
	public PanelDetails() 
	{
		run();
	}

	/**
	 * Create a chart panel
	 * @return a jpanel with the chart inside
	 */
	public JPanel createChartPanel() 
	{
		String titre = "temperature / pressure disturbance for 7 days";
		String titre_x = "Days";
		String titre_y = "temperature";

		XYDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createXYLineChart(titre, titre_x, titre_y, dataset);
		return new ChartPanel(chart);
	}

	/**
	 * Create a dataset which contains all the stuff
	 */
	protected XYDataset createDataset() 
	{
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries day1 = new XYSeries("Day-3");
		XYSeries day2 = new XYSeries("Day-2");
		XYSeries day3 = new XYSeries("Day-1");
		XYSeries day4 = new XYSeries("Today");
		XYSeries day5 = new XYSeries("Today+1");
		XYSeries day6 = new XYSeries("Today+2");
		XYSeries day7 = new XYSeries("Today+3");

		day1.add(1, 25);
		day2.add(2, 27);
		day3.add(3, 17);
		day4.add(4, 21);
		day5.add(5, 24);
		day6.add(6, 28);
		day7.add(7, 39);

		dataset.addSeries(day1);
		dataset.addSeries(day2);
		dataset.addSeries(day3);
		dataset.addSeries(day4);
		dataset.addSeries(day5);
		dataset.addSeries(day6);
		dataset.addSeries(day7);

		// dataset.addSeries(candidat5);
		return dataset;
	}

	/**
	 * Initialize the panel 
	 */
	public void run() 
	{
		chartPanel = createChartPanel();

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
		
		maxAvgTempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		maxTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minAvgTempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		HotestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		hotestDayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		coldestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		coldestDayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelGlobal.add(panelCenter, BorderLayout.CENTER);
		panelGlobal.add(panelSouth, BorderLayout.SOUTH);

		// PanelNorth's Construction
		panelNorth.setLayout(g1);
		runingDaysIcone.setIcon(iconRain);
		sunnyDaysIcone.setIcon(iconSun);
		panelNorth.add(runingDaysIcone);
		panelNorth.add(sunnyDaysIcone);
		panelNorth.add(countRuningDays);
		panelNorth.add(countSunnygDays);
		
		runingDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		sunnyDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countRuningDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countSunnygDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		// setLayout for panelCenter's panels
		panelCenter.setLayout(g);
		panelDay_3.setLayout(g2);
		panelDay_2.setLayout(g2);
		panelDay_1.setLayout(g2);
		panelDay.setLayout(g2);
		panelNextDay1.setLayout(g2);
		panelNextDay2.setLayout(g2);
		panelNextDay3.setLayout(g2);

		//set background today
		panelDay.setBackground(background);
		
		// panelCenter's Construction

		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("EEEE, d MMM yyyy");
		
		// panel 3 days ago
		panelDay_3.setBackground(Color.lightGray);
		long threeDaysAgo = today.getTime()-(3*1000*60*60*24);
		JLabel date6 = new JLabel(formater.format(threeDaysAgo));
		panelDay_3.add(date6);
		temperatureIcone1.setIcon(icontemp1);
		panelDay_3.add(temperatureIcone1);
		panelDay_3.add(temperature1);
		panelDay_3.add(windIcone);
		panelDay_3.add(windSpeed1);
		panelDay_3.add(windDirection1);

		// panel 2 days ago
		long twoDaysAgo = today.getTime()-(2*1000*60*60*24);
		JLabel date5 = new JLabel(formater.format(twoDaysAgo));
		panelDay_2.add(date5);
		temperatureIcone2.setIcon(icontemp2);
		panelDay_2.add(temperatureIcone2);
		panelDay_2.add(temperature2);

		panelDay_2.add(windIcone);
		panelDay_2.add(windSpeed2);
		panelDay_2.add(windDirection2);

		// panel 1 day ago
		long oneDayAgo = today.getTime()-(1000*60*60*24);
		JLabel date4 = new JLabel(formater.format(oneDayAgo));
		panelDay_1.add(date4);
		temperatureIcone3.setIcon(icontemp3);
		panelDay_1.add(temperatureIcone3);
		panelDay_1.add(temperature3);

		panelDay_1.add(windIcone);
		panelDay_1.add(windSpeed3);
		panelDay_1.add(windDirection3);

		// panel of the day
		JLabel date = new JLabel(formater.format(today));
		panelDay.add(date);
		temperatureIcone4.setIcon(icontemp4);
		panelDay.add(temperatureIcone4);
		panelDay.add(temperature4);

		panelDay.add(windIcone);
		panelDay.add(windSpeed4);
		panelDay.add(windDirection4);

		// panel of the next day
		long nextDay = today.getTime()+(1000*60*60*24);
		JLabel date1 = new JLabel(formater.format(nextDay));
		panelNextDay1.add(date1);
		temperatureIcone5.setIcon(icontemp5);
		panelNextDay1.add(temperatureIcone5);
		panelNextDay1.add(temperature5);

		panelNextDay1.add(windIcone);
		panelNextDay1.add(windSpeed5);
		panelNextDay1.add(windDirection5);

		// panel 2 days after
		long twoDaysAfter = today.getTime()+(2*1000*60*60*24);
		JLabel date2 = new JLabel(formater.format(twoDaysAfter));
		panelNextDay2.add(date2);
		temperatureIcone6.setIcon(icontemp6);
		panelNextDay2.add(temperatureIcone6);
		panelNextDay2.add(temperature6);

		panelNextDay2.add(windIcone);
		panelNextDay2.add(windSpeed6);
		panelNextDay2.add(windDirection1);

		// panel 3 days after
		long threeDaysAfter = today.getTime()+(3*1000*60*60*24);
		JLabel date3 = new JLabel(formater.format(threeDaysAfter));
		panelNextDay3.add(date3);
		temperatureIcone7.setIcon(icontemp7);
		panelNextDay3.add(temperatureIcone7);
		panelNextDay3.add(temperature7);

		panelNextDay3.add(windIcone);
		panelNextDay3.add(windSpeed7);
		panelNextDay3.add(windDirection7);
		
		date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

		panelSouth1.add(hotestDayLabel);
		panelSouth1.add(HotestDay);
		
		panelSouth2.setLayout(g5);
		panelSouth2.add(coldestDayLabel);
		panelSouth2.add(coldestDay);
		
		panelSouth3.setLayout(g5);
		panelSouth3.add(maxAvgTempLabel);
		panelSouth3.add(maxTemperatureAverage);
		
		panelSouth4.setLayout(g5);
		panelSouth4.add(minAvgTempLabel);
		panelSouth4.add(minTemperatureAverage);
		

		panelSouth.add(panelSouth1);
		panelSouth.add(panelSouth2);
		panelSouth.add(panelSouth3);
		panelSouth.add(panelSouth4);

		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		//
		// panelSouth.add(new JLabel(" Hotest day of the year"));
		// panelSouth.add(new JLabel(" Coldest day of the year"));
		// panelSouth.add(empty);
		//
		// panelSouth.add(new JLabel(" Average "));
		// panelSouth.add(new JLabel(" Average "));
		//
		// panelSouth.add(HotestDay);
		// panelSouth.add(coldestDay);
		// panelSouth.add(empty);
		// panelSouth.add(empty);
		// panelSouth.add(maxTemperatureAverage);
		// panelSouth.add(minTemperatureAverage);

		// construction of the graphic panel

		// add panels to (this)
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

}
