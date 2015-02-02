package com.llama.tech.f1.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JComboBox;

public class F1DriverInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public F1DriverInfoPanel() {
		setBorder(new TitledBorder(null, "Informaci\u00F3n Piloto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(24, 24, 141, 156);
		add(lblNewLabel);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Estad\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(24, 261, 464, 95);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 192, 465, 68);
		add(panel_1);
		panel_1.setLayout(new MigLayout("", "[64px][90.00px,grow][72.00][grow]", "[19px][grow]"));
		
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
		
		JLabel lblNewLabel_9 = new JLabel("Estado Final:");
		panel_1.add(lblNewLabel_9, "cell 0 1,alignx trailing");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		panel_1.add(textField_8, "cell 1 1,alignx left");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo Estadísticas:");
		panel_1.add(lblNewLabel_10, "cell 2 1,alignx right");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 3 1,growx");

	}
}
