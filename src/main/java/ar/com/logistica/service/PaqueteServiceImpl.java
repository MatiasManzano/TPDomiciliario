package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.PaqueteDAO;
import ar.com.logistica.entity.Paquete;

@Service("paqueteService")
@Transactional
public class PaqueteServiceImpl implements PaqueteService {

	@Autowired
	PaqueteDAO paqueteDAO;

	@Override
	public Paquete findById(Long idPaquete) {
		return paqueteDAO.findById(idPaquete);
	}

	@Override
	public void save(Paquete paquete) {
		paqueteDAO.save(paquete);
	}

	@Override
	public void deleteById(Long idPaquete) {
		paqueteDAO.deleteById(idPaquete);
	}

	@Override
	public List<Paquete> findAllPaquetes() {
		return paqueteDAO.findAllPaquetes();
	}

	@Override
	public void updatePaquete(Paquete paquete) {
		Paquete entity = paqueteDAO.findById(paquete.getIdPaquete());
		if (entity != null) {
			entity.setDescripcion(paquete.getDescripcion());
			entity.setCategoriaPaquete(paquete.getCategoriaPaquete());
			entity.setTipoPaquete(paquete.getTipoPaquete());
			entity.setNroCertificacion(paquete.getNroCertificacion());
		}

	}

}
