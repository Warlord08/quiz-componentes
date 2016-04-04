package com.prueba.ejemplo.servicios;

import java.util.List;

import com.prueba.ejemplo.contratos.PropiedadRequest;
import com.prueba.ejemplo.dao.PropiedadDAO;
import com.prueba.ejemplo.ejb.Propiedad;

public interface PropiedadServiceInterface {

	List<PropiedadDAO> getAll();
	Propiedad getPropiedadById(int idPropiedad);
	Propiedad savePropiedad(PropiedadRequest pRequest);
	Propiedad updatePropiedad(Propiedad propiedad);
	void deletePropiedad(Propiedad propiedad);
	PropiedadDAO getByPropiedadId(int idPropiedad);
}
