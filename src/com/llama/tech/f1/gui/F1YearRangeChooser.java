package com.llama.tech.f1.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class F1YearRangeChooser extends JDialog 
{
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			F1YearRangeChooser dialog = new F1YearRangeChooser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public F1YearRangeChooser() {
		setBounds(100, 100, 299, 223);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 255, 84);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Año Inicial:");
		lblNewLabel.setBounds(12, 24, 91, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Año Final:");
		lblNewLabel_1.setBounds(12, 51, 70, 15);
		panel.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(121, 19, 104, 24);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(121, 46, 104, 24);
		panel.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 108, 255, 34);
		getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}
}
