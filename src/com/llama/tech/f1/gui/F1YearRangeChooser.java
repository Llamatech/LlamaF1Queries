package com.llama.tech.f1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class F1YearRangeChooser extends JDialog implements ActionListener
{
	private static final String SEARCH = "Search"; 
	private String min;
	private String max;
	private JComboBox<String> initial_year;
	private JComboBox<String> final_year;
	private F1MainGUI main;

	/**
	 * Create the dialog.
	 * @param f1MainGUI 
	 */
	public F1YearRangeChooser(F1MainGUI f1MainGUI, String[] yearList) 
	{
		super(f1MainGUI, ModalityType.APPLICATION_MODAL);
		main = f1MainGUI;

		setTitle("Por favor, escoja un rango de consulta");
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

		initial_year = new JComboBox<String>(yearList);
		initial_year.setBounds(121, 19, 104, 24);
		panel.add(initial_year);

		final_year = new JComboBox<String>(yearList);
		final_year.setBounds(121, 46, 104, 24);
		panel.add(final_year);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 108, 255, 34);
		getContentPane().add(panel_1);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setActionCommand(SEARCH);
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(SEARCH))
		{
			min = (String) initial_year.getSelectedItem();
			max = (String) final_year.getSelectedItem();
			if(Integer.parseInt(min)>Integer.parseInt(max))
			{
				JOptionPane.showMessageDialog(this, "El año de comienzo no puede ser menor que el año de fin");

			}
			else
			{
				main.setMinMax(min, max);
				this.dispose();
			}

		}

	}





}
