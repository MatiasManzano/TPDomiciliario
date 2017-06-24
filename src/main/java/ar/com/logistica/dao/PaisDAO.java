package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Pais;

public interface PaisDAO {
	
	public Pais findById(Long idPais);
	
	public Pais findByNombre(String nombrePais);
	
	public void save(Pais pais);
     
	public void deleteByNombre(String nombrePais);
     
	public List<Pais> findAllPaises();

}
