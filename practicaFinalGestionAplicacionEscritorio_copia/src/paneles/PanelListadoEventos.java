package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModels.TableModelsEventos;
import daos.EventosDAO;
import daos.EventosDAOImpl;
import modelo.Evento;

public class PanelListadoEventos extends JPanel{

	private Evento[] eventos;
	private EventosDAO daoEventos = new EventosDAOImpl();
	
	public PanelListadoEventos() {
		this.add(new JLabel("Panel Listado de Eventos"));
	}
	
	public void refrescarEventos(){
		this.eventos = daoEventos.obtenerEventos();
		JTable tabla = new JTable(new TableModelsEventos(eventos));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		removeAll();
		
		this.add(scrollPane);
	}// End refrescarEventos
}
