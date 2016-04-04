package com.prueba.ejemplo.contratos;

import java.util.List;

import com.prueba.ejemplo.dao.PropiedadDAO;

public class PropiedadResponse extends BaseResponse {

	List<PropiedadDAO> propiedades;
	PropiedadDAO propiedad;
	
	public PropiedadResponse() {
		super();
	}

	public List<PropiedadDAO> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<PropiedadDAO> propiedades) {
		this.propiedades = propiedades;
	}

	public PropiedadDAO getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(PropiedadDAO propiedad) {
		this.propiedad = propiedad;
	}
}
