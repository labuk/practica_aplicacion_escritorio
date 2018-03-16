package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;

public class TableModelClientes extends AbstractTableModel{

	private String[] columnas = {
			"Nombre","Domicilio","Localizacion","Código Postal","Telefono"
	};
	private String[][] datos = null;
	
	public TableModelClientes(Cliente[] clientes) {
		// Datos va a ser tantos arrays de strings como clientes tenga que listar
		// Cada uno de esos arrays deberá tener tantos elementos como queramos mostrar por cada columna
		datos = new String[clientes.length][columnas.length];
		
		// Recorremos el array clientes que ha llegado para rellenar datos[][]
		for (int i = 0; i < clientes.length; i++) {
			Cliente c = clientes[i];
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getDomicilio();
			datos[i][2] = c.getPoblacion();
			datos[i][3] = c.getCodigoPostal();
			datos[i][4] = c.getTelefono();
		} // End for
	} // End TableModelClientes(Cliente[] clientes)
	
	public int getColumnCount() {
		// Lenght es el tamaño para arrays - Para list era size
		return columnas.length;
	}

	public int getRowCount() {
		// Lenght es el tamaño para arrays - Para list era size
		return datos.length;
	}
	
	public String getColumnName(int numeroColumna) {
        return columnas[numeroColumna];
    }

	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}
