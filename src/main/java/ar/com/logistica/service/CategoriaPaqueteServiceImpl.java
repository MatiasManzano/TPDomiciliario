package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.CategoriaPaqueteDAO;
import ar.com.logistica.entity.CategoriaPaquete;

@Service("categoriaPaqueteService")
@Transactional
public class CategoriaPaqueteServiceImpl implements CategoriaPaqueteService {

	@Autowired
	CategoriaPaqueteDAO categoriaPaqueteDAO;

	@Override
	public CategoriaPaquete findById(Long idCategoriaPaquete) {
		return categoriaPaqueteDAO.findById(idCategoriaPaquete);
	}

	@Override
	public CategoriaPaquete findByDescripcion(String descripcion) {
		CategoriaPaquete categoriaPaquete = categoriaPaqueteDAO.findByDescripcion(descripcion);
		return categoriaPaquete;
	}

	@Override
	public void save(CategoriaPaquete categoriaPaquete) {
		categoriaPaqueteDAO.save(categoriaPaquete);

	}

	@Override
	public void deleteByDescripcion(String descripcion) {
		categoriaPaqueteDAO.deleteByDescripcion(descripcion);

	}

	@Override
	public List<CategoriaPaquete> findAllCategoriasPaquete() {
		return categoriaPaqueteDAO.findAllCategoriasPaquete();
	}

	@Override
	public void updateCategoriaPaquete(CategoriaPaquete categoriaPaquete) {
		CategoriaPaquete entity = categoriaPaqueteDAO.findById(categoriaPaquete.getIdCategoriaPaquete());
		if (entity != null) {
			entity.setDescripcion(categoriaPaquete.getDescripcion());
		}

	}

	@Override
	public boolean isDescripcionUnique(Long idCategoriaPaquete, String descripcion) {
		CategoriaPaquete categoriaPaquete = findById(idCategoriaPaquete);
		return (categoriaPaquete == null || ((idCategoriaPaquete != null) && (categoriaPaquete.getIdCategoriaPaquete()) == idCategoriaPaquete));
	}

}
