package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.ProvinciaDAO;
import ar.com.logistica.entity.Provincia;
import ar.com.logistica.entity.Transporte;

@Service("provinciaService")
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService{
	
	@Autowired
	ProvinciaDAO provinciaDAO;

	@Override
	public Provincia findById(Long idProvincia) {
		return provinciaDAO.findById(idProvincia);
	}

	@Override
	public Provincia findByNombre(String nombreProvincia) {
		return provinciaDAO.findByNombre(nombreProvincia);
	}

	@Override
	public void save(Provincia provincia) {
		provinciaDAO.save(provincia);
		
	}

	@Override
	public void deleteByNombre(String nombreProvincia) {
		provinciaDAO.deleteByNombre(nombreProvincia);
		
	}

	@Override
	public List<Provincia> findAllProvincias() {
		return provinciaDAO.findAllProvincias();
	}

	@Override
	public void updateProvincia(Provincia provincia) {
		Provincia entity = provinciaDAO.findById(provincia.getIdProvincia());
        if(entity!=null){
            entity.setNombreProvinia(provincia.getNombreProvinia());
            entity.setPais(provincia.getPais());
            entity.setLocalidades(provincia.getLocalidades());
        }		
		
	}

	@Override
	public boolean isNombreProvinciaUnique(Long idProvincia, String nombreProvincia) {
		Provincia provincia = findByNombre(nombreProvincia);
        return ( provincia == null || ((idProvincia != null) && (provincia.getIdProvincia() == idProvincia)));
	}

}
