package ventanas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import paneles.PanelActualizoCliente;
import paneles.PanelListadoClientes;

public class VentanaEmergente extends JFrame implements WindowListener{

	// Paneles de la ventana
	private PanelActualizoCliente panelActualizoCliente;
	public boolean windowActive = false;
	PanelListadoClientes panelListadoClientes;
	
	public VentanaEmergente(PanelListadoClientes p) {
		// Preparación de la ventana emergente
		this.setSize(500, 500);
		this.setLocation(300, 300);
		//this.pack(); // Sólo tiene los menus
		// No añado setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) porque sino al cerrar la ventana se acaba la app
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		this.setVisible(false);
		panelListadoClientes = p;
	} // End VentanaEmergente()
	
	public void addPanelActualizoCliente(int id){
		this.windowActive = true;
		panelActualizoCliente = new PanelActualizoCliente(id);
		this.setContentPane(panelActualizoCliente);
		setVisible(true);
		//Refresco clientes
		panelListadoClientes.refrescarClientes();
	} // End addPanelActualizoCliente

	public void windowActivated(WindowEvent arg0) {}

	public void windowClosed(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		System.out.println(windowActive);
        System.out.println("Closed ventanaEmergente");
        this.windowActive = false;
        panelActualizoCliente = null;
        System.out.println(windowActive);
        panelListadoClientes.refrescarClientes();
	}

	public void windowDeactivated(WindowEvent arg0) {}

	public void windowDeiconified(WindowEvent arg0) {}

	public void windowIconified(WindowEvent arg0) {}

	public void windowOpened(WindowEvent arg0) {
	}
	
} // End Class
