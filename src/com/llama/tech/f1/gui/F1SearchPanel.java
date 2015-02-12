/*
 * F1SearchPanel.java
 * This file is part of F1ChampionshipQueries
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * F1ChampionshipQueries is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * F1ChampionshipQueries is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with F1ChampionshipQueries. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.llama.tech.f1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.llama.tech.f1.backbone.F1;
import com.llama.tech.f1.backbone.IF1;
import com.llama.tech.utils.list.Lista;

import javax.swing.JButton;
import java.awt.Dimension;

public class F1SearchPanel extends JFrame implements ActionListener, ItemListener
{
	
	private final static String ELIMINAR = "Eliminar";
	private final static String CONSULTAR = "Consultar"; 
	
	
	private JTextField textField_1;
    private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox;
	private JButton btnNewButton;
	private F1MainGUI principal;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton_1;


	/**
	 * Create the panel.
	 */
	public F1SearchPanel(F1MainGUI v) {
		setPreferredSize(new Dimension(433, 364));
		setMaximumSize(new Dimension(433, 364));
		setMinimumSize(new Dimension(433, 364));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		principal = v;
		//setBorder(new TitledBorder(null, "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setTitle("B\u00FAsqueda");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Año Actual (Consulta):");
		lblNewLabel.setBounds(31, 28, 183, 15);
		getContentPane().add(lblNewLabel);

		String[] temp = principal.darTemporadas();
		comboBox = new JComboBox(temp);
		comboBox.setBounds(224, 23, 158, 24);
		//comboBox.addItemListener(new ItemChangeListener());
		comboBox.setSelectedItem(null);
		getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Búsqueda:");
		lblNewLabel_1.setBounds(31, 66, 158, 15);
		getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(224, 98, 158, 24);
		getContentPane().add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("(Seleccione el tipo)");
		lblNewLabel_2.setBounds(31, 102, 158, 15);
		getContentPane().add(lblNewLabel_2);

		chckbxNewCheckBox = new JCheckBox("¿Búsqueda por periodo?");
		chckbxNewCheckBox.addItemListener(this);
		chckbxNewCheckBox.setBounds(31, 135, 237, 23);
		getContentPane().add(chckbxNewCheckBox);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Per\u00EDodo de B\u00FAsqueda", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel.setBounds(31, 166, 361, 79);
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("92px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("85px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("153px"),
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
				new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblNewLabel_3 = new JLabel("Fecha Inicial:");
		panel.add(lblNewLabel_3, "2, 2, left, center");

		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		panel.add(dateChooser, "6, 2, fill, top");

		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		panel.add(lblFechaFinal, "2, 4, left, center");

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setEnabled(false);
		panel.add(dateChooser_1, "6, 4, fill, top");

		btnNewButton = new JButton("Consultar");
		btnNewButton.setActionCommand(CONSULTAR);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(72, 264, 117, 25);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setActionCommand(ELIMINAR);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(224, 264, 117, 25);
		getContentPane().add(btnNewButton_1);

		String[] tipo = new String[]{"Carreras","Escuderias","Pilotos"};
		comboBox_1 = new JComboBox(tipo);
		comboBox_1.setBounds(224, 61, 158, 24);
		getContentPane().add(comboBox_1);


	}

	public String darTipoBusqueda()
	{
		return (String) comboBox_1.getSelectedItem();
	}

	public String darAnhoBusqueda()
	{
		return (String) comboBox.getSelectedItem();
	}

	//addItemListener(new ItemChangeListener());
	class ItemChangeListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) 
			{
				String item = (String) event.getItem(); //→ Año
				if(item!=null)
					principal.realizarConsulta(Integer.parseInt(item));
			}
		}       
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		

	}
	
	@Override
	public void dispose()
	{
		principal.setSearchPanel(false);
		this.setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(chckbxNewCheckBox.isSelected())
		{
			dateChooser.setEnabled(true);
			dateChooser_1.setEnabled(true);
			comboBox.setEnabled(false);
			comboBox_1.setEnabled(false);
			textField_1.setEditable(false);
			btnNewButton_1.setEnabled(false);
		}
		else
		{
			dateChooser.setEnabled(false);
			dateChooser_1.setEnabled(false);
			comboBox.setEnabled(true);
			comboBox_1.setEnabled(true);
			textField_1.setEditable(true);
			btnNewButton_1.setEnabled(true);
		}
		
	}
}
