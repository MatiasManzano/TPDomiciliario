package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Paquete;


public interface PaqueteDAO {
	
	public Paquete findById(Long idPaquete);

	public void save(Paquete paquete);

	public void deleteById(Long idPaquete);

	public List<Paquete> findAllPaquetes();

}
