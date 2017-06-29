package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Importe;
import ar.com.logistica.entity.Localidad;

public interface ImporteDAO {
	
	public Importe findByLocalidad(Localidad localidad);

	public void save(Importe importe);

	public void deleteByLocalidad(long localidad);

	public List<Importe> findAllImportes();


}
