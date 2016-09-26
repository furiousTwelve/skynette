package main.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.jdbc.Blob;

import main.controller.DatasForIcon;
import main.controller.Tools;
import main.controller.UpdateWindows;
import main.controller.dataTransfer;
import main.data.SQLite;
import main.data.mySQL;

/**
 * Sets the main window of the application that will manage the interaction of
 * the panels
 * 
 * @author Khadidja
 * @author Audric
<<<<<<< HEAD
 * 
=======
>>>>>>> origin/features/data/benjamin4
 */

public class FenetrePrincipale extends JFrame implements MouseListener {
	/* *************************** VARIABLES ********************** */
	private PanelIcon icon = new PanelIcon();

	private PanelDetailMeteo fenetre = new PanelDetailMeteo();
	DatasForIcon datas = new DatasForIcon();
	Color backcolor = new Color(1f, 0f, 0f, 0f);
	UpdateWindows updatewindows;

	
	// Data for the second timer that updates the widget
	public int secondPassed=6;
	public int secondTotal=secondPassed;
	private PanelDetailMeteo  f = new PanelDetailMeteo ();
	private Countdown count = new Countdown(2);


	// A effacer
	public int minuteAff = 0;
	public int secondeAff = 0;
	String secondeAffS = "";


	/**
<<<<<<< HEAD
<<<<<<< HEAD
	 * constructor which defines size elements and start countdown
=======
	 * Constructor which defines size elements and start countdown
	 * @author Khadidja
	 * @author Audric
>>>>>>> origin/features/data/benjamin4
	 */
	

	 /*constructor which defines size elements and start countdown
	 */	

	public FenetrePrincipale()
	{
		this.setSize(new Dimension(150, 300));
		int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		this.setLocation(x - 150, y - 300);
		this.setUndecorated(true);
		this.getAccessibleContext();

		this.setIconImage(new ImageIcon("./icon_weather/planet-earth.png").getImage().getScaledInstance(90, 90,
				Image.SCALE_DEFAULT));
		this.setTitle("Skynette");
		icon.addMouseListener(this);
		this.setContentPane(icon);
		this.setVisible(true);
		setOpacity(0.98f);
		this.setBackground(backcolor);

//		count.start();
//		// Timer actualisation icone
//		Timer timerIcon = new Timer();
//		timerIcon.scheduleAtFixedRate(tache, 1000, 1000);

	}

	/**
	 * Main part
	 * 
	 * @param args
	 * @author Khadidja
	 * @author Audric
	 */

	public static void main(String[] args) throws SQLException, IOException {

		FenetrePrincipale fenetre = new FenetrePrincipale();
		SQLite database = new SQLite();
		database.verifyDB();
		
		// Pour test Cyril
		mySQL BigDatabase = new mySQL();
		BigDatabase.Connexion();

	}



	public static ImageIcon imageConvert(Blob imageDb) throws SQLException, IOException {

		System.out.println(imageDb);
		ImageIcon iconeImage = null;
		File fichierTemp = new File("c:/imgtemp.png");
		// File fichierTemp2 = new File();
		String str = "imgtemp";
		File fichierTemp2 = fichierTemp.createTempFile(str, "png", new File("c:/"));
		byte[] imgData = null;
		BufferedImage bImageFromConvert = null;
		if (imageDb != null) {
			System.out.println("salut 2");
			imgData = imageDb.getBytes(1, (int) imageDb.length());
			InputStream in = new ByteArrayInputStream(imgData);
			try {
				System.out.println("salut 3");
				bImageFromConvert = ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "png", fichierTemp2);
				iconeImage = new ImageIcon(fichierTemp2.getPath());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("salut 4");
			iconeImage = new ImageIcon("JobJob.png");
		}

		boolean effacer = fichierTemp2.delete();
		System.out.println(effacer);
		return iconeImage;


	}





