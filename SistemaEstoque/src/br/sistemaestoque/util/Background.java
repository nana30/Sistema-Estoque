package br.sistemaestoque.util;

import java.awt.Image;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Background extends JPanel {

	/**
	 * Create the panel.
	 */
	public Background() {

		
		setBounds(100, 100, 1280, 750);
		setLayout(null);
		JButton button = new JButton("");
		button.setIcon( new ImageIcon(getClass().getResource("/br/sistemaestoque/Imgs/principal.jpg")));
		button.setEnabled(false);
		button.setBounds(0, -19, 1280, 729);
		add(button);
		
	}
}
