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

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
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

public class F1SearchPanel extends JPanel implements ActionListener {
	private JTextField textField_1;
	private JCalendar cal1;
	
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private F1MainGUI principal;
	

	/**
	 * Create the panel.
	 */
	public F1SearchPanel(F1MainGUI v) {
		

		principal = v;
		setBorder(new TitledBorder(null, "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Año Actual (Consulta):");
		lblNewLabel.setBounds(50, 40, 183, 15);
		add(lblNewLabel);
		
		String[] temp = principal.darTemporadas();
		comboBox = new JComboBox(temp);
		comboBox.setBounds(243, 35, 158, 24);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Búsqueda:");
		lblNewLabel_1.setBounds(50, 78, 158, 15);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(243, 110, 158, 24);
		add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Seleccione el tipo)");
		lblNewLabel_2.setBounds(50, 114, 158, 15);
		add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("¿Búsqueda por periodo?");
		chckbxNewCheckBox.setBounds(50, 147, 237, 23);
		add(chckbxNewCheckBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Per\u00EDodo de B\u00FAsqueda", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel.setBounds(50, 178, 361, 79);
		add(panel);
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
		
		JDateChooser dateChooser = new JDateChooser();
		panel.add(dateChooser, "6, 2, fill, top");
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		panel.add(lblFechaFinal, "2, 4, left, center");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		panel.add(dateChooser_1, "6, 4, fill, top");
		
		btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(50, 276, 117, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(294, 276, 117, 25);
		add(btnNewButton_1);
		
		String[] tipo = new String[]{"Carreras","Escuderias","Pilotos"};
		comboBox_1 = new JComboBox(tipo);
		comboBox_1.setBounds(243, 73, 158, 24);
		add(comboBox_1);
		
	
		
		

	}
	
	public String darTipoBusqueda()
	{
		return (String) comboBox_1.getSelectedItem();
	}
	
	public String darA�oBusqueda()
	{
		return (String) comboBox.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
