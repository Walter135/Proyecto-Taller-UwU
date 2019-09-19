package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import edu.moduloalumno.entity.Ubicacions;

public class UbicacionsRowMapper implements RowMapper<Ubicacions>{

	@Override
	public Ubicacions mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ubicacions ubicacions = new Ubicacions();
		ubicacions.setId_Ubicacion(rs.getString("id_ubicacion"));
		ubicacions.setDescripcion(rs.getString("descripcion"));
		return ubicacions;
	}
}
