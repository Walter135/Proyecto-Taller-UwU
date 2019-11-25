package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.AlumnoSemestre;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.Semestre;
import edu.moduloalumno.service.IAlumnoProgramaJOINProgramaJOINAlumnoService;
import edu.moduloalumno.util.Operaciones;

@RestController
@RequestMapping("alumno/alumnoprograma/programa")
public class AlumnoProgramaJOINProgramaJOINAlumnoController {
	
	//Aprendi por fin, gracias dios. comit numero 2

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAlumnoProgramaJOINProgramaJOINAlumnoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>> getAllAlumnoProgramaJOINProgramaJOINAlumnos() {
		logger.info("> getAllAlumnoProgramaJOINProgramaJOINAlumnos [AlumnoProgramaJOINProgramaJOINAlumno]");

		List<AlumnoProgramaJOINProgramaJOINAlumno> list = null;
		try {
			list = service.getAllAlumnoProgramaJOINProgramaJOINAlumnos();

			if (list == null) {
				list = new ArrayList<AlumnoProgramaJOINProgramaJOINAlumno>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAlumnoProgramaJOINProgramaJOINAlumnos [AlumnoProgramaJOINProgramaJOINAlumno]");
		return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/leer/restringido/{nombresApellidos}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(@PathVariable("nombresApellidos") String nombresApellidos) {
		logger.info("> getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");

		List<AlumnoProgramaJOINProgramaJOINAlumno> list = null;
		try {
			list = service.getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(nombresApellidos);

			if (list == null) {
				list = new ArrayList<AlumnoProgramaJOINProgramaJOINAlumno>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(list, HttpStatus.OK);
	}
	
	// /// / // / / /
	
	@RequestMapping(value = "/{id_programa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Programa> getProgramabyId(@PathVariable("id_programa") int id_programa) {
		logger.info("> getAlumnoProgramas [Programa]");

		Programa programa = null;
		try {
			programa = service.getProgramabyId(id_programa);

			if (programa == null) {	
				programa = new Programa();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Programa>(programa, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<Programa>(programa, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/presupuesto/{id_programa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Presupuesto>> getPresupuesto(@PathVariable("id_programa") int id_programa) {
		logger.info("> getAlumnoProgramas [Presupuesto]");

		List<Presupuesto> presupuesto = null;
		try {
			presupuesto = service.getPresupuesto(id_programa);

			if (presupuesto == null) {	
				presupuesto = new ArrayList<Presupuesto>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Presupuesto>>(presupuesto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<Presupuesto>>(presupuesto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/programas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Programa>> getPrograma() {
		logger.info("> getAlumnoProgramas [Programa]");

		List<Programa> programa = null;
		try {
			programa = service.getPrograma();

			if (programa == null) {	
				programa = new ArrayList<Programa>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Programa>>(programa, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<Programa>>(programa, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listar/restringido/{nombresApellidos}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosListarRestringido(@PathVariable("nombresApellidos") String nombresApellidos) {
		logger.info("> getAlumnoProgramasIdByNombresApellidosListarRestringido [AlumnoPrograma]");

		String[] palabras = nombresApellidos.split(" ");
		String nombre = String.join(" | ", palabras);
		logger.info(nombre);
		List<AlumnoProgramaJOINProgramaJOINAlumno> list = null;
		List<AlumnoProgramaJOINProgramaJOINAlumno> listInterseccion = service.getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(nombre);
		logger.info("primera lista" + listInterseccion.toString());
		Operaciones operacion = new Operaciones();
		try {
			
			for (String palabra : palabras) {
				list = service.getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(palabra);
				listInterseccion = operacion.intersection( list.size() !=0 ? list : listInterseccion, listInterseccion);
				logger.info("lista palabra" + listInterseccion.toString());
				list = null;
			}
			//list = service.getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(nombresApellidos);

			/*if (listInterseccion == null) {
				listInterseccion = new ArrayList<AlumnoProgramaJOINProgramaJOINAlumno>();
			}*/
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(listInterseccion, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<AlumnoProgramaJOINProgramaJOINAlumno>>(listInterseccion, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/semestres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Semestre>> getSemestre() {
		logger.info("> getSemestres [Semestre]");

		List<Semestre> semestre = null;
		try {
			semestre = service.getSemestre();

			if (semestre == null) {	
				semestre = new ArrayList<Semestre>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Semestre>>(semestre, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getSemestre [Semestre]");
		return new ResponseEntity<List<Semestre>>(semestre, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/alumnosemestres/{periodo_inicial}/{periodo_final}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoSemestre>> getAlumnoSemestre(@PathVariable("periodo_inicial") String periodo_inicial,@PathVariable("periodo_final") String periodo_final) {
		logger.info("> getAlumnoSemestres [AlumnoSemestres]");

		List<AlumnoSemestre> alumnosemestre = null;
		try {
			alumnosemestre = service.getAlumnoSemestre(periodo_inicial,periodo_final);

			if (alumnosemestre == null) {	
				alumnosemestre = new ArrayList<AlumnoSemestre>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AlumnoSemestre>>(alumnosemestre, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoSemestre [AlumnoSemestre]");
		return new ResponseEntity<List<AlumnoSemestre>>(alumnosemestre, HttpStatus.OK);
	}
	
	//hola mundo

}
