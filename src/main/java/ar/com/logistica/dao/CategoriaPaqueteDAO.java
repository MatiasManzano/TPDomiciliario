package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.CategoriaPaquete;

public interface CategoriaPaqueteDAO {
	
	public CategoriaPaquete findById(Long idCategoriaPaquete);

	public CategoriaPaquete findByDescripcion(String descripcion);

	public void save(CategoriaPaquete categoriaPaquete);

	public void deleteByDescripcion(String descripcion);

	public List<CategoriaPaquete> findAllCategoriasPaquete();


}
