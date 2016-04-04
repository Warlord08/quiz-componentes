package com.prueba.ejemplo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ejemplo.contratos.PropiedadRequest;
import com.prueba.ejemplo.contratos.PropiedadResponse;
import com.prueba.ejemplo.dao.PropiedadDAO;
import com.prueba.ejemplo.ejb.Propiedad;
import com.prueba.ejemplo.servicios.PropiedadServiceInterface;

@RestController
@RequestMapping(value="rest/protected/propiedades")
public class PropiedadController {

	@Autowired PropiedadServiceInterface propiedadService;
	
	@RequestMapping(value="/getAll", method= RequestMethod.GET)
	public PropiedadResponse getAll() {
		PropiedadResponse response = new PropiedadResponse();
		response.setCodeMessage("Propiedades obtenidas satisfactoriamente");
		response.setPropiedades(propiedadService.getAll());
		return response;
	}
	
	/**
	  * Envía la información a almacenar a la base de datos por medio de su servicio. 
	  * 
	  * @param request Petición que contiene la información de la entidad que
	  * se desea crear.
	  * @return response La entidad del objeto creado.
	  */
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public PropiedadResponse create(@RequestBody PropiedadRequest request) {
		PropiedadResponse response = new PropiedadResponse();
		Propiedad propiedad = propiedadService.savePropiedad(request);
		
		if (propiedad != null) {
			response.setCode(200);
			response.setCodeMessage("Propiedad guardada");
		}
		
		return response;
	}
	
	@RequestMapping(value="getById/{idPropiedad}", method = RequestMethod.GET)
	public PropiedadResponse getPropiedadById(@PathVariable int idPropiedad) {
		PropiedadResponse response = new PropiedadResponse();
		
		PropiedadDAO propiedad = propiedadService.getByPropiedadId(idPropiedad);
		response.setPropiedad(propiedad);
		
		return response;
	}
	
	@RequestMapping(value="/{idPropiedad}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int idPropiedad) {
		Propiedad propiedad = propiedadService.getPropiedadById(idPropiedad);
		propiedadService.deletePropiedad(propiedad);
	}
	
	@RequestMapping(value="update/{idPropiedad}", method = RequestMethod.PUT)
	public PropiedadResponse updatePropiedad(@RequestBody PropiedadRequest request,
			@PathVariable int idPropiedad) {
		PropiedadResponse response = new PropiedadResponse();
		Propiedad propiedad = propiedadService.getPropiedadById(idPropiedad);
		
		propiedad.setPrecio(request.getPropiedad().getPrecio());
		propiedad.setDireccion(request.getPropiedad().getDireccion());
		
		Propiedad nProp = propiedadService.updatePropiedad(propiedad);
		
		if (nProp != null) {
			response.setCodeMessage("Datos actualizados!");
		}
		
		return response;
	}
}
