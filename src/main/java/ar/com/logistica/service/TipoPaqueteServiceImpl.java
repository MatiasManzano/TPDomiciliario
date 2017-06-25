package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.TipoPaqueteDAO;
import ar.com.logistica.entity.CategoriaPaquete;
import ar.com.logistica.entity.TipoPaquete;

@Service("tipoPaqueteService")
@Transactional
public class TipoPaqueteServiceImpl implements TipoPaqueteService {

	@Autowired
	TipoPaqueteDAO tipoPaqueteDAO;

	@Override
	public TipoPaquete findById(Long idTipoPaquete) {
		return tipoPaqueteDAO.findById(idTipoPaquete);
	}

	@Override
	public TipoPaquete findByDescripcion(String descripcion) {
		TipoPaquete tipoPaquete = tipoPaqueteDAO.findByDescripcion(descripcion);
		return tipoPaquete;
	}

	@Override
	public void save(TipoPaquete tipoPaquete) {
		tipoPaqueteDAO.save(tipoPaquete);
	}

	@Override
	public void deleteByDescripcion(String descripcion) {
		tipoPaqueteDAO.deleteByDescripcion(descripcion);
	}

	@Override
	public List<TipoPaquete> findAllTiposPaquete() {
		return tipoPaqueteDAO.findAllTiposPaquete();
	}

	@Override
	public void updateTipoPaquete(TipoPaquete tipoPaquete) {
		TipoPaquete entity = tipoPaqueteDAO.findById(tipoPaquete.getIdTipoPaquete());
		if (entity != null) {
			entity.setDescripcion(tipoPaquete.getDescripcion());
		}
	}

	@Override
	public boolean isDescripcionUnique(Long idTipoPaquete, String descripcion) {
		TipoPaquete tipoPaquete = findById(idTipoPaquete);
		return (tipoPaquete == null || ((idTipoPaquete != null) && (tipoPaquete.getIdTipoPaquete()) == idTipoPaquete));
	}

}
