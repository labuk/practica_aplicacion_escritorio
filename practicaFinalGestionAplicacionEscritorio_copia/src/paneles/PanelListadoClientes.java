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
import ventanas.VentanaEmergente;
import ventanas.VentanaPrincipal;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel implements ActionListener {

	// Los List son muy fáciles de transformar un array con la funcion toArray
	// La idea es dejar Cliente como array fijo porque no queremos que se modifique
	// el tamaño al ser de tamaño fijo de lo que obtenemos de la base de datos
	private Cliente[] clientes;
	// Para poder utilizar múltiples implementaciones de la misma clase ClientesDAO no creamos una instancia de ClientesDAOImpl
	// Esta instancia se podría definir de forma más global para no tener que crear una por clase
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	JTable tabla;
	JButton botonBorrar = new JButton("Borrar");
	JButton botonEditar = new JButton("Editar");
	// Ventana emergent
	VentanaEmergente ventanaEmergente = new VentanaEmergente(this);
	
	public PanelListadoClientes() {
		this.add(new JLabel("Panel Listado de Clientes"));

		// Estaba definido en refrescarClientes()
		// Al llamar múltiples veces a esta función en para pintar, se añadían mñultiples listener y producía errores
		botonBorrar.addActionListener(this);
		botonEditar.addActionListener(this);
		
	} // End PanelListadoClientes()
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(750, 200));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		// Quito todo lo que tuviera antes dentro de el panel
		removeAll();
		// Al añadir un scroll pane
		//this.add(tabla);
		// TODO Mirar para que salga en dos columnas
		//this.add(new JLabel("Panel Listado de CLientes"));
		this.add(scrollPane);
		this.add(botonBorrar);
		this.add(botonEditar);
		
		// Para refrescar el panel de listado hay que forzar el refresco
		// OJO!! Cuidado con los Listener que los duplica
		SwingUtilities.updateComponentTreeUI(this);
	} // End refrescarClientes

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Borrar")) {
			// Soluciona el error en caso de que no se selecciona una fila como si pulso el botón repetidas ocasiones
			if(tabla.getSelectedRow() == -1){
				// Aunque la función no devuelve nada, puedes llamar a return directamente para decir que finaliza
				return;
			}
        	int dialogResult = JOptionPane.showConfirmDialog(null, "Quieres borrar la fila: " + clientes[tabla.getSelectedRow()].toString());
        	System.out.println(dialogResult);
        	// 0 = Si, 1 = No, 2 = Cancel
        	if(dialogResult == 0){
				daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
				this.refrescarClientes();
        	}
		} else if (e.getActionCommand().equals("Editar")){
			// Soluciona el error en caso de que no se selecciona una fila como si pulso el botón repetidas ocasiones
			if(tabla.getSelectedRow() == -1){
				// Aunque la función no devuelve nada, puedes llamar a return directamente para decir que finaliza
				return;
			}
			//Únicamente una ventana emergente
			if(ventanaEmergente.windowActive){
				JOptionPane.showMessageDialog(null, "Ya tienes una ventana modificar abierta");
			} else {
				// Añadimos el panel Actualizo cliente con los datos del cliente seleccionado
				ventanaEmergente.addPanelActualizoCliente(clientes[tabla.getSelectedRow()].getId());
			}
			
		}

	}


} // End class
