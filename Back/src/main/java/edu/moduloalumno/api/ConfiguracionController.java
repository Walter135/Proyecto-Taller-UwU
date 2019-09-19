package edu.moduloalumno.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.Configuracion2;
import edu.moduloalumno.service.IConfiguracionService;


@RestController
@RequestMapping("configuracion")
public class ConfiguracionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IConfiguracionService configuracionservice;

        
  /**/  @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Configuracion2>> getAllConfiguracion() {
		logger.info("> getAllConfiguracion [Configuraciones]");

		List<Configuracion2> list = null;

		try {

			list = configuracionservice.getAllConfiguracion();
			if (list == null) {
				list = new ArrayList<Configuracion2>();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Configuracion2>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllConfiguracion [Configuraciones]");
		return new ResponseEntity<List<Configuracion2>>(list, HttpStatus.OK);
	}
}
