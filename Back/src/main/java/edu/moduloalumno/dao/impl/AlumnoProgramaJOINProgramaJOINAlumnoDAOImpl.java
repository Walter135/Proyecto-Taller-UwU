package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IAlumnoProgramaJOINProgramaJOINAlumnoDAO;
import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.AlumnoSemestre;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.Semestre;
import edu.moduloalumno.rowmapper.AlumnoProgramaJOINProgramaJOINAlumnoRowMapper;
import edu.moduloalumno.rowmapper.AlumnoProgramaJOINProgramaRowMapper;
import edu.moduloalumno.rowmapper.AlumnoSemestreRowMapper;
import edu.moduloalumno.rowmapper.PresupuestoRowMapper;
import edu.moduloalumno.rowmapper.ProgramaRowMapper;
import edu.moduloalumno.rowmapper.SemestreRowMapper;

@Transactional
@Repository
public class AlumnoProgramaJOINProgramaJOINAlumnoDAOImpl implements IAlumnoProgramaJOINProgramaJOINAlumnoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AlumnoProgramaJOINProgramaJOINAlumno> getAllAlumnoProgramaJOINProgramaJOINAlumnos() {
		//String sql = "SELECT aap.id_alum, a.ape_nom as nom_alumno, aap.cod_alumno,  aap.id_programa, p.nom_programa, p.sigla_programa FROM alumno a, alumno_programa ap, alumno_alumno_programa aap, programa p where aap.id_alum = a.id_alum and aap.cod_alumno = ap.cod_alumno and aap.id_programa = p.id_programa order by aap.id_alum";
		String sql = "SELECT " +
		"a.id_alum, " +
		"a.ape_nom as nom_alumno, " +
		"ap.cod_alumno,  " +
		"ap.id_programa, " +
		"p.nom_programa, " +
		"p.sigla_programa " +
		"FROM alumno a inner join recaudaciones r " +
		"on (r.id_alum = a.id_alum) " +
		"inner join alumno_programa ap " +
		"on (r.cod_alumno = ap.cod_alumno) " +
		"inner join programa p " +
		"on (ap.id_programa = p.id_programa) " +
		"order by a.id_alum";

		RowMapper<AlumnoProgramaJOINProgramaJOINAlumno> rowMapper = new AlumnoProgramaJOINProgramaJOINAlumnoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<AlumnoProgramaJOINProgramaJOINAlumno> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(String nombresApellidos) {
		String sql = "SELECT ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as nom_alumno,  " +
		"ap.cod_alumno, p.id_programa, p.nom_programa, p.sigla_programa  " +
		"FROM alumno_programa ap inner join programa p  " +
		"on (ap.id_programa = p.id_programa) " +
		"where to_tsquery( translate( ? ,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU') )  " +
		"@@ to_tsvector(coalesce(translate(ap.nom_alumno,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU'),'')  " +
		"|| ' ' ||coalesce(translate(ap.ape_paterno,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU'),'') || ' ' ||coalesce(translate(ap.ape_materno,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU')))  " ;
		

		RowMapper<AlumnoProgramaJOINProgramaJOINAlumno> rowMapper = new AlumnoProgramaJOINProgramaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombresApellidos);
	}

	@Override
	public Programa getProgramabyId(Integer id_programa) {
		try {
		String sql = "select id_programa,nom_programa,sigla_programa,vigencia_programa,id_tip_grado from programa where id_programa = ?";
		RowMapper<Programa> rowMapper = new ProgramaRowMapper();
		Programa programa = jdbcTemplate.queryForObject(sql, rowMapper, id_programa);
		return programa;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}	
	}
	
	@Override
	public List<Programa> getPrograma() {
		try {
		String sql = "select id_programa,nom_programa,sigla_programa,vigencia_programa,id_tip_grado from programa where vigencia_programa=true";
		RowMapper<Programa> rowMapper = new ProgramaRowMapper();
		List<Programa> programa = jdbcTemplate.query(sql, rowMapper);
		return programa;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}	
	}
	
	@Override
	public List<Presupuesto> getPresupuesto(Integer id_programa) {
		try {
		String sql = "select id_programa_presupuesto,id_programa,costo_credito,costo_total from programa_presupuesto where id_programa=?";
		RowMapper<Presupuesto> rowMapper = new PresupuestoRowMapper();
		List<Presupuesto> presupuesto = jdbcTemplate.query(sql, rowMapper,id_programa);
		return presupuesto;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}			
	}
	
	public List<Semestre> getSemestre() {
		try {
		String sql = "select distinct semestre from Matricula_cab order by semestre";
		RowMapper<Semestre> rowMapper = new SemestreRowMapper();
		List<Semestre> semestre = jdbcTemplate.query(sql, rowMapper);
		return semestre;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}			
	}
	
	public List<AlumnoSemestre> getAlumnoSemestre(String periodoinicial,String periodofinal) {
		try {
		String sql = "select distinct (a.nom_alumno || ' ' || a.ape_paterno || ' ' || a.ape_materno) as nombre_completo,a.id_programa_presupuesto as programa,m.cod_alumno as cod_alumno, max(m.semestre) as semestre from alumno_programa a inner join matricula_cab m on a.cod_alumno=m.cod_alumno and semestre >= ? and semestre <= ? group by a.nom_alumno,a.ape_paterno,a.ape_materno,m.cod_alumno,a.id_programa_presupuesto";
		RowMapper<AlumnoSemestre> rowMapper = new AlumnoSemestreRowMapper();
		List<AlumnoSemestre> alumnosemestre = jdbcTemplate.query(sql, rowMapper,periodoinicial,periodofinal);
		return alumnosemestre;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}			
	}
	
}