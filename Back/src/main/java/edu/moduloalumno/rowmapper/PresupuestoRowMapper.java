package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Presupuesto;

public class PresupuestoRowMapper implements RowMapper<Presupuesto> {
	@Override
	public Presupuesto mapRow(ResultSet row, int rowNum) throws SQLException {
		Presupuesto presupuesto = new Presupuesto();
		presupuesto.setTarifa(row.getString("desc_tarifa_ue"));
		presupuesto.setCiclo(row.getInt("id_programa_ciclo"));
		return presupuesto;
	}
}