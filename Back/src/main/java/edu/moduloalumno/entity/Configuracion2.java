package edu.moduloalumno.entity;

public class Configuracion2 {
	
	private Integer idConfiguracion;
	
	private char estado;
    
    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }
	
	public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConfiguracion == null) ? 0 : idConfiguracion.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Configuracion [idConfiguracion=" + idConfiguracion + ", estado="
				+ estado + "]";
	}

	
}
