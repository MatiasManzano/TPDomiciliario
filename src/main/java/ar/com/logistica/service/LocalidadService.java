package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Localidad;

public interface LocalidadService {

	public Localidad findById(Long idLocalidad);

	public Localidad findByNombre(String nombreLocalidad);

	public void save(Localidad localidad);

	public void deleteByNombre(String nombreLocalidad);

	public List<Localidad> findAllLocalidades();

	public void updateLocalidad(Localidad localidad);

	public boolean isNombreLocalidadUnique(Long idLocalidad, String nombreLocalidad);

}
