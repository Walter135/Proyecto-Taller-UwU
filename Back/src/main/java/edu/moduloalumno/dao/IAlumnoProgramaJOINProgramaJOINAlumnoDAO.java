package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;

public interface IAlumnoProgramaJOINProgramaJOINAlumnoDAO {

	List<AlumnoProgramaJOINProgramaJOINAlumno> getAllAlumnoProgramaJOINProgramaJOINAlumnos();
	
	List<AlumnoProgramaJOINProgramaJOINAlumno> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido( String nombresApellidos);

	Programa getProgramabyId(Integer id_programa);
	List<Programa> getPrograma();
	
	List<Presupuesto> getPresupuesto(Integer id_programa);
}