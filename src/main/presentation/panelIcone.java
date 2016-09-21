package main.presentation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelIcone extends JPanel implements ActionListener{
	
	private JLabel imageDescription = null;
	
	public panelIcone(){
		
		JPanel panelCentral = new JPanel();
		
		JLabel imageDescription = new JLabel(new ImageIcon("Logo_Afpa.png"));
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new FlowLayout());
		panelDescription.add(imageDescription);
		
		
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}