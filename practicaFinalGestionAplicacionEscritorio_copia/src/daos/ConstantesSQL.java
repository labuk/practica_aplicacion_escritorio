package daos;

public class ConstantesSQL {
	
	// final hace que la variable no se pueda modificar de ninguna manera
	// 
	final static String sqlInsercionCliente = "INSERT INTO practica_escritorio.tabla_clientes "
			+ "(nombre,domicilio,poblacion,codigo_postal,telefono) "
			+ "VALUES (?,?,?,?,?);";
	
	final static String sqlSeleccionClientes = "select * from tabla_clientes;";
	
	final static String sqlSeleccionEventos = "select * from tabla_eventos;";
}