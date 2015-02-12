/*
 * F1ConstructorInfo.java
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.llama.tech.f1.backbone.Escuderia;

public class F1ConstructorInfo extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImage;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblPas;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblPuntos;
	private JTextField textField_3;
	private JScrollPane scrollPane;
	private JButton btnSiguiente;
	private F1MainGUI principal;
	private JButton btnAnterior;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);

	/**
	 * Create the panel.
	 */
	public F1ConstructorInfo(F1MainGUI v) 
	{
		setPreferredSize(new Dimension(640, 322));
		setMaximumSize(new Dimension(640, 322));
		setMinimumSize(new Dimension(640, 322));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		principal = v;
		setTitle("Informaci\u00F3n Escuder\u00EDa");
		
		try 
		{
			setIconImage(ImageIO.read(new File(F1MainGUI.IMG_ROOT+"constructors/default.png")));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
		}
		
		
		//setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informaci\u00F3n Escuder\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		getContentPane().setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setBorder(new TitledBorder(null, "Logo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblImage.setBounds(27, 148, 245, 109);
		getContentPane().add(lblImage);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(216, 40, 70, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(341, 36, 265, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPas = new JLabel("País:");
		lblPas.setBounds(216, 67, 70, 15);
		getContentPane().add(lblPas);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(341, 63, 265, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Posición final:");
		lblNewLabel_2.setBounds(216, 94, 107, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(341, 90, 265, 19);
		getContentPane().add(textField_2);
		
		lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(216, 121, 107, 15);
		getContentPane().add(lblPuntos);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(341, 117, 265, 19);
		getContentPane().add(textField_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Pilotos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		scrollPane.setBounds(290, 148, 316, 109);
		getContentPane().add(scrollPane);
		
		//list = new JList<Piloto>();
		list.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 36, 146, 92);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSiguiente = new JButton("\u2192");
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.addActionListener(this);
		btnSiguiente.setBounds(17, 55, 117, 25);
		panel.add(btnSiguiente);
		
		btnAnterior = new JButton("\u2190");
		btnAnterior.setActionCommand("ANTERIOR");
		btnAnterior.addActionListener(this);
		btnAnterior.setBounds(17, 12, 117, 25);
		panel.add(btnAnterior);

	}
	
	public void cambiarInfo(Escuderia escuderia)
	{
		textField.setText(escuderia.getNombre());
		textField_1.setText(escuderia.getPais());
		textField_2.setText(escuderia.getPosFinal()+"");
		textField_3.setText(escuderia.getPuntos()+"");
		
		
		BufferedImage img = null;
		try {
			System.out.println(escuderia.getUrlLogo());
		    img = ImageIO.read(new File(escuderia.getUrlLogo()));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
		        Image.SCALE_SMOOTH);
////		textField_8
	    ImageIcon imageIcon = new ImageIcon(dimg);
		lblImage.setIcon(imageIcon);
		
		listModel.clear();
		for(int i = 0; i < escuderia.getPilotos().size(); i++)
		{
		      listModel.addElement(escuderia.getPilotos().get(i));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ANTERIOR"))
			principal.darAnterior("Escuderia");
		else if(e.getActionCommand().equals("SIGUIENTE"))
			principal.darSiguiente("Escuderia");
		
	}
	
	@Override
	public void dispose()
	{
		principal.setConstructorsInfo(false);
		this.setVisible(false);
	}
	

}
