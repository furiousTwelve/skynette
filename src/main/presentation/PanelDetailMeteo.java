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
import java.util.Date;
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
 *         days, lets' start!
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

	protected ArrayList<PanelMeteo> listPanel = new ArrayList<>();
	protected PanelMeteo panelDay_3 = new PanelMeteo();
	protected PanelMeteo panelDay_2 = new PanelMeteo();
	protected PanelMeteo panelDay_1 = new PanelMeteo();
	protected PanelMeteo panelDay = new PanelMeteo();
	protected PanelMeteo panelNextDay1 = new PanelMeteo();
	protected PanelMeteo panelNextDay2 = new PanelMeteo();
	protected PanelMeteo panelNextDay3 = new PanelMeteo();

	// DOOOM
	protected Image img;

	protected PanelsSouth panelSouth1 = new PanelsSouth();
	protected PanelsSouth panelSouth2 = new PanelsSouth();
	protected PanelsSouth panelSouth3 = new PanelsSouth();
	protected PanelsSouth panelSouth4 = new PanelsSouth();

	protected JPanel chartPanel = new JPanel();
	protected JLabel ville = new JLabel(" Montpellier town - France ");

	protected JLabel rainingDayIcon = new JLabel();

	ImageIcon iconRain = new ImageIcon(
			new ImageIcon("./icon_weather/rain-1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

	protected JLabel countRainingDays = new JLabel("43 Days");

	// protected JLabel empty = new JLabel();
	protected JLabel sunnyDaysIcone = new JLabel();

	ImageIcon iconSun = new ImageIcon(
			new ImageIcon("./icon_weather/sun.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countSunnyDays = new JLabel(" 322 Days ");
	protected JLabel empty = new JLabel();
	
	ImageIcon iconWind = new ImageIcon(
			new ImageIcon("./icon_weather/wind.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			
	protected JLabel HotestDay = new JLabel(" 39°");
	protected JLabel coldestDay = new JLabel(" 2°");


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

	BorderLayout b = new BorderLayout(30,30);

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
		XYSeries hum = new XYSeries(" humidity ");

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

		hum.add(1, 7);
		hum.add(2, 16);
		hum.add(3, 15);
		hum.add(4, 19);
		hum.add(5, 13);
		hum.add(6, 10);
		hum.add(7, 5);

		dataset.addSeries(hum);
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
		 * "SELECT temerature, pression from nomTable where date = todate" ;to
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

	// this methode will print date on each panelMeteo

	public void showDate() {
		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("yyyy mm dd");

		int j = -3;
		int i = 0;
		long calcul = 1000 * 60 * 60 * 24;

		for (i = 0; i < 7; i++) {
			listPanel.get(i).date.setText(formater.format(today.getTime() + (j * calcul)));
			j++;
		}

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

		// BAckground

		img = Toolkit.getDefaultToolkit().createImage("./icon_weather/sky.jpg");

		// center the label in the rows of the gridlayout

		rainingDayIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		ville.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		sunnyDaysIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countRainingDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		countSunnyDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		font = new Font("Arial", Font.BOLD, 36);
		ville.setFont(font);

		entete.add(ville);
		entete.setBackground(Color.WHITE);
		chartPanel = createChartPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));

		panelCenter.setBackground(Color.WHITE);

		this.setBackground(Color.WHITE);

		// this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		panelNorth.setBackground(new Color(1f, 1f, 1f, 0.7f));
		panelSouth.setOpaque(false);
		panelGlobal.setOpaque(false);
		panelCenter.setOpaque(false);
		chartPanel.setBackground(new Color(1f, 1f, 1f, 0.7f));
		panelGlobal.setLayout(b);

		// PanelNorth's Construction
		panelNorth.setLayout(g1);
		rainingDayIcon.setIcon(iconRain);
		sunnyDaysIcone.setIcon(iconSun);
		panelNorth.add(rainingDayIcon);
		panelNorth.add(ville);
		panelNorth.add(sunnyDaysIcone);
		countRainingDays.setFont(new Font("Arial", Font.BOLD, 20));
		panelNorth.add(countRainingDays);
		panelNorth.add(empty);
		countSunnyDays.setFont(new Font("Arial", Font.BOLD, 20));
		panelNorth.add(countSunnyDays);
		g.setHgap(1200);

		// setLayout for panelCenter's panels
		panelCenter.setLayout(g);

		panelDay.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));

		// panelCenter's Construction

		entete.setPreferredSize(new java.awt.Dimension(900, 50));

		panelCenter.add(panelDay_3);
		panelCenter.add(panelDay_2);
		panelCenter.add(panelDay_1);
		panelCenter.add(panelDay);
		panelCenter.add(panelNextDay1);
		panelCenter.add(panelNextDay2);
		panelCenter.add(panelNextDay3);

		showDate();
		// space between columns,
		g.setHgap(50);
		g1.setHgap(50);

		// panelSouth's Construction
		panelSouth1.infLabel.setText(" The Hotest day of the year");
		panelSouth1.tempLabel.setText("41°");

		panelSouth2.infLabel.setText(" The coldest day of the year");
		panelSouth2.tempLabel.setText("2°");

		panelSouth3.infLabel.setText("Max temperatures' average");
		panelSouth3.tempLabel.setText("15°");

		panelSouth4.infLabel.setText("Min temperatures' average");
		panelSouth4.tempLabel.setText("3°");

		panelSouth.setLayout(g4);
		g4.setHgap(50);
		panelSouth.add(panelSouth1);
		panelSouth.add(panelSouth2);
		panelSouth.add(panelSouth3);
		panelSouth.add(panelSouth4);

		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelGlobal.add(panelCenter, BorderLayout.CENTER);
		panelGlobal.add(panelSouth, BorderLayout.SOUTH);
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 300));

		this.add(panelGlobal);
		this.add(chartPanel);
		this.setBackground(Color.WHITE);


    	countRainingDays.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
			countRainingDays.setText(" Total number of rainy days in the year" );
			
			countRainingDays.setForeground(Color.BLUE);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
	 
			countRainingDays.setText(" 43 Days" );
			countRainingDays.setFont(new Font("Arial", Font.BOLD, 20));
			countRainingDays.setForeground(Color.BLACK);
}
	});
	countSunnyDays.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
			countSunnyDays.setText(" Total number of sunny days in the year" );
			countSunnyDays.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
	 
			countSunnyDays.setText(" 322 Days" );
			countSunnyDays.setFont(new Font("Arial", Font.BOLD, 20));
			countSunnyDays.setForeground(Color.BLACK);
}
	});
}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

}
