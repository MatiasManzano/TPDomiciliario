package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Provincia;

public interface ProvinciaDAO {

	public Provincia findById(Long idProvincia);

	public Provincia findByNombre(String nombreProvincia);

	public void save(Provincia provincia);

	public void deleteByNombre(String nombreProvincia);

	public List<Provincia> findAllProvincias();

}
