package edu.moduloalumno.entity;

public class Cuentas {
	
	private String id_tipo;
	private String descripcion;
	public String getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo (String id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Cuentas [id_tipo=" + id_tipo + ", descripcion=" + descripcion + "]";
	}
		
}
