package com.prueba.ejemplo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.ejemplo.ejb.Propiedad;

public interface PropiedadRepositorio extends CrudRepository<Propiedad, Integer> {

	List<Propiedad> findAll();
}
