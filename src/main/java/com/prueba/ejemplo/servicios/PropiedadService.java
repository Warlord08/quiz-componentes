package com.prueba.ejemplo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.ejemplo.contratos.PropiedadRequest;
import com.prueba.ejemplo.dao.PropiedadDAO;
import com.prueba.ejemplo.ejb.Propiedad;
import com.prueba.ejemplo.repositorios.PropiedadRepositorio;

@Service
public class PropiedadService implements PropiedadServiceInterface {

	/**
	 * Atributo de acceso al repositorio de las propiedades.
	 */
	@Autowired PropiedadRepositorio propiedadRepository;
	
	/**
	  * Retorna una lista de objetos PropiedadDAO
	  * 
	  * @return propiedades Todas las entidades del tipo.
	  */
	@Override
	@Transactional
	public List<PropiedadDAO> getAll() {
		List<Propiedad> propiedades = propiedadRepository.findAll();
		return generatePropDao(propiedades);
	}
	
	/**
	  * Toma las propiedades de los ejbs y los convierte en DAOs.
	  * 
	  * @param propiedades Lista de ejb de propiedades. No debe ser nula.
	  * @return lPropiedades Todas las entidades de tipo DAO.
	  */
	private List<PropiedadDAO> generatePropDao(List<Propiedad> propiedades) {
		List<PropiedadDAO> lPropiedades = new ArrayList<PropiedadDAO>();
		propiedades.stream().forEach(u -> {
			PropiedadDAO dao = new PropiedadDAO();
			BeanUtils.copyProperties(u, dao);
			lPropiedades.add(dao);
		});
		return lPropiedades;
	}
	
	/**
	  * Retorna a través del repositorio el ejb de la propiedad.
	  * 
	  * @param idPropiedad Id de la propiedad a buscar. No debe ser nulo.
	  * @return Propiedad Una entidad del tipo.
	  */
	@Override
	@Transactional
	public Propiedad getPropiedadById(int idPropiedad) {
		return propiedadRepository.findOne(idPropiedad);
	}
	
	/**
	  * Retorna a través del repositorio el ejb de la propiedad.
	  * 
	  * @param idPropiedad Id de la propiedad a buscar. No debe ser nulo.
	  * @return PropiedadDAO Una entidad del tipo.
	  */
	@Override
	@Transactional
	public PropiedadDAO getByPropiedadId(int idPropiedad) {
		PropiedadDAO dao = new PropiedadDAO();
		Propiedad propiedad = propiedadRepository.findOne(idPropiedad);
		
		BeanUtils.copyProperties(propiedad, dao);
		
		return dao; 
	}
	
	/**
	  * Alamacena la entidad. Retorna la entidad almacenada por si hay que realizar operaciones adicionales.
	  * 
	  * @param pRequest Contiene la infomarción a almacenar a la base de 
	  * datos. No debe ser nulo.
	  * @return nPropiedad Una entidad del tipo.
	  */
	@Override
	@Transactional
	public Propiedad savePropiedad(PropiedadRequest pRequest) {
		Propiedad propiedad = new Propiedad();
		
		BeanUtils.copyProperties(pRequest.getPropiedad(), propiedad);
		
		Propiedad nPropiedad = propiedadRepository.save(propiedad);
		
		return nPropiedad;
	}
	
	@Override
	@Transactional
	public Propiedad updatePropiedad(Propiedad propiedad) {
		Propiedad nPropiedad = propiedadRepository.save(propiedad);
		return nPropiedad;
	}
	
	@Override
	@Transactional
	public void deletePropiedad(Propiedad propiedad) {
		propiedadRepository.delete(propiedad);
	}
}
