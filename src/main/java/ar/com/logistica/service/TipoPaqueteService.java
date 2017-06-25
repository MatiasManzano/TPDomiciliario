package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.TipoPaquete;

public interface TipoPaqueteService {
	
	public TipoPaquete findById(Long idTipoPaquete);

	public TipoPaquete findByDescripcion(String descripcion);

	public void save(TipoPaquete tipoPaquete);

	public void deleteByDescripcion(String descripcion);

	public List<TipoPaquete> findAllTiposPaquete();
	
	public void updateTipoPaquete(TipoPaquete tipoPaquete);

	public boolean isDescripcionUnique(Long idTipoPaquete, String descripcion);

}
