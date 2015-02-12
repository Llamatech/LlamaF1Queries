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

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.Dimension;

public class F1CircuitPositions extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public F1CircuitPositions() {
		setSize(new Dimension(286, 170));
		setMaximumSize(new Dimension(286, 170));
		setMinimumSize(new Dimension(286, 170));
		setBorder(new TitledBorder(null, "Posiciones ", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 21, 264, 137);
		add(table);

	}

}
