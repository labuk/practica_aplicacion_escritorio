package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Evento;

public class EventosDAOImpl implements EventosDAO{

	private Connection miConexion = null;
	
	public EventosDAOImpl() {
		// Preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Encontramos driver");
			String url = "jdbc:mysql://localhost:3306/practica_escritorio";
			miConexion = DriverManager.getConnection(url, "root", "jeveris");
		} catch (ClassNotFoundException e1) {
			System.out.println("** Error: No encuentro el driver - libreria de msqyl");
		} catch (SQLException e1) {
			System.out.println("** Error: No obtengo la conexión");
		}
	} // End EventosDAOImpl
	
	public void registrarEvento(Evento e) {
		// SQL a ejecutar
		String sqlInsercionCliente = "insert into tabla_eventos "
				+ "(titulo, descripcion, localizacion, organizador, tipo, fecha, importante) "
				+ "values (?,?,?,?,?,?,?);";
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(sqlInsercionCliente);
			System.out.println("Pepara el ");
			ps.setString(1, e.getTitulo());
			ps.setString(2, e.getDescripcion());
			ps.setString(3, e.getLocalizacion());
			ps.setString(4, e.getOrganizador());
			ps.setString(5, e.getTipo());
			ps.setString(6, e.getFecha());
			ps.setBoolean(7, e.getImportante());
			ps.execute();
			System.out.println("Ejecuta la sentencia");
			ps.close();
			System.out.println("Evento registrado correctamente");
		} catch (SQLException e1) {
			System.out.println("** Error: Fallo en la SQL");
		}
		
	} // End registrarEvento()

	public void borrarEvento(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoEvento);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			System.out.println("Cliente borrado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de borrarClientes");
			// Más info del error
			System.out.println(e.getMessage());
		} // End try
	}

	public Evento[] obtenerEventos() {
		Evento[] eventos = null;
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionEventos);
			ResultSet resultado = ps.executeQuery();
			List<Evento> listEventos = new ArrayList<Evento>();
			while (resultado.next()) {
				Evento e = new Evento();
				e.setId(resultado.getInt("id"));
				e.setTitulo(resultado.getString("titulo"));
				e.setDescripcion(resultado.getString("descripcion"));
				e.setLocalizacion(resultado.getString("localizacion"));
				e.setOrganizador(resultado.getString("organizador"));
				e.setTipo(resultado.getString("tipo"));
				e.setFecha(resultado.getString("fecha"));
				e.setImportante(resultado.getBoolean("importante"));
				listEventos.add(e);
			}
			eventos = listEventos.toArray(new Evento[listEventos.size()]);
			System.out.println("Eventos obtenidos de manera correcta");
			ps.close();	
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de obtenerEventos");
		}
		
		return eventos;
	} // End obtenerEventos

}
