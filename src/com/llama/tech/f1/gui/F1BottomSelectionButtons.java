/*
 * F1BottomSelectionButtons.java
 * This file is part of F1ChampionshipQueries
 *
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
 */

package com.llama.tech.f1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class F1BottomSelectionButtons extends JPanel implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SEARCH = "Search";
	private static final String CONSTRUCTORS = "Constructors";
	
	private F1MainGUI main;
	private JButton constructorsB;
	private JButton searchB;
	private JComboBox<String> seasonsCombo;

	/**
	 * Create the panel.
	 */
	public F1BottomSelectionButtons(F1MainGUI main) 
	{
		setLayout(null);
		this.main = main;
		String[] temp = main.darTemporadas();
		seasonsCombo = new JComboBox<String>(temp);
		seasonsCombo.setBounds(118, 12, 133, 24);
		seasonsCombo.addItemListener(new ItemChangeListener());
		seasonsCombo.setSelectedItem(null);
		add(seasonsCombo);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(12, 12, 88, 24);
		add(lblTemporada);
		
		constructorsB = new JButton("Escuderías");
		constructorsB.setActionCommand(CONSTRUCTORS);
		constructorsB.addActionListener(this);
		constructorsB.setBounds(274, 12, 117, 25);
		add(constructorsB);
		
		searchB = new JButton("Búsqueda");
		searchB.setActionCommand(SEARCH);
		searchB.addActionListener(this);
		searchB.setBounds(403, 12, 117, 25);
		add(searchB);

	}

	public String darAnhoBusqueda()
	{
		return (String) seasonsCombo.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(CONSTRUCTORS))
		{
			main.showConstructorsDialog();
		}
		else if(e.getActionCommand().equals(SEARCH))
		{
			main.showSearchDialog();
		}
	}
	
	class ItemChangeListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) 
			{
				String item = (String) event.getItem(); //→ Año
				if(item!=null)
					main.realizarConsulta(Integer.parseInt(item));
			}
		}       
	}
	
	public void changeSelectedItem(int index)
	{
		seasonsCombo.setSelectedIndex(index);
		main.realizarConsulta(Integer.parseInt(seasonsCombo.getItemAt(index)));
	}
	
	
}
