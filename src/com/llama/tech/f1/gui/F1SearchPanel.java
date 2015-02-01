package com.llama.tech.f1.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
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
import javax.swing.JButton;

public class F1SearchPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JCalendar cal1;
	

	/**
	 * Create the panel.
	 */
	public F1SearchPanel() {
		setBorder(new TitledBorder(null, "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Año Actual (Consulta):");
		lblNewLabel.setBounds(50, 40, 183, 15);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 35, 158, 24);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Piloto:");
		lblNewLabel_1.setBounds(50, 78, 70, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(243, 74, 158, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(243, 110, 158, 24);
		add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Circuito:");
		lblNewLabel_2.setBounds(50, 114, 70, 15);
		add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("¿Búsqueda por periodo?");
		chckbxNewCheckBox.setBounds(50, 147, 237, 23);
		add(chckbxNewCheckBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Per\u00EDodo de B\u00FAsqueda", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel.setBounds(50, 178, 361, 79);
		add(panel);
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
		
		JDateChooser dateChooser = new JDateChooser();
		panel.add(dateChooser, "6, 2, fill, top");
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		panel.add(lblFechaFinal, "2, 4, left, center");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		panel.add(dateChooser_1, "6, 4, fill, top");
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(50, 276, 117, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(294, 276, 117, 25);
		add(btnNewButton_1);

	}
}
