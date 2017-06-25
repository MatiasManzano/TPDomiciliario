package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.CategoriaPaquete;

public interface CategoriaPaqueteService {

	public CategoriaPaquete findById(Long idCategoriaPaquete);

	public CategoriaPaquete findByDescripcion(String descripcion);

	public void save(CategoriaPaquete categoriaPaquete);

	public void deleteByDescripcion(String descripcion);

	public List<CategoriaPaquete> findAllCategoriasPaquete();

	public void updateCategoriaPaquete(CategoriaPaquete categoriaPaquete);

	public boolean isDescripcionUnique(Long idCategoriaPaquete, String descripcion);

}
