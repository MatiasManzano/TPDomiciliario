package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Direccion;

public interface DireccionService {
	
	public Direccion findById(Long idDireccion);

	public Direccion findByCalle(String calle);

	public void save(Direccion direccion);

	public void deleteByCalle(String calle);

	public List<Direccion> findAllDirecciones();
	
	public void updateDireccion(Direccion direccion);

	public boolean isCalleDireccionUnique(Long idDireccion, String calle);

}
