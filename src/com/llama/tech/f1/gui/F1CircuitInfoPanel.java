package com.llama.tech.f1.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class F1CircuitInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField roundField;
	private JTextField dateField;
	private JTextField textField_4;
	private JTextField circuitLabel;
	private JTextField locationField;
	private JTextField countryField;

	/**
	 * Create the panel.
	 */
	public F1CircuitInfoPanel() {
		setSize(new Dimension(383, 215));
		setMinimumSize(new Dimension(383, 235));
		setMaximumSize(new Dimension(383, 235));
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informaci\u00F3n Circuito", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(11dlu;default)"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setHorizontalTextPosition(SwingConstants.LEFT);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblName, "4, 2");
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setColumns(10);
		add(nameField, "8, 2, fill, default");
		
		JLabel lblRound = new JLabel("Número:");
		lblRound.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblRound, "4, 4");
		
		roundField = new JTextField();
		roundField.setEditable(false);
		roundField.setColumns(10);
		add(roundField, "8, 4, fill, default");
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblDate, "4, 6");
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setColumns(10);
		add(dateField, "8, 6, fill, default");
		
		JLabel lblHour = new JLabel("Hora:");
		lblHour.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblHour, "4, 8");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		add(textField_4, "8, 8, fill, default");
		
		JLabel lblCircuit = new JLabel("Circuito:");
		lblCircuit.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblCircuit, "4, 10");
		
		circuitLabel = new JTextField();
		circuitLabel.setEditable(false);
		circuitLabel.setColumns(10);
		add(circuitLabel, "8, 10, fill, default");
		
		JLabel lblLocation = new JLabel("Lugar:");
		lblLocation.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblLocation, "4, 12");
		
		locationField = new JTextField();
		locationField.setEditable(false);
		locationField.setColumns(10);
		add(locationField, "8, 12, fill, default");
		
		JLabel lblCountry = new JLabel("País:");
		lblCountry.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblCountry, "4, 14");
		
		countryField = new JTextField();
		countryField.setEditable(false);
		countryField.setColumns(10);
		add(countryField, "8, 14, fill, default");

	}
}
