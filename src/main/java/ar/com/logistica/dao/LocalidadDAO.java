package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Localidad;

public interface LocalidadDAO {

	public Localidad findById(Long idLocalidad);

	public Localidad findByNombre(String nombreLocalidad);

	public void save(Localidad localidad);

	public void deleteByNombre(String nombreLocalidad);

	public List<Localidad> findAllLocalidades();

}
