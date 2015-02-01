package com.llama.tech.f1.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class F1SearchPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public F1SearchPanel() {
		setBorder(new TitledBorder(null, "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Año Actual (Consulta):");
		lblNewLabel.setBounds(50, 40, 183, 15);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 35, 158, 24);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Piloto:");
		lblNewLabel_1.setBounds(50, 76, 70, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(243, 74, 114, 19);
		add(textField);
		textField.setColumns(10);

	}
}
