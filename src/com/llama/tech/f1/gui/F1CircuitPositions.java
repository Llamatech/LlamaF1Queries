package com.llama.tech.f1.gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class F1CircuitPositions extends JPanel {

	/**
	 * Create the panel.
	 */
	public F1CircuitPositions() {
		setBorder(new TitledBorder(null, "Posiciones ", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrLoremIpsumDolor = new JTextArea();
		txtrLoremIpsumDolor.setEditable(false);
		txtrLoremIpsumDolor.setLineWrap(true);
		txtrLoremIpsumDolor.setForeground(UIManager.getColor("Button.foreground"));
		txtrLoremIpsumDolor.setBackground(UIManager.getColor("CheckBox.background"));
		scrollPane.setViewportView(txtrLoremIpsumDolor);

	}

}
