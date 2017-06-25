package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.TipoPaquete;


public interface TipoPaqueteDAO {
	
	public TipoPaquete findById(Long idTipoPaquete);

	public TipoPaquete findByDescripcion(String descripcion);

	public void save(TipoPaquete tipoPaquete);

	public void deleteByDescripcion(String descripcion);

	public List<TipoPaquete> findAllTiposPaquete();

}
