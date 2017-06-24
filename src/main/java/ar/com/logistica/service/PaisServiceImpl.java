package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.PaisDAO;
import ar.com.logistica.entity.Pais;

@Service("paisService")
@Transactional
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisDAO paisDAO;

	@Override
	public Pais findById(Long idPais) {
		return paisDAO.findById(idPais);
	}

	@Override
	public Pais findByNombre(String nombrePais) {
		Pais pais = paisDAO.findByNombre(nombrePais);
		return pais;
	}

	@Override
	public void save(Pais pais) {
		paisDAO.save(pais);
	}

	@Override
	public void deleteByNombre(String nombrePais) {
		paisDAO.deleteByNombre(nombrePais);
	}

	@Override
	public List<Pais> findAllPaises() {
		return paisDAO.findAllPaises();
	}

	@Override
	public void updatePais(Pais pais) {
		Pais entity = paisDAO.findById(pais.getIdPais());
		if (entity != null) {
			entity.setNombrePais(pais.getNombrePais());
			entity.setProvincias(pais.getProvincias());
		}
	}

	@Override
	public boolean isNombrePaisUnique(Long idPais, String nombrePais) {
		Pais pais = findById(idPais);
        return ( pais == null || ((idPais != null) && (pais.getIdPais()) == idPais));
	}

}
