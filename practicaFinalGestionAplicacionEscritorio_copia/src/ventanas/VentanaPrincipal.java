package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelRegistroCliente;
import paneles.PanelRegistroEventos;
import paneles.PanelListadoEventos;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	// Paneles de la ventana
	private PanelRegistroCliente panelRegistroCliente = new PanelRegistroCliente();
	private PanelListadoClientes panelListadoClientes = new PanelListadoClientes();
	private PanelRegistroEventos panelRegistroEventos = new PanelRegistroEventos();
	private PanelListadoEventos panelListadoEventos = new PanelListadoEventos();
	// Barra de menú
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuEventos = new JMenu("Eventos");
	private JMenu menuAyuda = new JMenu("Ayuda");
	
	
	public VentanaPrincipal() {
		// Preparar la barra de menú - Añadimos el menu a la barra
		barraMenu.add(menuClientes); 
		barraMenu.add(menuEventos); 
		barraMenu.add(menuAyuda);
		this.setJMenuBar(barraMenu); // Añadimos la barra de menu
		
		// Items Menu Clientes
		JMenuItem clientesInsertar = new JMenuItem("Insertar cliente");
		JMenuItem clientesListar = new JMenuItem("Listar clientes");
		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		
		//Items Menu Eventos
		JMenuItem eventosInsertar = new JMenuItem("Insertar evento");
		JMenuItem eventosListar = new JMenuItem("Listar eventos");
		menuEventos.add(eventosInsertar);
		menuEventos.add(eventosListar);
		
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		eventosInsertar.addActionListener(this);
		eventosListar.addActionListener(this);
		
		// Preparación de la ventana principal
		this.setSize(800, 600);
		this.setLocation(100, 100);
		//this.pack(); // Sólo tiene los menus
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		// Vamos a decir que cuando arranque esta ventana se muestre el panel registro cliente
		//this.add(panelRegistroCliente); // Esto funciona pero mejor setContentPane porque todo va dentro del panel
		this.setContentPane(panelRegistroCliente);
		this.setVisible(true);
	} // End constructor
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Atiendo a: " + e.getActionCommand());
		// equals compara cadenas de texto
		if(e.getActionCommand().equals("Insertar cliente")){
			setContentPane(panelRegistroCliente);
		} else if (e.getActionCommand().equals("Listar clientes")) {
			setContentPane(panelListadoClientes);
			panelListadoClientes.refrescarClientes();
		} else if (e.getActionCommand().equals("Insertar evento")) {
			setContentPane(panelRegistroEventos);
		} else if (e.getActionCommand().equals("Listar eventos")) {
			setContentPane(panelListadoEventos);
			panelListadoEventos.refrescarEventos();
		} // End if e.getActionCommand()
		// Hay que refrescar todos los componentes
		// Esto se hace con updateComponentTree
		SwingUtilities.updateComponentTreeUI(this);
	}
	
} // End class
