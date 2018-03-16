package modelo;

public class Evento {

	// id,titulo, descripcion, localizacion, organizador, tipo, fecha, importante
	private int id;
	private String titulo;
	private String descripcion;
	private String localizacion;
	private String organizador;
	private String tipo;
	private String fecha;
	private boolean importante;
	
	public Evento() {
		
	} // End Evento()

	/**
	 * @param titulo
	 * @param descripcion
	 * @param localizacion
	 * @param organizador
	 * @param tipo
	 * @param fecha
	 * @param importante
	 */
	public Evento(String titulo, String descripcion, String localizacion,
			String organizador, String tipo, String fecha, boolean importante) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.organizador = organizador;
		this.tipo = tipo;
		this.fecha = fecha;
		this.importante = importante;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return the organizador
	 */
	public String getOrganizador() {
		return organizador;
	}

	/**
	 * @param organizador the organizador to set
	 */
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the importante
	 */
	public Boolean getImportante() {
//		if (importante){
//			return "Si";
//		}
//		return "No";
		return importante;
	}

	/**
	 * @param importante the importante to set
	 */
	public void setImportante(boolean importante) {
		this.importante = importante;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", descripcion=" + descripcion
				+ ", localizacion=" + localizacion + ", organizador="
				+ organizador + ", tipo=" + tipo + ", fecha=" + fecha
				+ ", importante=" + importante + "]";
	}
	
}
