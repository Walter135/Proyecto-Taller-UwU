package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.AlumnoSemestre;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.Semestre;

public interface IAlumnoProgramaJOINProgramaJOINAlumnoDAO {

	List<AlumnoProgramaJOINProgramaJOINAlumno> getAllAlumnoProgramaJOINProgramaJOINAlumnos();
	
	List<AlumnoProgramaJOINProgramaJOINAlumno> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido( String nombresApellidos);

	Programa getProgramabyId(Integer id_programa);
	List<Programa> getPrograma();
	
	List<Presupuesto> getPresupuesto(Integer id_programa);
	public List<Semestre> getSemestre();
	public List<AlumnoSemestre> getAlumnoSemestre(String periodoinicial,String periodofinal);
}