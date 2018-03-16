package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel {

	// Los List son muy fáciles de transformar un array con la funcion toArray
	// La idea es dejar Cliente como array fijo porque no queremos que se modifique
	// el tamaño al ser de tamaño fijo de lo que obtenemos de la base de datos
	private Cliente[] clientes;
	// Para poder utilizar múltiples implementaciones de la misma clase ClientesDAO no creamos una instancia de ClientesDAOImpl
	// Esta instancia se podría definir de forma más global para no tener que crear una por clase
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	
	public PanelListadoClientes() {
		this.add(new JLabel("Panel Listado de Clientes"));
	} // End PanelListadoClientes()
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		// Quito todo lo que tuviera antes dentro de el panel
		removeAll();
		// Al añadir un scroll pane
		//this.add(tabla);
		// TODO Mirar para que salga en dos columnas
		//this.add(new JLabel("Panel Listado de CLientes"));
		this.add(scrollPane);
	} // End refrescarClientes

} // End class
