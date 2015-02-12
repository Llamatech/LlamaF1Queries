package com.llama.tech.f1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.llama.tech.f1.backbone.Carrera;
import com.llama.tech.utils.list.Lista;

public class F1HistoricalCircuitFrame extends JDialog 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultListModel<Carrera> listModel = new DefaultListModel<Carrera>();
	private JList<Carrera> list = new JList<Carrera>(listModel);

	private F1SearchPanel main;

	/**
	 * Create the dialog.
	 */
	public F1HistoricalCircuitFrame(F1SearchPanel main)
	{
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.main = main;
		setTitle("Informaci\u00F3n de Circuitos (Hist\u00F3rico)");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 210, 430, 42);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setBounds(137, 12, 153, 23);
				cancelButton.setActionCommand("Cerrar");
				buttonPane.add(cancelButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 12, 406, 188);
			contentPanel.add(scrollPane);
			{
				list.setBorder(new TitledBorder(null, "Compendio de Resultados Hist\u00F3ricos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				list.setBackground(UIManager.getColor("Button.background"));
				scrollPane.setViewportView(list);
			}
		}
	}
	
	
	public void updateList(Lista<Carrera> l)
	{
		for(int i = 0; i < l.size(); i++)
		{
			listModel.addElement(l.get(i));
		}
	}
}
