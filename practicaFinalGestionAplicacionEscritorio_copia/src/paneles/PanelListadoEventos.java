package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import tableModels.TableModelsEventos;
import daos.EventosDAO;
import daos.EventosDAOImpl;
import modelo.Evento;

public class PanelListadoEventos extends JPanel implements ActionListener{

	private Evento[] eventos;
	private EventosDAO daoEventos = new EventosDAOImpl();
	JTable tabla = new JTable();
	JButton botonBorrar = new JButton("Borrar");
	
	
	public PanelListadoEventos() {
		this.add(new JLabel("Panel Listado de Eventos"));
	}
	
	public void refrescarEventos(){
		this.eventos = daoEventos.obtenerEventos();
		tabla = new JTable(new TableModelsEventos(eventos));
		tabla.setPreferredScrollableViewportSize(new Dimension(750, 300));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		removeAll();
		
		// Añadimos elemntos al panel
		this.add(scrollPane);
		this.add(botonBorrar);
		// Añadimos 
		botonBorrar.addActionListener(this);
		// Para refrescar el panel de listado hay que forzar el refresco
		SwingUtilities.updateComponentTreeUI(this);
	}// End refrescarEventos

	public void actionPerformed(ActionEvent e) {
		if(tabla.getSelectedRow() == -1){
			// Aunque la función no devuelve nada, puedes llamar a return directamente para decir que finaliza
			return;
		}
		JOptionPane.showMessageDialog(null, "Borrar:" + eventos[tabla.getSelectedRow()].toString());
		daoEventos.borrarEvento(eventos[tabla.getSelectedRow()].getId());
		this.refrescarEventos();
	}
}
