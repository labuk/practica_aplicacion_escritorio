package paneles;

import java.awt.event.ActionEvent;

import paneles.PanelRegistroCliente;

import modelo.Cliente;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;

public class PanelActualizoCliente extends PanelRegistroCliente{

	private Cliente cliente = new Cliente();
	private ClientesDAO clienteDAO = new ClientesDAOImpl();
	
	/**
	 *  Reutilizamos la implementación del formulario de PanelRegistroCliente
	 */
	public PanelActualizoCliente(int id) {
		super();
		System.out.println("El id del cliente es: " + id);
		cliente = clienteDAO.obtenerClientePorId(id);
		this.campoNombre.setText(cliente.getNombre());
		this.campoDomicilio.setText(cliente.getDomicilio());
		this.campoPoblacion.setText(cliente.getPoblacion());
		this.campoCodigoPostal.setText(cliente.getCodigoPostal());
		this.campoTelefono.setText(cliente.getTelefono());
	}

	@Override
	public String setPanelTitle(){
		return "Modifica los datos del cliente que desees";
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("actionPerformed - botonActualizoCliente");
		cliente.setNombre(campoNombre.getText());
		cliente.setDomicilio(campoDomicilio.getText());
		cliente.setPoblacion(campoPoblacion.getText());
		cliente.setCodigoPostal(campoCodigoPostal.getText());
		cliente.setTelefono(campoTelefono.getText());
		System.out.println("Cliente a actualizar: " + cliente.toString());
	}
	
}
