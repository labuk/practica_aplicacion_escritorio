package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO{

	private Connection miConexion = null;
	
	
	public ClientesDAOImpl() {
		// Preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver encontrado");
			String url = "jdbc:mysql://localhost:3306/practica_escritorio";
			miConexion = DriverManager.getConnection(url, "root", "jeveris");
		} catch (ClassNotFoundException e) {
			System.out.println("** Error: No encuentro el driver - libreria de msqyl");
		} catch (SQLException e) {
			System.out.println("** Error: No obtengo la conexi�n");
		}
		
	} // End ClientesDAOImpl

	
	public void registrarCliente(Cliente c) {
		// SQL a ejecutar
		String sqlInsercionCliente = "INSERT INTO practica_escritorio.tabla_clientes "
				+ "(nombre,domicilio,poblacion,codigo_postal,telefono) "
				+ "VALUES (?,?,?,?,?);";
		// Necesitamos un PreparedStatement para introducir las variables
		PreparedStatement ps;
		// Preparamos el PreparedStatement, ejecutamos y cerramos
		try {
			ps = miConexion.prepareStatement(sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());
			ps.execute();
			ps.close();
			System.out.println("Cliente registrado correctamente");
			JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar Cliente");
			System.out.println("** Error: Fallo en la SQL");
		}
		
	} // End registrarClientes

	
	public void actualizarCliente(Cliente c) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlActualizarCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());
			ps.setInt(6, c.getId());
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente modificado correctamente. Cierra la ventana modificar para actualizar la tabla.");
			System.out.println("Cliente modificado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al modificar Cliente");
			System.out.println("** Error: Fallo en la SQL de actualizarCliente");
			// M�s info del error
			System.out.println(e.getMessage());
		} // End try
	} // End actualizarCliente
	
	
	public void borrarCliente(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoCliente);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente borrado correctamente");
			System.out.println("Cliente borrado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al borrar Cliente");
			System.out.println("Fallo en la SQL de borrarClientes");
			// M�s info del error
			System.out.println(e.getMessage());
		} // End try
	} // End borrarCliente

	
	public Cliente obtenerClientePorId(int id) {
		Cliente cliente = new Cliente();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionClientePorId);
			ps.setInt(1, id);
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				// DTO - Data transformation object
				cliente.setId(resultado.getInt("id"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setDomicilio(resultado.getString("domicilio"));
				cliente.setPoblacion(resultado.getString("poblacion"));
				cliente.setCodigoPostal(resultado.getString("codigo_postal"));
				cliente.setTelefono(resultado.getString("telefono"));
			} // end if
			ps.close();
			System.out.println("Cliente por Id obtenidos de manera correcta");
		} catch (SQLException e) {
			System.out.println("Fallo al recuperar los datos del cliente");
			System.out.println("Fallo en la SQL de obtenerClientePorId");
		}
		return cliente;
	} // End obtenerClientePorId
	
	
	public Cliente[] obtenerClientes() {
		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionClientes);
			// Para SQL tipo select debo usar el m�todo executeQuery.
			// Los resultados se devuelven en ResultSet
			// El funcionamiento es parecido al de Iterator
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			// En ResultSet next() pasa directamente al siguiente resultado en caso de que haya
			// sino devuelve un false
			while (resultado.next()) {
				// DTO - Data transformation object
				Cliente c = new Cliente();
				c.setId(resultado.getInt("id"));
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setPoblacion(resultado.getString("poblacion"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setTelefono(resultado.getString("telefono"));
				listClientes.add(c);
			} // end while
			// Transformamos de list a array para que no puedan introducir un nuevo elemento
			// listClientes.size() - Es el tama�o del array que tieene que crear, viene del tama�o de la lista
			// toArray() crea un array de tipo object
			// new Cliente[listClientes.size()] - Creamos un nuevo array con el tama�o de la lista para darselo a toArray
			clientes = listClientes.toArray(new Cliente[listClientes.size()]);
			ps.close();
			System.out.println("Clientes obtenidos de manera correcta");
		} catch (SQLException e) {
			System.out.println("Fallo al recuperar la lista de Clientes");
			System.out.println("Fallo en la SQL de obtenerClientes");
		}
		return clientes;
	} // End obtenerClientes()

}
