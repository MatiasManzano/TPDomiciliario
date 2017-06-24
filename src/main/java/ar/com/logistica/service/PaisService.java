package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Pais;

public interface PaisService {

public Pais findById(Long idPais);
	
	public Pais findByNombre(String nombrePais);
	
	public void save(Pais pais);
     
	public void deleteByNombre(String nombrePais);
     
	public List<Pais> findAllPaises();

	public void updatePais(Pais pais);

	public boolean isNombrePaisUnique(Long idPais, String nombrePais);

}
