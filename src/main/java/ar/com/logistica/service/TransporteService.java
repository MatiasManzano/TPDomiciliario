package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Transporte;

public interface TransporteService {

	public Transporte findByPatente(String patente);
	
	public Transporte findByModelo(String modelo);
	
	public void save(Transporte transporte);
     
	public void deleteByPatente(String patente);
     
	public List<Transporte> findAlltransportes();
     
	public void updateTransporte(Transporte transporte);
	
	public boolean isTransportePatenteUnique(Long idtransporte, String patente);
	
}