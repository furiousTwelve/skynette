package main.presentation;


import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import java.awt.Image;
import java.awt.Toolkit;
import main.data.SQLite;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mysql.jdbc.Blob;

import main.controller.DatasForIcon;
import main.data.mySQL;




/**
 * Sets the main window of the application that will manage the interaction of the panels
 * @author Khadidja
 * @author Audric

 */

public class FenetrePrincipale extends JFrame implements MouseListener 
{
	/* *************************** VARIABLES ********************** */
	private PanelIcon icon = new PanelIcon();
	private PanelDetails fenetre = new PanelDetails();
	private Countdown count = new Countdown(8);
	DatasForIcon datas = new DatasForIcon();

	
	/**
	 *  constructor which defines size elements and start countdown
	 */
	
	public  FenetrePrincipale() throws SQLException, IOException{
			
		
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
	    	this.setUndecorated(true);
	        this.getAccessibleContext();

//	        this.setIconImage(new ImageIcon("..\\..\\git\\skynette\\icon_weather\\sun.png").getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
	        this.setIconImage(imageConvert(datas.logoWeather).getImage());
	        this.setTitle("Skynette"); 
	        icon.addMouseListener(this);
	        this.setContentPane(icon);
	        this.setVisible(true);
	        setOpacity(0.95f);
	        
	        count.start();
	}
	 
	/**
	 * Main part
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, IOException {


		FenetrePrincipale fenetre = new FenetrePrincipale();
		SQLite database = new SQLite();
		database.verifyDB();
		// Pour test Cyril
		mySQL BigDatabase = new mySQL();
		BigDatabase.Connexion();

	}


	public static ImageIcon imageConvert(Blob imageDb) throws SQLException, IOException
	{
		System.out.println(imageDb);
		ImageIcon iconeImage = null;
		File fichierTemp = new File("c:/imgtemp.png");
//		File fichierTemp2 = new File();
		String str = "imgtemp";
		File fichierTemp2 = fichierTemp.createTempFile(str, "png", new File("c:/"));
		byte[] imgData = null ;
		BufferedImage bImageFromConvert = null; 
		if(imageDb != null){
			System.out.println("salut 2");
			imgData = imageDb.getBytes(1,(int)imageDb.length());
			InputStream in = new ByteArrayInputStream(imgData);
			try {
				System.out.println("salut 3");
				bImageFromConvert = ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "png", fichierTemp2);
				iconeImage= new ImageIcon(fichierTemp2.getPath());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("salut 4");
			iconeImage =  new ImageIcon("JobJob.png");
		}
		
		boolean effacer = fichierTemp2.delete();
		System.out.println(effacer);
		return iconeImage;


	}

	@Override
	/**
	 * Event which detects mouse clicked and launch the big window OR come back to icon window
	 * 
	 */
	public void mouseClicked(MouseEvent e) 
	{
		// the state is : I am a small icon and I want to be bigger to display all my stuff
		if(e.getSource() == this.icon)
		{
			fenetre = new PanelDetails();
			this.getContentPane().removeAll();
			//Define size window based on user's screen size
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
			this.setSize(screenSize);
			this.setLocationRelativeTo(null);
			fenetre.addMouseListener(this);
			this.setContentPane(fenetre);
			this.validate();
		}
		
		// the state is : I a big window and I want to be small to display only an icon
		if(e.getSource() == this.fenetre)
		{
			icon = new PanelIcon();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(150, 300));
			int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
			int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
			this.setLocation(x-150, y-300);
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
	

}
