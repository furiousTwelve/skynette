package main.presentation;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Panel qui s'affiche en bas à droite de l'écran au lancement de l'application avec un résumé de la météo
 * @author Audric
 *
 */

public class panelIcone extends JFrame {

	
	private JLabel imageDescription;
	private JLabel temp;
	private JLabel directionVent;
	private JLabel vitesseVent;
	private Font font;
	private panelDetail panDetail; 
	
	public panelIcone(){
		
		font = new Font("Arial",Font.BOLD,20);
		
		//Constitution du panel avec l'image
		ImageIcon meteo = new ImageIcon("cloudy.png");
		Image img = meteo.getImage();
		Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newmeteo = new ImageIcon(newimg);
		imageDescription = new JLabel(newmeteo);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new FlowLayout());
		panelDescription.add(imageDescription);

		
		//Constitution du panel avec la température
		temp = new JLabel("20°C");
		temp.setFont(font);

		
		JPanel panelTemp = new JPanel();
		panelTemp.setLayout(new FlowLayout());
		panelTemp.add(temp);
		
		//Constitution du panel avec la direction du vent
		directionVent = new JLabel("NE");
		directionVent.setFont(font);
		
		JPanel panelDirVent = new JPanel();
		panelDirVent.setLayout(new FlowLayout());
		panelDirVent.add(directionVent);
		
		//Constitution du panel avec la vitesse du vent
		vitesseVent = new JLabel("50km/h");
		vitesseVent.setFont(font);
		
		JPanel panelVitVent = new JPanel();
		panelVitVent.setLayout(new FlowLayout());
		panelVitVent.add(vitesseVent);
		
		//Constitution du panelCentral
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		panelCentral.add(panelDescription);
		panelCentral.add(panelTemp);
		panelCentral.add(panelDirVent);
		panelCentral.add(panelVitVent);
		panelCentral.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelIcone.this.getContentPane().removeAll();
				panDetail = new panelDetail();
				panelIcone.this.setContentPane(panDetail);
				panelIcone.this.validate();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//Constitution du panel général
		this.setLayout(new BorderLayout());
		this.add(panelCentral, BorderLayout.CENTER);
		this.setSize(new Dimension(150, 300));
		int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int y = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		this.setLocation(x-150, y-300);
		this.setUndecorated(true);
		this.setVisible(true);
		
	}
	
}