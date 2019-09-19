package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Configuracion2;

public class ConfiguracionRowMapper implements RowMapper<Configuracion2> {
	@Override
	public Configuracion2 mapRow(ResultSet row, int rowNum) throws SQLException {
		Configuracion2 configuracion2 = new Configuracion2();
		configuracion2.setIdConfiguracion(row.getInt("id_configuracion"));
		configuracion2.setEstado(row.getString("estado").charAt(0));
		return configuracion2;
	}
}







