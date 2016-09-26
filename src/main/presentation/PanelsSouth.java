package main.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
/**
 * 
 *  
 * @author khadidja
 * @author Damien
 * @author audric
 *
 */
public class PanelsSouth extends JPanel {
	GridLayout g1 = new GridLayout(2, 1);
	protected JLabel infLabel = new JLabel("allez");
	protected JLabel tempLabel = new JLabel("go");

	public PanelsSouth() {
		this.setLayout(g1);
		this.add(infLabel);
		this.add(tempLabel);
		this.setBackground(new Color(1f, 1f, 1f, 0.7f));
		//this.setBackground(Color.WHITE);
		this.setPreferredSize(new java.awt.Dimension(100, 50));
		
		infLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		infLabel.setFont(new Font ("Arial", Font.BOLD, 18));
		tempLabel.setFont(new Font ("Arial", Font.BOLD, 16));
	}

	public JLabel getInfLabel() {
		return infLabel;
	}

	public void setInfLabel(JLabel infLabel) {
		this.infLabel = infLabel;
	}

	public JLabel getTempLabel() {
		return tempLabel;
	}

	public void setTempLabel(JLabel tempLabel) {
		this.tempLabel = tempLabel;
	}
}
