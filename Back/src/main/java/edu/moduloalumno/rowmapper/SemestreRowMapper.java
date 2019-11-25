package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import edu.moduloalumno.entity.Semestre;

public class SemestreRowMapper implements RowMapper<Semestre>{
	@Override
	public Semestre mapRow(ResultSet row, int rowNum) throws SQLException {
		Semestre semestre = new Semestre();
		semestre.setSemestre(row.getString("semestre"));
		return semestre;
	}
}
