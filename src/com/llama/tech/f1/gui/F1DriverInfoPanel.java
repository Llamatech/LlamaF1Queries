/*
 * F1DriverInfoPanel.java
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

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.llama.tech.f1.backbone.Piloto;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dimension;

public class F1DriverInfoPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private F1MainGUI principal;
	private JLabel lblImage;
	private JTextField textField_8;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_9;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_11;
	private JTextField textField_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel lblTiempoTotal;

	/**
	 * Create the panel.
	 */
	public F1DriverInfoPanel(F1MainGUI v) {
		setPreferredSize(new Dimension(510, 385));
		setMaximumSize(new Dimension(510, 367));
		setMinimumSize(new Dimension(510, 367));
		principal = v;
		setBorder(new TitledBorder(null, "Informaci\u00F3n Piloto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblImage.setBounds(24, 24, 141, 156);
		add(lblImage);
		
		JPanel panel = new JPanel();
		panel.setBounds(183, 24, 305, 156);
		add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel.add(lblNewLabel_1, "2, 2, left, default");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel.add(textField_2, "4, 2, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nacionalidad:");
		panel.add(lblNewLabel_2, "2, 4, left, default");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Nacimiento:");
		panel.add(lblNewLabel_3, "2, 6, left, default");
		
		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField, "4, 6, fill, fill");
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Escudería:");
		panel.add(lblNewLabel_4, "2, 8, left, default");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		panel.add(textField_3, "4, 8, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Puntos:");
		panel.add(lblNewLabel_5, "2, 10, left, default");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		panel.add(textField_4, "4, 10, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Posición Final:");
		panel.add(lblNewLabel_6, "2, 12, left, default");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel.add(textField_5, "4, 12, fill, default");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n Carrera Actual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(23, 192, 465, 134);
		add(panel_1);
		panel_1.setLayout(new MigLayout("", "[99.00px][122.00px,grow][72.00][grow]", "[19px][][][][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("Posición:");
		panel_1.add(lblNewLabel_7, "cell 0 0,alignx left,aligny center");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		panel_1.add(textField_6, "cell 1 0,alignx left,aligny top");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Puntos:");
		panel_1.add(lblNewLabel_8, "cell 2 0,alignx left");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		panel_1.add(textField_7, "cell 3 0,alignx left");
		textField_7.setColumns(10);
		
		lblNewLabel = new JLabel("Estado Final:");
		panel_1.add(lblNewLabel, "cell 0 1,alignx left");
		
		textField_8 = new JTextField();
		panel_1.add(textField_8, "cell 1 1,alignx left");
		textField_8.setColumns(10);
		
		lblTiempoTotal = new JLabel("Tiempo Total:");
		panel_1.add(lblTiempoTotal, "cell 2 1,alignx trailing");
		
		textField_10 = new JTextField();
		panel_1.add(textField_10, "cell 3 1,growx");
		textField_10.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Vueltas:");
		panel_1.add(lblNewLabel_9, "cell 0 2,alignx left");
		
		textField_9 = new JTextField();
		panel_1.add(textField_9, "cell 1 2,alignx left");
		textField_9.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Velocidad:");
		panel_1.add(lblNewLabel_11, "cell 2 2,alignx left");
		
		textField_11 = new JTextField();
		panel_1.add(textField_11, "cell 3 2,growx");
		textField_11.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Más rápida:");
		panel_1.add(lblNewLabel_12, "cell 0 3,alignx left");
		
		textField_12 = new JTextField();
		panel_1.add(textField_12, "cell 1 3,alignx left");
		textField_12.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Tiempo:");
		panel_1.add(lblNewLabel_13, "cell 2 3,alignx left");
		
		textField_13 = new JTextField();
		panel_1.add(textField_13, "cell 3 3,growx");
		textField_13.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 338, 462, 35);
		add(panel_2);
		panel_2.setLayout(null);
		
		btnAnterior = new JButton("←");
		btnAnterior.setActionCommand("ANTERIOR");
		btnAnterior.addActionListener(this);
		btnAnterior.setBounds(204, 5, 117, 25);
		panel_2.add(btnAnterior);
		
		btnSiguiente = new JButton("→");
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.setBounds(333, 5, 117, 25);
		panel_2.add(btnSiguiente);

	}
	
	public void cambiarInfo(Piloto piloto)
	{
		textField.setText(piloto.getFechaNac());
		textField_1.setText(piloto.getNacionalidad());
		textField_2.setText(piloto.getNombre()+" "+piloto.getApellido());
		textField_3.setText(piloto.getEscuderia());
		textField_4.setText(piloto.getPuntos()+"");
		textField_5.setText(piloto.getPosFinal()+"");
//		textField_7
		textField_6.setText(piloto.getPosicion()+"");
		
		BufferedImage img = null;
		try {
			System.out.println(piloto.getUrlImagen());
		    img = ImageIO.read(new File(piloto.getUrlImagen()));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
		        Image.SCALE_SMOOTH);
////		textField_8
	    ImageIcon imageIcon = new ImageIcon(dimg);
		lblImage.setIcon(imageIcon);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ANTERIOR"))
			principal.darAnterior("Piloto");
		else if(e.getActionCommand().equals("SIGUIENTE"))
			principal.darSiguiente("Piloto");
			
		
	}
}
