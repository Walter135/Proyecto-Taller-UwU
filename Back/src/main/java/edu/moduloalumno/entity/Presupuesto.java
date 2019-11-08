package edu.moduloalumno.entity;

import java.io.Serializable;

public class Presupuesto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer programa_presupuesto;
	private Integer id_programa;
	private Integer costo_credito;
	private Integer costo_total;
	
	public Integer getPrograma_presupuesto() {
        return programa_presupuesto;
    }

    public void setPrograma_presupuesto(Integer programa_presupuesto) {
        this.programa_presupuesto = programa_presupuesto;
    }
    
    public Integer getId_programa() {
        return id_programa;
    }

    public void setId_programa(Integer id_programa) {
        this.id_programa = id_programa;
    }
    
    public Integer getCosto_credito() {
        return costo_credito;
    }

    public void setCosto_credito(Integer costo_credito) {
        this.costo_credito = costo_credito;
    }
    
    public Integer getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(Integer costo_total) {
        this.costo_total = costo_total;
    }


}
