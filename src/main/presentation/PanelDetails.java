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
	protected JPanel panelGlobal = new JPanel(); // panelGlobal contains all the
													// composents

	protected JPanel panelNorth = new JPanel(); // panelNorth situated in the
												// orth of panelGlobal

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
	ImageIcon iconRain = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\rain-1.png")
			.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	protected JLabel countRuningDays = new JLabel("13 jours");

	// protected JLabel empty = new JLabel();

	protected JLabel sunnyDaysIcone = new JLabel();
	ImageIcon iconSun = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png")
			.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

	protected JLabel countSunnygDays = new JLabel("275 jours ");

	protected JLabel empty = new JLabel("       ", 10);

	protected JLabel temperatureIcone1 = new JLabel();
	ImageIcon icontemp1 = new ImageIcon(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png")
			.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	protected JLabel temperatureIcone2 = new JLabel();
	protected JLabel temperatureIcone3 = new JLabel();
	protected JLabel temperatureIcone4 = new JLabel();
	protected JLabel temperatureIcone5 = new JLabel();
	protected JLabel temperatureIcone6 = new JLabel();
	protected JLabel temperatureIcone7 = new JLabel();

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

	// Layout to be used
	GridLayout g = new GridLayout(1, 7);
	GridLayout g1 = new GridLayout(2, 7);
	GridLayout g2 = new GridLayout(4, 1);
	GridLayout g3 = new GridLayout(3, 7);

	BorderLayout b = new BorderLayout();

	public PanelDetails() {
		run();
	}

	public void run() {
		temperature1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		temperature7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		HotestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		coldestDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		maxTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minTemperatureAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
		// panelDay_3.setBackground(Color.CYAN);
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

		// space between columns,
		g.setHgap(50);
		g1.setHgap(50);

		// panelSouth's Construction
		panelSouth.setLayout(g3);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(empty);

		panelSouth.add(new JLabel(" Hotest day of the year"));
		panelSouth.add(new JLabel(" Coldest day of the year"));
		panelSouth.add(empty);

		panelSouth.add(new JLabel(" Average "));
		panelSouth.add(new JLabel(" Average "));

		panelSouth.add(HotestDay);
		panelSouth.add(coldestDay);
		panelSouth.add(empty);
		panelSouth.add(empty);
		panelSouth.add(maxTemperatureAverage);
		panelSouth.add(minTemperatureAverage);

		// construction of the graphic panel

		// add panels to (this)
		this.add(panelGlobal);
		this.add(chartPanel);
	}

	public JPanel getPanelGlobal() {
		return panelGlobal;
	}

	public void setPanelGlobal(JPanel panelGlobal) {
		this.panelGlobal = panelGlobal;
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JPanel getPanelDay_3() {
		return panelDay_3;
	}

	public void setPanelDay_3(JPanel panelDay_3) {
		this.panelDay_3 = panelDay_3;
	}

	public JPanel getPanelDay_2() {
		return panelDay_2;
	}

	public void setPanelDay_2(JPanel panelDay_2) {
		this.panelDay_2 = panelDay_2;
	}

	public JPanel getPanelDay_1() {
		return panelDay_1;
	}

	public void setPanelDay_1(JPanel panelDay_1) {
		this.panelDay_1 = panelDay_1;
	}

	public JPanel getPanelDay() {
		return panelDay;
	}

	public void setPanelDay(JPanel panelDay) {
		this.panelDay = panelDay;
	}

	public JPanel getPanelNextDay1() {
		return panelNextDay1;
	}

	public void setPanelNextDay1(JPanel panelNextDay1) {
		this.panelNextDay1 = panelNextDay1;
	}

	public JPanel getPanelNextDay2() {
		return panelNextDay2;
	}

	public void setPanelNextDay2(JPanel panelNextDay2) {
		this.panelNextDay2 = panelNextDay2;
	}

	public JPanel getPanelNextDay3() {
		return panelNextDay3;
	}

	public void setPanelNextDay3(JPanel panelNextDay3) {
		this.panelNextDay3 = panelNextDay3;
	}

	public JPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(JPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

	public JLabel getRuningDaysIcone() {
		return runingDaysIcone;
	}

	public void setRuningDaysIcone(JLabel runingDaysIcone) {
		this.runingDaysIcone = runingDaysIcone;
	}

	public ImageIcon getIconRain() {
		return iconRain;
	}

	public void setIconRain(ImageIcon iconRain) {
		this.iconRain = iconRain;
	}

	public JLabel getCountRuningDays() {
		return countRuningDays;
	}

	public void setCountRuningDays(JLabel countRuningDays) {
		this.countRuningDays = countRuningDays;
	}

	public JLabel getSunnyDaysIcone() {
		return sunnyDaysIcone;
	}

	public void setSunnyDaysIcone(JLabel sunnyDaysIcone) {
		this.sunnyDaysIcone = sunnyDaysIcone;
	}

	public ImageIcon getIconSun() {
		return iconSun;
	}

	public void setIconSun(ImageIcon iconSun) {
		this.iconSun = iconSun;
	}

	public JLabel getCountSunnygDays() {
		return countSunnygDays;
	}

	public void setCountSunnygDays(JLabel countSunnygDays) {
		this.countSunnygDays = countSunnygDays;
	}

	public JLabel getEmpty() {
		return empty;
	}

	public void setEmpty(JLabel empty) {
		this.empty = empty;
	}

	public JLabel getTemperatureIcone1() {
		return temperatureIcone1;
	}

	public void setTemperatureIcone1(JLabel temperatureIcone1) {
		this.temperatureIcone1 = temperatureIcone1;
	}

	public ImageIcon getIcontemp1() {
		return icontemp1;
	}

	public void setIcontemp1(ImageIcon icontemp1) {
		this.icontemp1 = icontemp1;
	}

	public JLabel getTemperatureIcone2() {
		return temperatureIcone2;
	}

	public void setTemperatureIcone2(JLabel temperatureIcone2) {
		this.temperatureIcone2 = temperatureIcone2;
	}

	public JLabel getTemperatureIcone3() {
		return temperatureIcone3;
	}

	public void setTemperatureIcone3(JLabel temperatureIcone3) {
		this.temperatureIcone3 = temperatureIcone3;
	}

	public JLabel getTemperatureIcone4() {
		return temperatureIcone4;
	}

	public void setTemperatureIcone4(JLabel temperatureIcone4) {
		this.temperatureIcone4 = temperatureIcone4;
	}

	public JLabel getTemperatureIcone5() {
		return temperatureIcone5;
	}

	public void setTemperatureIcone5(JLabel temperatureIcone5) {
		this.temperatureIcone5 = temperatureIcone5;
	}

	public JLabel getTemperatureIcone6() {
		return temperatureIcone6;
	}

	public void setTemperatureIcone6(JLabel temperatureIcone6) {
		this.temperatureIcone6 = temperatureIcone6;
	}

	public JLabel getTemperatureIcone7() {
		return temperatureIcone7;
	}

	public void setTemperatureIcone7(JLabel temperatureIcone7) {
		this.temperatureIcone7 = temperatureIcone7;
	}

	public JLabel getTemperature1() {
		return temperature1;
	}

	public void setTemperature1(JLabel temperature1) {
		this.temperature1 = temperature1;
	}

	public JLabel getTemperature2() {
		return temperature2;
	}

	public void setTemperature2(JLabel temperature2) {
		this.temperature2 = temperature2;
	}

	public JLabel getTemperature3() {
		return temperature3;
	}

	public void setTemperature3(JLabel temperature3) {
		this.temperature3 = temperature3;
	}

	public JLabel getTemperature4() {
		return temperature4;
	}

	public void setTemperature4(JLabel temperature4) {
		this.temperature4 = temperature4;
	}

	public JLabel getTemperature5() {
		return temperature5;
	}

	public void setTemperature5(JLabel temperature5) {
		this.temperature5 = temperature5;
	}

	public JLabel getTemperature6() {
		return temperature6;
	}

	public void setTemperature6(JLabel temperature6) {
		this.temperature6 = temperature6;
	}

	public JLabel getTemperature7() {
		return temperature7;
	}

	public void setTemperature7(JLabel temperature7) {
		this.temperature7 = temperature7;
	}

	public JLabel getHotestDay() {
		return HotestDay;
	}

	public void setHotestDay(JLabel hotestDay) {
		HotestDay = hotestDay;
	}

	public JLabel getColdestDay() {
		return coldestDay;
	}

	public void setColdestDay(JLabel coldestDay) {
		this.coldestDay = coldestDay;
	}

	public JLabel getWindDirection1() {
		return windDirection1;
	}

	public void setWindDirection1(JLabel windDirection1) {
		this.windDirection1 = windDirection1;
	}

	public JLabel getWindSpeed1() {
		return windSpeed1;
	}

	public void setWindSpeed1(JLabel windSpeed1) {
		this.windSpeed1 = windSpeed1;
	}

	public JLabel getWindDirection2() {
		return windDirection2;
	}

	public void setWindDirection2(JLabel windDirection2) {
		this.windDirection2 = windDirection2;
	}

	public JLabel getWindSpeed2() {
		return windSpeed2;
	}

	public void setWindSpeed2(JLabel windSpeed2) {
		this.windSpeed2 = windSpeed2;
	}

	public JLabel getWindDirection3() {
		return windDirection3;
	}

	public void setWindDirection3(JLabel windDirection3) {
		this.windDirection3 = windDirection3;
	}

	public JLabel getWindSpeed3() {
		return windSpeed3;
	}

	public void setWindSpeed3(JLabel windSpeed3) {
		this.windSpeed3 = windSpeed3;
	}

	public JLabel getWindDirection4() {
		return windDirection4;
	}

	public void setWindDirection4(JLabel windDirection4) {
		this.windDirection4 = windDirection4;
	}

	public JLabel getWindSpeed4() {
		return windSpeed4;
	}

	public void setWindSpeed4(JLabel windSpeed4) {
		this.windSpeed4 = windSpeed4;
	}

	public JLabel getWindDirection5() {
		return windDirection5;
	}

	public void setWindDirection5(JLabel windDirection5) {
		this.windDirection5 = windDirection5;
	}

	public JLabel getWindSpeed5() {
		return windSpeed5;
	}

	public void setWindSpeed5(JLabel windSpeed5) {
		this.windSpeed5 = windSpeed5;
	}

	public JLabel getWindDirection6() {
		return windDirection6;
	}

	public void setWindDirection6(JLabel windDirection6) {
		this.windDirection6 = windDirection6;
	}

	public JLabel getWindSpeed6() {
		return windSpeed6;
	}

	public void setWindSpeed6(JLabel windSpeed6) {
		this.windSpeed6 = windSpeed6;
	}

	public JLabel getWindDirection7() {
		return windDirection7;
	}

	public void setWindDirection7(JLabel windDirection7) {
		this.windDirection7 = windDirection7;
	}

	public JLabel getWindSpeed7() {
		return windSpeed7;
	}

	public void setWindSpeed7(JLabel windSpeed7) {
		this.windSpeed7 = windSpeed7;
	}

	public JLabel getWindIcone() {
		return windIcone;
	}

	public void setWindIcone(JLabel windIcone) {
		this.windIcone = windIcone;
	}

	public JLabel getMaxTemperatureAverage() {
		return maxTemperatureAverage;
	}

	public void setMaxTemperatureAverage(JLabel maxTemperatureAverage) {
		this.maxTemperatureAverage = maxTemperatureAverage;
	}

	public JLabel getMinTemperatureAverage() {
		return minTemperatureAverage;
	}

	public void setMinTemperatureAverage(JLabel minTemperatureAverage) {
		this.minTemperatureAverage = minTemperatureAverage;
	}

	public GridLayout getG() {
		return g;
	}

	public void setG(GridLayout g) {
		this.g = g;
	}

	public GridLayout getG1() {
		return g1;
	}

	public void setG1(GridLayout g1) {
		this.g1 = g1;
	}

	public GridLayout getG2() {
		return g2;
	}

	public void setG2(GridLayout g2) {
		this.g2 = g2;
	}

	public GridLayout getG3() {
		return g3;
	}

	public void setG3(GridLayout g3) {
		this.g3 = g3;
	}

	public BorderLayout getB() {
		return b;
	}

	public void setB(BorderLayout b) {
		this.b = b;
	}

}
