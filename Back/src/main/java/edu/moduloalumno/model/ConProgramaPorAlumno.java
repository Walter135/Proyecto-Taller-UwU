package edu.moduloalumno.model;

import java.io.Serializable;

import edu.moduloalumno.entity.Facultad;
import edu.moduloalumno.entity.Usuario;

public class ConProgramaPorAlumno implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codAlumno;

    private String anioIngreso;

    private String anioEgreso;

    private String nomPrograma;

    private String siglaPrograma;

    

    public ConProgramaPorAlumno() {
    }



	public String getCodAlumno() {
		return codAlumno;
	}



	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}



	public String getAnioIngreso() {
		return anioIngreso;
	}



	public void setAnioIngreso(String anioIngreso) {
		this.anioIngreso = anioIngreso;
	}



	public String getAnioEgreso() {
		return anioEgreso;
	}



	public void setAnioEgreso(String anioEgreso) {
		this.anioEgreso = anioEgreso;
	}



	public String getNomPrograma() {
		return nomPrograma;
	}



	public void setNomPrograma(String nomPrograma) {
		this.nomPrograma = nomPrograma;
	}



	public String getSiglaPrograma() {
		return siglaPrograma;
	}



	public void setSiglaPrograma(String siglaPrograma) {
		this.siglaPrograma = siglaPrograma;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "ConProgramaPorAlumno [codAlumno=" + codAlumno + ", anioIngreso=" + anioIngreso + ", anioEgreso="
				+ anioEgreso + ", nomPrograma=" + nomPrograma + ", siglaPrograma=" + siglaPrograma + "]";
	}

   
    
}