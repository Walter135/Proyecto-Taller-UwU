package edu.moduloalumno.entity;

import java.io.Serializable;

public class Semestre implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String semestre;
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String semestre) {
		this.semestre=semestre;
	}

}
