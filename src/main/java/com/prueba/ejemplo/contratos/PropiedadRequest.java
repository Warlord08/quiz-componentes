package com.prueba.ejemplo.contratos;

import com.prueba.ejemplo.dao.PropiedadDAO;

public class PropiedadRequest extends BaseRequest {

	PropiedadDAO propiedad;
	
	public PropiedadRequest() {
		super();
	}

	public PropiedadDAO getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(PropiedadDAO propiedad) {
		this.propiedad = propiedad;
	}
	
	@Override
	public String toString() {
		return "PropiedadRequest [propiedad=" + propiedad + "]";
	}
}
