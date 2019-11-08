package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Presupuesto;

public class PresupuestoRowMapper implements RowMapper<Presupuesto> {
	@Override
	public Presupuesto mapRow(ResultSet row, int rowNum) throws SQLException {
		Presupuesto presupuesto = new Presupuesto();
		presupuesto.setPrograma_presupuesto(row.getInt("id_programa_presupuesto"));
		presupuesto.setId_programa(row.getInt("id_programa"));
		presupuesto.setCosto_credito(row.getInt("costo_credito"));
		presupuesto.setCosto_total(row.getInt("costo_total"));
		return presupuesto;
	}
}