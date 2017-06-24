package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Transporte;

public interface TransporteDAO {

	public Transporte findByPatente(String patente);
	
	public Transporte findByModelo(String modelo);
	
	public void save(Transporte transporte);
     
	public void deleteByPatente(String patente);
     
	public List<Transporte> findAlltransportes();

}
