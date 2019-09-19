package edu.moduloalumno.entity;

public class Ubicacions {
	
	private String id_ubicacion;
	private String descripcion;
	public String getId_ubicacion() {
		return id_ubicacion;
	}
	public void setId_Ubicacion (String id_ubicacion) {
		this.id_ubicacion = id_ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Ubicacions [id_ubicacion=" + id_ubicacion + ", descripcion=" + descripcion + "]";
	}
		
}
