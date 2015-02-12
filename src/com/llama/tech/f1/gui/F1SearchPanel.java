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
import javax.swing.text.DateFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.llama.tech.f1.backbone.Carrera;
import com.llama.tech.f1.backbone.F1;
import com.llama.tech.f1.backbone.IF1;
import com.llama.tech.utils.list.Lista;

import javax.swing.JButton;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class F1SearchPanel extends JFrame implements ActionListener, ItemListener
{
	
	public enum SearchType
	{
		NONE,
		CARRERAS,
		ESCUDERIAS,
		PILOTOS
	}
	
	private final static String ELIMINAR = "Eliminar";
	private final static String CONSULTAR = "Consultar"; 
	
	private SearchType search = SearchType.NONE;
	private JTextField textField_1;
    private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox;
	private JButton btnNewButton;
	private F1MainGUI principal;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton_1;	
	
	private boolean historical = false;
	private JLabel lblNewLabel_2;


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
		ItemChangeListener icl = new ItemChangeListener();
		comboBox.addItemListener(icl);
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

		lblNewLabel_2 = new JLabel("(Seleccione el tipo)");
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
		comboBox_1.addItemListener(icl);
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
		public void itemStateChanged(ItemEvent event) 
		{
			System.out.println((String) event.getItem());
			
			if(event.getSource().equals(comboBox))
			{
				if (event.getStateChange() == ItemEvent.SELECTED) 
				{
					String item = (String) event.getItem(); //→ Año
					if(item!=null)
						principal.realizarConsulta(Integer.parseInt(item));
				}
			}
			else if(event.getSource().equals(comboBox_1))
			{
				if(event.getStateChange() == ItemEvent.SELECTED)
				{
					String item = (String) event.getItem();
					if(item != null)
					{
						if(item.equals("Carreras"))
						{
							search = SearchType.CARRERAS;
							lblNewLabel_2.setText("Nombre Carrera:");
							btnNewButton.setEnabled(false);
							btnNewButton_1.setEnabled(true);
							textField_1.setEditable(true);
							textField_1.setEnabled(true);
						}
						else if(item.equals("Escuderias"))
						{
							search = SearchType.ESCUDERIAS;
							lblNewLabel_2.setText("Nombre Escudería:");
							btnNewButton_1.setEnabled(false);
							btnNewButton.setEnabled(true);
							textField_1.setEditable(true);
							textField_1.setEnabled(true);
						}
						else if(item.equals("Pilotos"))
						{
							search = SearchType.PILOTOS;
							lblNewLabel_2.setText("Apellido Piloto:");
							btnNewButton_1.setEnabled(true);
							btnNewButton.setEnabled(true);
							textField_1.setEditable(true);
							textField_1.setEnabled(true);
						}
					}
				}
				else if(event.getStateChange() == ItemEvent.DESELECTED)
				{
					lblNewLabel_2.setText("(Seleccione el tipo)");
				}
			}
		}       
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(CONSULTAR))
		{
			if(historical)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				if(dateChooser.getDate() == null || dateChooser_1.getDate() == null)
				{
					JOptionPane.showMessageDialog(this, "Debe ingresar una fecha de inicio y/o de final válidas", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					if(dateChooser.getDate().compareTo(dateChooser_1.getDate()) < 0)
					{
						String initial_date = sdf.format(dateChooser.getDate());
						String final_date = sdf.format(dateChooser_1.getDate());
						principal.historicalQuery(initial_date, final_date);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser previa a la final", "Error", JOptionPane.ERROR_MESSAGE);
					}
					//System.out.println(date);
				}
			}
			else
			{
				String criterion = textField_1.getText();
				if(criterion.length() > 0)
				{
					principal.buscar(criterion, search, false);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Debe ingresar un criterio de Búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(e.getActionCommand().equals(ELIMINAR))
		{
			String criterion = textField_1.getText();
			if(criterion.length() > 0)
			{
				principal.buscar(criterion, search, true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Debe ingresar un criterio de eliminación", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
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
			historical = true;
			dateChooser.setEnabled(true);
			dateChooser_1.setEnabled(true);
			comboBox.setEnabled(false);
			comboBox_1.setEnabled(false);
			textField_1.setEditable(false);
			btnNewButton_1.setEnabled(false);
		}
		else
		{
			historical = false;
			dateChooser.setEnabled(false);
			dateChooser_1.setEnabled(false);
			comboBox.setEnabled(true);
			comboBox_1.setEnabled(true);
			textField_1.setEditable(true);
			btnNewButton_1.setEnabled(true);
		}
		
	}

	public void displayResults(Lista<Carrera> listaCarrerasH) 
	{
	     new F1HistoricalCircuitFrame(this, listaCarrerasH);
	}
}
