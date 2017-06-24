package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Provincia;

public interface ProvinciaService {

	public Provincia findById(Long idProvincia);

	public Provincia findByNombre(String nombreProvincia);

	public void save(Provincia provincia);

	public void deleteByNombre(String nombreProvincia);

	public List<Provincia> findAllProvincias();

	public void updateProvincia(Provincia provincia);

	public boolean isNombreProvinciaUnique(Long idProvincia, String nombreProvincia);

}
