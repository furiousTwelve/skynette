package main.presentation;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
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


/**
 * Sets the main window of the application that will manage the interaction of the panels
 * @author Khadidja
 * @author Audric
 *
 */

public class FenetrePrincipale extends JFrame implements MouseListener {


	private PanelIcon icon = new PanelIcon();

	private PanelDetails f = new PanelDetails();
	DatasForIcon datas = new DatasForIcon();
	
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
	        

	}
	 
	public static void main(String[] args) throws SQLException, IOException {

		FenetrePrincipale fenetre = new FenetrePrincipale();
		
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
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.icon){
			f = new PanelDetails();
			this.getContentPane().removeAll();
			this.setSize(new Dimension(2000, 1000));
			this.setLocationRelativeTo(null);
			f.addMouseListener(this);
			this.setContentPane(f);
			this.validate();
		}
		if(e.getSource() == this.f){
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
