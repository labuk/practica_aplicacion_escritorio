package modelo;

public class Cliente {

	private String nombre;
	private String domicilio;
	private String poblacion;
	private String codigoPostal;
	private String telefono;
	
	public Cliente() {
		
	} // End Cliente()

	/**
	 * @param nombre
	 * @param domicilio
	 * @param poblacion
	 * @param codigoPostal
	 * @param telefono
	 */
	public Cliente(String nombre, String domicilio, String poblacion,
			String codigoPostal, String telefono) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
	} //  Cliente(String nombre, String domicilio, String poblacion, String codigoPostal, String telefono)

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", domicilio=" + domicilio
				+ ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
