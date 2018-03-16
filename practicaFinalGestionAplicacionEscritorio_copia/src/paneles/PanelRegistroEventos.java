package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import daos.EventosDAOImpl;
import modelo.Cliente;
import modelo.Evento;

public class PanelRegistroEventos extends JPanel implements ActionListener{

	// campoTitulo, campoDescripcion, campoLocalizacion, campoOrganizador, campoTipo, campoFecha, campoImportante
	JTextField campoTitulo = new JTextField(18);
	JTextArea campoDescripcion = new JTextArea();
	JTextField campoLocalizacion = new JTextField(18);
	JTextField campoOrganizador = new JTextField(18);
	String[] tipoStrings = { "Fiesta", "Deportivo", "Cultural", "Trabajo", "Reunión" };
	JComboBox campoTipo = new JComboBox(tipoStrings);
	JTextField campoFecha = new JTextField(18);
	JCheckBox campoImportante = new JCheckBox("Importante");
	
	JButton botonRegistroCliente = new JButton("Guardar");
	
	public PanelRegistroEventos() {

		// Así asigno un gestor de diseño que me permite colocar las cosas en forma de filas, columnas y celdas
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Padding
		gbc.insets = new Insets(5,10,5,10);  //Add padding
		
		// Fila: 0 - Elemento: 0
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2; // Cambia las celdas a 2 columnas
		this.add(new JLabel("Introduce los datos del evento"),gbc);
		
		// Fila: 1 - Elemento: 0
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1; // Cambia las celdas a 1 columna
		this.add(new JLabel("Título evento: "),gbc);
		// Fila: 1 - Elemento: 1
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoTitulo,gbc);
		
		// Fila: 2 - Elemento: 0
		gbc.gridy = 2;
		gbc.gridx = 0;
		campoDescripcion.setColumns(18);
		campoDescripcion.setRows(5);
		campoDescripcion.setLineWrap(true);
		this.add(new JLabel("Descripción: "),gbc);
		// Fila: 2 - Elemento: 1
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDescripcion,gbc);
		
		// Fila: 3 - Elemento: 0
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Lugar de celebración: "),gbc);
		// Fila: 3 - Elemento: 1
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoLocalizacion,gbc);
		
		// Fila: 4 - Elemento: 0
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Organizador: "),gbc);
		// Fila: 4 - Elemento: 1
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoOrganizador,gbc);
		
		// Fila: 5 - Elemento: 0
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Tipo de evento"),gbc);
		// Fila: 5 - Elemento 1
		gbc.gridy = 5;
		gbc.gridx = 1;
		//campoTipo.setSelectedIndex(1);
		this.add(campoTipo,gbc);
		
		// Fila: 6 - Elemento: 0
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Fecha"),gbc);
		// Fila: 6 - Elemento 1
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoFecha,gbc);
		
		// Fila: 7 - Elemento: 0
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Importante"),gbc);
		// Fila: 7 - Elemento 1
		gbc.gridy = 7;
		gbc.gridx = 1;
		campoImportante.setSelected(true);
		this.add(campoImportante,gbc);
		
		// Fila: 8 - Elemento: 0
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		botonRegistroCliente.addActionListener(this);
		this.add(botonRegistroCliente, gbc);
		
	} // End PanelRegistroCliente()

	public void actionPerformed(ActionEvent arg0) {
		// campoTitulo, campoDescripcion, campoLocalizacion, campoOrganizador, campoTipo, campoFecha, campoImportante
		System.out.println("actionPerformed - botonRegistroCliente");
		String titulo = campoTitulo.getText();
		String descripcion = campoDescripcion.getText();
		String localizacion = campoLocalizacion.getText();
		String organizador = campoOrganizador.getText();
		String tipo = "" + campoTipo.getSelectedItem(); 
		String fecha = campoFecha.getText(); 
		boolean importante = campoImportante.isSelected();
		// Ahora habría que validar estos datos
		// TODO Validar datos
		
		// Registramos datos en Base de Datos
		Evento eventoARegistrar = new Evento(titulo, descripcion, localizacion, organizador, tipo, fecha, importante);
		System.out.println("Voy a registrar: " + eventoARegistrar.toString());
		// Invoco a lo necesario de la capa de datos para registrar el cliente en base de datos
		EventosDAOImpl eventosDAO = new EventosDAOImpl();
		//eventosDAO.registrarEvento(eventoARegistrar);
		
	} // End actionPerformed
	
} // End class
