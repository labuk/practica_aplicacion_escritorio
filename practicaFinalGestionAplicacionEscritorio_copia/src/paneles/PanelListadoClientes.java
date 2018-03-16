package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel implements ActionListener{

	// Los List son muy f�ciles de transformar un array con la funcion toArray
	// La idea es dejar Cliente como array fijo porque no queremos que se modifique
	// el tama�o al ser de tama�o fijo de lo que obtenemos de la base de datos
	private Cliente[] clientes;
	// Para poder utilizar m�ltiples implementaciones de la misma clase ClientesDAO no creamos una instancia de ClientesDAOImpl
	// Esta instancia se podr�a definir de forma m�s global para no tener que crear una por clase
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	JTable tabla;
	JButton botonBorrar = new JButton("Borrar");
	
	public PanelListadoClientes() {
		this.add(new JLabel("Panel Listado de Clientes"));
	} // End PanelListadoClientes()
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(750, 300));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		// Quito todo lo que tuviera antes dentro de el panel
		removeAll();
		// Al a�adir un scroll pane
		//this.add(tabla);
		// TODO Mirar para que salga en dos columnas
		//this.add(new JLabel("Panel Listado de CLientes"));
		this.add(scrollPane);
		this.add(botonBorrar);
		botonBorrar.addActionListener(this);
		// Para refrescar el panel de listado hay que forzar el refresco
		SwingUtilities.updateComponentTreeUI(this);
	} // End refrescarClientes

	public void actionPerformed(ActionEvent arg0) {
		// Soluciona el error en caso de que no se selecciona una fila como si pulso el bot�n repetidas ocasiones
		if(tabla.getSelectedRow() == -1){
			// Aunque la funci�n no devuelve nada, puedes llamar a return directamente para decir que finaliza
			return;
		}
		JOptionPane.showMessageDialog(null, "Borrar: " + clientes[tabla.getSelectedRow()].toString() );
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		this.refrescarClientes();
	}

} // End class
