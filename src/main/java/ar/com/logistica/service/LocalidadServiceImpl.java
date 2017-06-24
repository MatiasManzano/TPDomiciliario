package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.LocalidadDAO;
import ar.com.logistica.entity.Localidad;

@Service("localidadService")
@Transactional
public class LocalidadServiceImpl implements LocalidadService {

	@Autowired
	LocalidadDAO localidadDAO;

	@Override
	public Localidad findById(Long idLocalidad) {
		return localidadDAO.findById(idLocalidad);
	}

	@Override
	public Localidad findByNombre(String nombreLocalidad) {
		Localidad localidad = localidadDAO.findByNombre(nombreLocalidad);
		return localidad;
	}

	@Override
	public void save(Localidad localidad) {
		localidadDAO.save(localidad);

	}

	@Override
	public void deleteByNombre(String nombreLocalidad) {
		localidadDAO.deleteByNombre(nombreLocalidad);

	}

	@Override
	public List<Localidad> findAllLocalidades() {
		return localidadDAO.findAllLocalidades();
	}

	@Override
	public void updateLocalidad(Localidad localidad) {
		Localidad entity = localidadDAO.findById(localidad.getIdLocalidad());
		if (entity != null) {
			entity.setNombreLocalidad(localidad.getNombreLocalidad());
			entity.setDirecciones(localidad.getDirecciones());
		}

	}

	@Override
	public boolean isNombreLocalidadUnique(Long idLocalidad, String nombreLocalidad) {
		Localidad localidad = findById(idLocalidad);
		return (localidad == null || ((idLocalidad != null) && (localidad.getIdLocalidad()) == idLocalidad));
	}

}
