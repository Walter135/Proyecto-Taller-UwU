package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import edu.moduloalumno.entity.AlumnoSemestre;;

public class AlumnoSemestreRowMapper implements RowMapper<AlumnoSemestre>{
	@Override
	public AlumnoSemestre mapRow(ResultSet row, int rowNum) throws SQLException {
		AlumnoSemestre alumnosemestre = new AlumnoSemestre();
		alumnosemestre.setSemestre(row.getString("semestre"));
		alumnosemestre.setCodigo(row.getString("cod_alumno"));
		alumnosemestre.setNombre(row.getString("nombre_completo"));
		alumnosemestre.setPresupuesto(row.getInt("presupuesto"));
		return alumnosemestre;
	}
}
