package ar.com.logistica.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.ImporteDAO;

import ar.com.logistica.entity.Importe;
import ar.com.logistica.entity.Localidad;

@Service("importeService")
@Transactional
public class ImporteServiceImpl implements ImporteService{
	
	@Autowired
	ImporteDAO importeDAO;

	@Override
	public Importe findByLocalidad(Localidad localidad) {
		Importe importe = importeDAO.findByLocalidad(localidad);
		return importe;
	}

	@Override
	public void save(Importe importe) {
		importeDAO.save(importe);
		
	}

	@Override
	public void deleteByLocalidad(long localidad) {
		importeDAO.deleteByLocalidad(localidad);
		
	}

	@Override
	public List<Importe> findAllImportes() {
		return importeDAO.findAllImportes();
	}

	@Override
	public void updateImporte(Importe importe) {
		Importe entity = importeDAO.findByLocalidad(importe.getLocalidad());
		if (entity != null) {
			entity.setLocalidad(importe.getLocalidad());
			entity.setBasico(importe.getBasico());
			entity.setAlojamiento(importe.getAlojamiento());
			entity.setComidas(importe.getComidas());
			entity.setCombustible(importe.getCombustible());
			entity.setPeajes(importe.getPeajes());
			entity.setAduana(importe.getAduana());
		}		
	}
	
	public double importeTotal(Importe importe) {

		return importe.getBasico() + importe.getAlojamiento() + importe.getComidas() + importe.getCombustible()
				+ importe.getPeajes() + importe.getAduana();

	}

}
