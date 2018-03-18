package tableModels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modelo.Evento;

public class TableModelEventos extends AbstractTableModel {

	private String[] columnas = {
			"titulo", "descripcion", "localizacion", "organizador", "tipo", "fecha", "importante", "Borrar"
	};
	private Object[][] datos = null;
	
	public TableModelEventos(Evento[] eventos) {
		datos = new Object[eventos.length][columnas.length];
		for (int i = 0; i < eventos.length; i++) {
			Evento e = eventos[i];
			e.toString();
			datos[i][0] = e.getTitulo();
			datos[i][1] = e.getDescripcion();
			datos[i][2] = e.getLocalizacion();
			datos[i][3] = e.getOrganizador();
			datos[i][4] = e.getTipo();
			datos[i][5] = e.getFecha();
			// Es un boolean - Para que acepte todo tipo de datos de la sql mejor definir un objeto
			if(e.getImportante()){
				datos[i][6] = "Si";
			} else{
				datos[i][6] = "No";
			}
			
		} // End for
	} // End TableModelsEventos(Evento[] eventos)
	
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.length;
	}
	
	public String getColumnName(int numeroColumna) {
        return columnas[numeroColumna];
    }

	// 
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public Object getValueAt(int indiceFila, int indiceColumna) {
		// Boton borrar
		if(indiceColumna == columnas.length-1){
			JButton botonBorrar = new JButton("Borrar");
			botonBorrar.setActionCommand("Borrar");
			botonBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Se pulso el botón");
				}
			});
//			String botonBorrar = "Borrar";
			return botonBorrar;
		}
		// Valores tabla
		return datos[indiceFila][indiceColumna];
	}

}
