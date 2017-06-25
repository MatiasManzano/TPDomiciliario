package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Paquete;

public interface PaqueteService {
	
	public Paquete findById(Long idPaquete);

	public void save(Paquete paquete);

	public void deleteById(Long idPaquete);

	public List<Paquete> findAllPaquetes();
	
	public void updatePaquete(Paquete Paquete);

}