	/**
	 * Event which detects mouse clicked and launch the big window OR come back
	 * to icon window
	 * 
	 */

/**
 * Event which detects mouse clicked and launch the big window OR come back to icon window
 * @author Khadidja
 * @author Audric
 */
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == this.icon) {
			fenetre = new PanelDetailMeteo();


			this.getContentPane().removeAll();
			// Define size window based on user's screen size
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setSize(screenSize);
			this.setLocationRelativeTo(null);
			fenetre.addMouseListener(this);



			// Mise à jour des paramètres de la fenêtre détail *******************************************************************************
			dataTransfer data = new dataTransfer();
			data = data.dataFromSQLite();

//			for (int i = 0; i < data.getSevenRecordsTab().length; i++) {
//				
//				// setting the new weather icon
//				ImageIcon imageIconWeather = new ImageIcon(); 
//				try {
//					imageIconWeather = Tools.imageConvert(data.getSevenRecordsTab()[i].getLogoWeather());
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.fenetre.listPanel.get(i).weatherDaysIcone.setIcon(imageIconWeather);
//				
//				// setting the new temperature
//				this.fenetre.listPanel.get(i).temperature.setText(String.valueOf(data.getSevenRecordsTab()[i].getTemp()));
//				
//				// setting the new wind direction
//				this.fenetre.listPanel.get(i).windDirection.setText(data.getSevenRecordsTab()[i].getWindDirection());
//				
//				// setting the new wind-speed
//				this.fenetre.listPanel.get(i).windSpeed.setText(String.valueOf(data.getSevenRecordsTab()[i].getSpeed()));
//				
//				// setting the new date for the whole data of the panel
//				this.fenetre.listPanel.get(i).date.setText(data.getSevenRecordsTab()[i].getDateDay().toString());
//			}
			
			for (int i = 0; i < data.getListRecords().size(); i++) {
				
				// setting the new weather icon
				ImageIcon imageIconWeather = new ImageIcon(); 
				try {
					imageIconWeather = Tools.imageConvert(data.getListRecords().get(i).getLogoWeather());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.fenetre.listPanel.get(i).weatherDaysIcone.setIcon(imageIconWeather);
				
				// setting the new temperature
				this.fenetre.listPanel.get(i).temperature.setText(String.valueOf(data.getListRecords().get(i).getTemp()));
				
				// setting the new wind direction
				this.fenetre.listPanel.get(i).windDirection.setText(data.getListRecords().get(i).getWindDirection());
				
				// setting the new wind-speed
				this.fenetre.listPanel.get(i).windSpeed.setText(String.valueOf(data.getListRecords().get(i).getSpeed()));
				
				// setting the new date for the whole data of the panel
				this.fenetre.listPanel.get(i).date.setText(data.getListRecords().get(i).getDateDay().toString());
			}
			

			
			// code à reinsérer quand la couche SQLLITE est terminé 
//			data = data.dataFromSQLite();
//
//			for (int i = 0; i < data.getSevenRecordsTab().length; i++) {
//				
//				// setting the new weather icon
//				ImageIcon imageIconWeather = new ImageIcon(); 
//				try {
//					imageIconWeather = Tools.imageConvert(data.getSevenRecordsTab()[i].getLogoWeather());
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.fenetre.listPanel.get(i).weatherDaysIcone.setIcon(imageIconWeather);
//				
//				// setting the new temperature
//				this.fenetre.listPanel.get(i).temperature.setText(String.valueOf(data.getSevenRecordsTab()[i].getTemp()));
//				
//				// setting the new wind direction
//				this.fenetre.listPanel.get(i).windDirection.setText(data.getSevenRecordsTab()[i].getWindDirection());
//				
//				// setting the new wind-speed
//				this.fenetre.listPanel.get(i).windSpeed.setText(String.valueOf(data.getSevenRecordsTab()[i].getSpeed()));
//				
//				// setting the new date for the whole data of the panel
//				this.fenetre.listPanel.get(i).date.setText(data.getSevenRecordsTab()[i].getDateDay().toString());
//			}
//
			this.setContentPane(fenetre);
			this.validate();
		}

		// the state is : I aM big window and I want to be small to display only
		// an icon
		if (e.getSource() == this.fenetre) {
			icon = new PanelIcon();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x - 150, y - 300);
			icon.addMouseListener(this);
			this.setContentPane(icon);
			this.validate();
		}
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	


	public TimerTask tache = new TimerTask() {
		/**
		 * Decrements the seconds left in second Countdown for icon update. When
		 * countdown finished,icons will be update
		 * 
		 * @author Anais & Cyril
		 */
		PanelIcon panIcon;
		@Override
		public void run() {
			updatewindows = new UpdateWindows();
			if (secondPassed <= 0) {
				secondPassed = secondTotal;
				
				try {
					updatewindows.updateIcon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					panIcon.setImageDescription((JLabel) updatewindows.updateIcon().logoWeather);
					updatewindows.updateIcon();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				secondPassed--;
				displayRemainingTime(secondPassed);
			}
		}
	};

	// A effacer
	public String displayRemainingTime(int sec) {
		String remainingTime = "";
		secondeAff = (sec % 60);
		minuteAff = (sec - secondeAff) / 60;
		if (secondeAff < 10) {
			secondeAffS = "0" + secondeAff;
			remainingTime = minuteAff + ":" + secondeAffS;
			System.out.println("Timer icon" + minuteAff + ":" + secondeAffS);
		}
		return remainingTime;
	}

}
