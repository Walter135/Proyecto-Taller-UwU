package edu.moduloalumno.entity;

import java.io.Serializable;

public class AlumnoSemestre implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String semestre;
	private String codigo;
	private String nombre;
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String semestre) {
		this.semestre=semestre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
