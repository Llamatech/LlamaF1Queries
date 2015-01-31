/*
 * F1MainGUI.java
 * This file is part of F1ChampionshipQueries
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * JFlow
 * Created by Tim De Pauw <http://pwnt.be/>
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.pwnt.jflow.Configuration;
import be.pwnt.jflow.JFlowPanel;
import be.pwnt.jflow.Shape;
import be.pwnt.jflow.shape.Picture;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;

public class F1MainGUI extends JFrame 
{

	private JPanel contentPane;
	private JFlowPanel flowPanel;
	private F1CircuitInfoPanel f1CircuitInfoPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F1MainGUI frame = new F1MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public F1MainGUI() 
	{
		setTitle("Llamatech's F1 Board");
		setPreferredSize(new Dimension(1200, 800));
		setMinimumSize(new Dimension(1200, 800));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 449);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(674, 600));
		contentPane.setMinimumSize(new Dimension(674, 600));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Path dir = Paths.get("./data/img/");
		File[] files = new File[9];
		int i = 0;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.jpg")) 
		{
		    for (Path file : stream) 
		    {
		    	System.out.println(file.toString());
		        files[i] = file.toAbsolutePath().toFile();
		        i++;
		    }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.png")) 
//		{
//		    for (Path file : stream) 
//		    {
//		    	System.out.println(file.toString());
//		        files[i] = file.toAbsolutePath().toFile();
//		        i++;
//		    }
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			flowPanel = new JFlowPanel(new Config(files));
			flowPanel.setLocation(0, 0);
			flowPanel.setForeground(Color.BLACK);
			flowPanel.setMaximumSize(new Dimension(674, 300));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.setLayout(null);
		flowPanel.setSize(new Dimension(643, 200));
		flowPanel.setPreferredSize(new Dimension(674, 200));
		flowPanel.setMinimumSize(new Dimension(674, 200));
		contentPane.add(flowPanel);
		
		JPanel racePanel = new JPanel();
		racePanel.setBounds(0, 200, 643, 542);
		contentPane.add(racePanel);
		racePanel.setLayout(null);
		
		f1CircuitInfoPanel = new F1CircuitInfoPanel();
		f1CircuitInfoPanel.setBounds(12, 12, 332, 215);
		racePanel.add(f1CircuitInfoPanel);
		
		F1CircuitPositions f1CircuitPositions = new F1CircuitPositions();
		f1CircuitPositions.setBounds(345, 12, 297, 215);
		racePanel.add(f1CircuitPositions);
		
		F1ConstructorInfo f1ConstructorInfo = new F1ConstructorInfo();
		f1ConstructorInfo.setBounds(12, 232, 630, 298);
		racePanel.add(f1ConstructorInfo);
		flowPanel.revalidate();
	}
	
	
	private class Config extends Configuration 
	{
		public Config(File[] files) throws IOException 
		{
			shapes = new Shape[files.length];
//			int num = 0;
//			for(File f: files)
//			{
//				if(f != null)
//				{
//					num++;
//				}
//			}
			//shapes = new Shape[num];
			for (int i = 0; i < shapes.length; i++) 
			{
//			    if (files[i] != null)
//			    {
				    shapes[i] = new Picture(ImageIO.read(files[i]));
			    //}
			}

		}
	}
}
