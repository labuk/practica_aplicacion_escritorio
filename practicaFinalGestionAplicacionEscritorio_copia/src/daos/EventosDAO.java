package daos;

import modelo.Cliente;
import modelo.Evento;

// En entorno corporativo, lo más normal del mundo es definir las operaciones que se 
// van a poder hacer sobre base de datos en un interfaz

// En este caso para el interfaz actual, cada método dirá que se puede hacer 
// en base de datos de cara a clientes

public interface EventosDAO {
	
	void registrarEvento(Evento e);
	void borrarEvento(int id);
	// Array: conjunto de datos del mismo tipo
	Evento[] obtenerEventos();

}
