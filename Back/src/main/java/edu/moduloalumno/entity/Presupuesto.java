package edu.moduloalumno.entity;

import java.io.Serializable;

public class Presupuesto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tarifa;
	
	private Integer ciclo;
	
	public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }


}
