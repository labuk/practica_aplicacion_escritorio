package daos;

public class ConstantesSQL {
	
	// final hace que la variable no se pueda modificar de ninguna manera
	//  SQL Clientes
	final static String sqlInsercionCliente = "INSERT INTO practica_escritorio.tabla_clientes "
			+ "(nombre,domicilio,poblacion,codigo_postal,telefono) "
			+ "VALUES (?,?,?,?,?);";
	final static String sqlSeleccionClientePorId = "select * from tabla_clientes where id = ?;";
	final static String sqlSeleccionClientes = "select * from tabla_clientes;";
	final static String sqlBorradoCliente = "delete from tabla_clientes where id = ?;";
	final static String sqlActualizarCliente = "update tabla_clientes "
			+ " set nombre=?, domicilio=?, poblacion=?, codigo_postal=?, telefono=? "
			+ " where id = ?";
	
	// SQL Eventos
	final static String sqlSeleccionEventos = "select * from tabla_eventos;";
	final static String sqlBorradoEvento = "delete from tabla_eventos where id = ?";
}