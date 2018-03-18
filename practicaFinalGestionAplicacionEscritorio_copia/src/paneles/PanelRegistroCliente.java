package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener{

	JTextField campoNombre = new JTextField(18);
	JTextField campoDomicilio = new JTextField(18);
	JTextField campoPoblacion = new JTextField(18);
	JTextField campoCodigoPostal = new JTextField(18);
	JTextField campoTelefono = new JTextField(18);
	
	JButton botonRegistroCliente = new JButton("Guardar");
	
	public PanelRegistroCliente() {		
		// Así asigno un gestor de diseño que me permite colocar las cosas en forma de filas, columnas y celdas
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Padding
		gbc.insets = new Insets(5,10,5,10);  //top padding
		
		// Fila: 0 - Elemento: 0
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2; // Cambia las celdas a 2 columnas
		this.add(new JLabel(this.setPanelTitle()),gbc);
		
		// Fila: 1 - Elemento: 0
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1; // Cambia las celdas a 1 columna
		this.add(new JLabel("Nombre: "),gbc);
		// Fila: 1 - Elemento: 1
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre,gbc);
		
		// Fila: 2 - Elemento: 0
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Domicilio: "),gbc);
		// Fila: 2 - Elemento: 1
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio,gbc);
		
		// Fila: 3 - Elemento: 0
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Población: "),gbc);
		// Fila: 3 - Elemento: 1
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion,gbc);
		
		// Fila: 4 - Elemento: 0
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Código Postal: "),gbc);
		// Fila: 4 - Elemento: 1
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal,gbc);
		
		// Fila: 5 - Elemento: 0
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Teléfono"),gbc);
		// Fila: 5 - Elemento 1
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono,gbc);
		
		// Fila: 6 - Elemento: 0
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		botonRegistroCliente.addActionListener(this);
		this.add(botonRegistroCliente, gbc);
		
	} // End PanelRegistroCliente()

	public String setPanelTitle(){
		return "Introduce los datos del cliente";
	}
	
	private void cleanFormFields(){
		this.campoNombre.setText("");
		this.campoDomicilio.setText("");
		this.campoPoblacion.setText("");
		this.campoCodigoPostal.setText("");
		this.campoTelefono.setText("");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("actionPerformed - botonRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText(); 
		// Ahora habría que validar estos datos
		// TODO Validar datos
		
		// Registramos datos en Base de Datos
		Cliente clienteARegistrar = new Cliente(nombre, domicilio, poblacion, codigoPostal, telefono);
		System.out.println("Voy a registrar: " + clienteARegistrar.toString());
		// Invoco a lo necesario de la capa de datos para registrar el cliente en base de datos
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteARegistrar);
		this.cleanFormFields();
		
	} // End actionPerformed
	
} // End class
