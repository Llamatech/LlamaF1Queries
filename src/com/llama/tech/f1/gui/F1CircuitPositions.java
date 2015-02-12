/*
 * F1CircuitPositions.java
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

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.llama.tech.f1.backbone.Carrera;
import com.llama.tech.f1.backbone.Piloto;
import com.llama.tech.utils.list.Lista;

public class F1CircuitPositions extends JPanel implements ListSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private F1MainGUI main;
	private DefaultListModel<Piloto> listModel = new DefaultListModel<Piloto>();
	private JList<Piloto> list = new JList<Piloto>(listModel);

	/**
	 * Create the panel.
	 */
	public F1CircuitPositions(F1MainGUI main) 
	{
		this.main = main;
		setSize(new Dimension(284, 170));
		setMaximumSize(new Dimension(286, 170));
		setMinimumSize(new Dimension(286, 170));
		setBorder(new TitledBorder(null, "Posiciones ", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 24, 262, 134);
		add(scrollPane);
		
		//list = new JList<Piloto>();
		list.addListSelectionListener(this);
		list.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(list);

	}

	
	public void setListInfo(Carrera carrera)
	{
		listModel.clear();
		Lista<Piloto> l = carrera.getPilotos();
		//Piloto[] lm = new Piloto[l.size()];
		for(int i = 0; i < l.size(); i++)
		{
			listModel.addElement(l.get(i));
		}
		//listModel.clear();
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		Piloto p = list.getSelectedValue();
		main.refreshDriverInfo(p);
		
	}
	
}
