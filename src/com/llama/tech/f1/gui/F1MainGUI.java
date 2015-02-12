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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.pwnt.jflow.Configuration;
import be.pwnt.jflow.Configuration.VerticalAlignment;
import be.pwnt.jflow.JFlowPanel;
import be.pwnt.jflow.Shape;
import be.pwnt.jflow.event.ShapeEvent;
import be.pwnt.jflow.event.ShapeListener;
import be.pwnt.jflow.shape.Picture;

import com.llama.tech.f1.backbone.Carrera;
import com.llama.tech.f1.backbone.Escuderia;
import com.llama.tech.f1.backbone.F1;
import com.llama.tech.f1.backbone.IF1;
import com.llama.tech.f1.backbone.Piloto;
import com.llama.tech.f1.backbone.Temporada;
import com.llama.tech.f1.gui.F1SearchPanel.SearchType;
import com.llama.tech.f1.query.Query;
import com.llama.tech.utils.list.Lista;

public class F1MainGUI extends JFrame implements ShapeListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String IMG_ROOT = "./data/img/";

	private JPanel contentPane;
	private JFlowPanel flowPanel;
	private F1CircuitInfoPanel f1CircuitInfoPanel;
	private F1SearchPanel f1SearchPanel;
	private F1YearRangeChooser f1YearRangeChooser;
	private IF1 mundo;
	private F1CircuitPositions f1CircuitPositions;
	private F1ConstructorInfo f1ConstructorInfo;
	private F1DriverInfoPanel f1DriverInfoPanel;
	private boolean constructorsWindowAct;
	private boolean searchWindowAct;
	private int min;
	private int max;
	private F1BottomSelectionButtons f1BottomSelectionButtons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F1MainGUI frame = new F1MainGUI();
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					//frame.setExtendedState(MAXIMIZED_BOTH);
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
		constructorsWindowAct = false;
		searchWindowAct = false;
		try 
		{
			mundo = F1.cargarF1();
			if(mundo == null)
			{
				//Aquí va el diálogo
				//min,max = ...
				mundo = new F1();
				String[] yearList = mundo.darTemporadasCompletas();
				f1YearRangeChooser = new F1YearRangeChooser(this, yearList);
				f1YearRangeChooser.setVisible(true);
				f1YearRangeChooser.setAlwaysOnTop(true);
				f1YearRangeChooser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				mundo = new F1(min, max);
				System.out.println(min+":"+max);

			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "Ocurrió un error mientras se cargaban los archivos", "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Llamatech's F1 Board");
		try 
		{
			setIconImage(ImageIO.read(new File(IMG_ROOT+"drivers/default.png")));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 489);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(674, 600));
		contentPane.setMinimumSize(new Dimension(674, 600));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		File f = new File("./data/img/circuits/default.png");
		File[] files = new File[1];
		files[0] = f;



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
			Config c = new Config(files);
			c.backgroundColor = new Color(238,238,238);
			c.activeShapeBorderColor = Color.RED;
			c.verticalShapeAlignment = VerticalAlignment.MIDDLE;
			flowPanel = new JFlowPanel(c);
			flowPanel.setLocation(0, 0);
			flowPanel.setForeground(Color.BLACK);
			flowPanel.setMaximumSize(new Dimension(674, 300));
			flowPanel.addListener(this);
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
		racePanel.setBounds(0, 200, 643, 249);
		contentPane.add(racePanel);
		racePanel.setLayout(null);

		f1CircuitInfoPanel = new F1CircuitInfoPanel();
		f1CircuitInfoPanel.setBounds(12, 12, 332, 215);
		racePanel.add(f1CircuitInfoPanel);

		f1CircuitPositions = new F1CircuitPositions(this);
		f1CircuitPositions.setBounds(345, 12, 286, 170);
		racePanel.add(f1CircuitPositions);

		f1ConstructorInfo = new F1ConstructorInfo(this);
		//f1ConstructorInfo.setBounds(12, 232, 630, 271);
		//racePanel.add(f1ConstructorInfo);

		F1LongestRacePanel f1LongestRacePanel = new F1LongestRacePanel();
		f1LongestRacePanel.setBounds(369, 186, 244, 41);
		racePanel.add(f1LongestRacePanel);

		f1DriverInfoPanel = new F1DriverInfoPanel(this);
		f1DriverInfoPanel.setBounds(655, 12, 513, 376);
		contentPane.add(f1DriverInfoPanel);

		f1BottomSelectionButtons = new F1BottomSelectionButtons(this);
		f1BottomSelectionButtons.setBounds(642, 390, 549, 39);
		contentPane.add(f1BottomSelectionButtons);

		f1SearchPanel = new F1SearchPanel(this);
		//f1SearchPanel.setBounds(680, 398, 458, 306);
		//contentPane.add(f1SearchPanel);
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
			for (int i = shapes.length-1; i >= 0; i--) 
			{
				//			    if (files[i] != null)
				//			    {
				shapes[i] = new Picture(ImageIO.read(files[i]), String.valueOf(i+1));//+";"+files[i].getName().split("[.]")[0]);
				//}
			}

		}
	}


	@Override
	public void shapeActivated(ShapeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shapeClicked(ShapeEvent arg0) 
	{
		MouseEvent me = arg0.getMouseEvent();
		if (!me.isConsumed() && me.getButton() == MouseEvent.BUTTON1
				&& me.getClickCount() == 1) {
			//JOptionPane.showMessageDialog(this,
			//"You clicked on " + arg0.getShape().getShapeName() + ".", "Event Test",
			//JOptionPane.INFORMATION_MESSAGE);
			String anho = f1BottomSelectionButtons.darAnhoBusqueda();
			Temporada temp = mundo.darTemporada(Integer.parseInt(anho));
			f1CircuitInfoPanel.cambiarInfo(temp.getCarreras().get(Integer.parseInt(arg0.getShape().getShapeName())-1));
			f1DriverInfoPanel.cambiarInfo(temp.darPilotoActual(), temp.getCarreras().get(Integer.parseInt(arg0.getShape().getShapeName())-1));
			f1CircuitPositions.setListInfo(temp.getCarreras().get(Integer.parseInt(arg0.getShape().getShapeName())-1));
			
		}

	}
	
	public void refreshDriverInfo(Piloto p)
	{
		int anho = Integer.parseInt(f1BottomSelectionButtons.darAnhoBusqueda());
		Temporada temp = mundo.darTemporada(anho);
		f1DriverInfoPanel.cambiarInfo(p, temp.darCarreraActual());
	}

	@Override
	public void shapeDeactivated(ShapeEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void realizarConsulta(int anho)
	{
		//Temporada temp = mundo.darTemporada(anho);
		Lista<Carrera> infoCarreras = mundo.darCarrerasTemporada(anho);
		f1CircuitInfoPanel.cambiarInfo(mundo.darCarrerasTemporada(anho).get(0));
		f1ConstructorInfo.cambiarInfo(mundo.darEscuderiasTemporada(anho).get(0));
		f1DriverInfoPanel.cambiarInfo(mundo.darPilotosTemporada(anho).get(0), mundo.darCarrerasTemporada(anho).get(0));
		f1CircuitPositions.setListInfo(mundo.darCarrerasTemporada(anho).get(0));
		try
		{
			String[] info = new String[infoCarreras.size()];
			for(int i = 0; i < infoCarreras.size(); i++)
			{
				info[i] = infoCarreras.get(i).getUrlImagen();
			}

			reloadJFlow(info);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	public void reloadJFlow(String[] circuits) throws IOException
	{
		File[] files = new File[circuits.length];
		int i = 0;
		for(String circuit: circuits)
		{
			//String loc = "./data/img/circuits/"+pilot.split(";")[pilot.split(";").length-1];
			System.out.println(circuit);
			files[i] = new File(circuit);
			i++;
		}
		Config config = new Config(files);
		//Config c = config;
		//config.shapeWidth = 0.1;
		config.shapeRotation = Math.PI / 4;
		//config.shapeSpacing = 0.333333333333333333333;
		config.scrollScale = 1.0;
		config.zoomScale = 3.0;
		config.backgroundColor = new Color(238,238,238);
		config.activeShapeBorderColor = Color.RED;
		config.verticalShapeAlignment = VerticalAlignment.MIDDLE;
		flowPanel.setConfig(config);

		flowPanel.setForeground(Color.BLACK);
		flowPanel.updateShapes();
		flowPanel.revalidate();

	}

	public String[] darTemporadas()
	{
		Temporada[] temps = mundo.darTemporadas();
		String[] ret = new String[temps.length];
		for(int i =0; i<temps.length;i++)
		{
			ret[i]=temps[i].getYear()+"";
		}
		return ret;
	}

	public void setMinMax(String min, String max) 
	{
		this.min = Integer.parseInt(min);
		this.max = Integer.parseInt(max);
	}

	public void darAnterior(String tipo)
	{
		if(f1BottomSelectionButtons.darAnhoBusqueda()!=null)
		{
			int anho = Integer.parseInt(f1BottomSelectionButtons.darAnhoBusqueda());
			Temporada temp = mundo.darTemporada(anho);
			if(tipo.equalsIgnoreCase("Carrera"))
			{
				try {
					Carrera carrera = temp.darAnteriorCarrera();
					f1CircuitInfoPanel.cambiarInfo(carrera);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay anterior");
				}

			}
			else if(tipo.equalsIgnoreCase("Piloto"))
			{
				try {
					Piloto piloto = temp.darAnteriorPiloto();
					Carrera carrera = temp.darCarreraActual();
					f1DriverInfoPanel.cambiarInfo(piloto, carrera);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay anterior");
				}

			}
			else if(tipo.equalsIgnoreCase("Escuderia"))
			{
				try {
					Escuderia escuderia = temp.darAnteriorEscuderia();
					f1ConstructorInfo.cambiarInfo(escuderia);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay anterior");
				}

			}
		}
	}

	public void darSiguiente(String tipo)
	{
		if(f1BottomSelectionButtons.darAnhoBusqueda()!=null){
			int anho = Integer.parseInt(f1BottomSelectionButtons.darAnhoBusqueda());
			Temporada temp = mundo.darTemporada(anho);
			if(tipo.equalsIgnoreCase("Carrera"))
			{
				try {
					Carrera carrera = temp.darSiguienteCarrera();
					f1CircuitInfoPanel.cambiarInfo(carrera);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay siguiente");
				}

			}
			else if(tipo.equalsIgnoreCase("Piloto"))
			{
				try {
					Piloto piloto = temp.darSiguientePiloto();
					Carrera carrera = temp.darCarreraActual();
					f1DriverInfoPanel.cambiarInfo(piloto, carrera);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay siguiente");
				}

			}
			else if(tipo.equalsIgnoreCase("Escuderia"))
			{
				try {
					Escuderia escuderia = temp.darSiguienteEscuderia();
					f1ConstructorInfo.cambiarInfo(escuderia);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No hay siguiente");
				}

			}
		}
	}

	@Override
	public void dispose()
	{
		System.out.println("Cerrando...");
		Query.guardar(mundo);
		System.exit(0);
	}

	public void showConstructorsDialog() 
	{
		if(!constructorsWindowAct)
		{
			constructorsWindowAct = true;
			f1ConstructorInfo.setVisible(true);
		}
	}

	public void setConstructorsInfo(boolean b) 
	{
		constructorsWindowAct = b;
	}

	public void showSearchDialog() 
	{
		if(!searchWindowAct)
		{
			searchWindowAct = true;
			f1SearchPanel.setVisible(true);
		}
	}

	public void setSearchPanel(boolean b) 
	{
		searchWindowAct = b;	
	}
	
	public Lista<Piloto> getCurrentRacePilots()
	{
		String anho = f1BottomSelectionButtons.darAnhoBusqueda();
		Temporada temp = mundo.darTemporada(Integer.parseInt(anho));
		return temp.darCarreraActual().getPilotos();
		
	}

	public void historicalQuery(String initial_date, String final_date) 
	{
		try 
		{
			Lista<Carrera> listaCarrerasH = mundo.getHistoricalSeasonInfo(initial_date, final_date);
			f1SearchPanel.displayResults(listaCarrerasH);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void buscar(String argumentoBusqueda, SearchType tipoBusqueda, boolean eliminar)
	{
		if(eliminar)
		{
			if(tipoBusqueda.equals(SearchType.PILOTOS))
			{
				mundo.deletePilotRecord(argumentoBusqueda);
			}
			else if(tipoBusqueda.equals(SearchType.CARRERAS))
			{
				mundo.deleteCircuitRecord(argumentoBusqueda);
			}
			else if(tipoBusqueda.equals(SearchType.ESCUDERIAS))
				JOptionPane.showMessageDialog(this, "No puede borrar escuderías");
		}
		else
		{
			if(tipoBusqueda.equals(SearchType.ESCUDERIAS))
			{
				f1ConstructorInfo.cambiarInfo(mundo.buscarEscuderia(Integer.parseInt(f1SearchPanel.darAnhoBusqueda()), argumentoBusqueda));
			}
			else if(tipoBusqueda.equals(SearchType.PILOTOS))
			{
				f1DriverInfoPanel.cambiarInfo(mundo.buscarPiloto(Integer.parseInt(f1SearchPanel.darAnhoBusqueda()), argumentoBusqueda), mundo.darTemporada(Integer.parseInt(f1BottomSelectionButtons.darAnhoBusqueda())).darCarreraActual());
			}
			else if(tipoBusqueda.equals(SearchType.CARRERAS))
				JOptionPane.showMessageDialog(this, "No puede hacer búsqueda de carreras");
		}
	}
}

