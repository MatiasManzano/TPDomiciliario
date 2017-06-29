package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Importe;
import ar.com.logistica.entity.Localidad;


public interface ImporteService {
	
	public Importe findByLocalidad(Localidad localidad);

	public void save(Importe importe);

	public void deleteByLocalidad(long localidad);

	public List<Importe> findAllImportes();
	
	public void updateImporte(Importe importe);
	
	public double importeTotal(Importe importe);

}
