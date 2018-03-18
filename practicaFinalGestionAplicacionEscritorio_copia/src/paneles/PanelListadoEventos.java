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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import tableModels.TableModelEventos;
import utils.JTableCellRenderer;
import daos.EventosDAO;
import daos.EventosDAOImpl;
import modelo.Evento;

public class PanelListadoEventos extends JPanel implements ListSelectionListener{

	private Evento[] eventos;
	private EventosDAO daoEventos = new EventosDAOImpl();
	JTable tabla = new JTable();
	//JButton botonBorrar = new JButton("Borrar");
	
	
	public PanelListadoEventos() {
		this.add(new JLabel("Panel Listado de Eventos"));
	}
	
	public void refrescarEventos(){
		this.eventos = daoEventos.obtenerEventos();
		tabla = new JTable(new TableModelEventos(eventos));
		tabla.setPreferredScrollableViewportSize(new Dimension(750, 300));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		removeAll();
		
		// Añadimos elementos al panel
		this.add(scrollPane);

		// Renderizamos la celda de la tabla como botón
		JTableCellRenderer botonBorrar = new JTableCellRenderer();
		tabla.getColumn("Borrar").setCellRenderer(botonBorrar);
		// Añadimos un Listerner al click en la celda
		tabla.getSelectionModel().addListSelectionListener(this);
		// Para refrescar el panel de listado hay que forzar el refresco
		SwingUtilities.updateComponentTreeUI(this);
	}// End refrescarEventos
	

	// Listener de click en la celda
	public void valueChanged(ListSelectionEvent e) {
		// Sino salta dos veces el evento
        if (e.getValueIsAdjusting()) {
            return;
        }
        int row = tabla.getSelectedRow();
        // Al deseleccionar la fila al final de la función, salta el evento valueChanged
        if(row == -1){
        	return;
        }
        int column = tabla.getSelectedColumn();
        // Deselecciona la fila para permitir múltiples clicks en la misma fila
        // También evita problemas al utilizar las flechas
        tabla.clearSelection();
        System.out.println("Fila: " + row + " - Columna: " + column );
        
        // Último botón es borrar
        if (column == tabla.getColumnCount()-1){
        	System.out.println("Borrar columna");
        	int dialogResult = JOptionPane.showConfirmDialog(null, "Quieres borrar la fila: " + eventos[row].toString());
        	System.out.println(dialogResult);
        	// 0 = Si, 1 = No, 2 = Cancel
        	if(dialogResult == 0){
	    		daoEventos.borrarEvento(eventos[row].getId());
	    		this.refrescarEventos();
        	}
        }
	} // End valueChanged
}
