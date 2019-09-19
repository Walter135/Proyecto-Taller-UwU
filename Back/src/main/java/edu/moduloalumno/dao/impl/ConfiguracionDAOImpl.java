package edu.moduloalumno.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IConfiguracionDAO;
import edu.moduloalumno.entity.Configuracion2;

import edu.moduloalumno.rowmapper.ConfiguracionRowMapper;

@Transactional
@Repository
public class ConfiguracionDAOImpl implements IConfiguracionDAO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override //aqui
	public List<Configuracion2> getAllConfiguracion() {	
		String sql = "select id_configuracion, estado from configuracion order by id_configuracion";

		RowMapper<Configuracion2> rowMapper = new ConfiguracionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
}
	
