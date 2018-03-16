package daos;

import modelo.Cliente;

// En entorno corporativo, lo m�s normal del mundo es definir las operaciones que se 
// van a poder hacer sobre base de datos en un interfaz

// En este caso para el interfaz actual, cada m�todo dir� que se puede hacer 
// en base de datos de cara a clientes

public interface ClientesDAO {
	
	void registrarCliente(Cliente c);
	void borrarCliente(int id);
	// Array: conjunto de datos del mismo tipo
	Cliente[] obtenerClientes();

}
