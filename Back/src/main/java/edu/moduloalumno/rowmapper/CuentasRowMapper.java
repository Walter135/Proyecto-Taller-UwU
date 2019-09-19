package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import edu.moduloalumno.entity.Cuentas;

public class CuentasRowMapper implements RowMapper<Cuentas>{

	@Override
	public Cuentas mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cuentas cuentas = new Cuentas();
		cuentas.setId_tipo(rs.getString("id_tipo"));
		cuentas.setDescripcion(rs.getString("descripcion"));
		return cuentas;
	}
}
