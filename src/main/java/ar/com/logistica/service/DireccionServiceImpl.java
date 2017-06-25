package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.DireccionDAO;
import ar.com.logistica.entity.Direccion;
import ar.com.logistica.entity.Pais;

@Service("direccionService")
@Transactional
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	DireccionDAO direccionDAO;

	@Override
	public Direccion findById(Long idDireccion) {
		return direccionDAO.findById(idDireccion);
	}

	@Override
	public Direccion findByCalle(String calle) {
		Direccion direccion = direccionDAO.findByCalle(calle);
		return direccion;
	}

	@Override
	public void save(Direccion direccion) {
		direccionDAO.save(direccion);
		
	}

	@Override
	public void deleteByCalle(String calle) {
		direccionDAO.deleteByCalle(calle);
		
	}

	@Override
	public List<Direccion> findAllDirecciones() {
		return direccionDAO.findAllDirecciones();
	}

	@Override
	public void updateDireccion(Direccion direccion) {
		Direccion entity = direccionDAO.findById(direccion.getIdDireccion());
		if (entity != null) {
			entity.setCalle(direccion.getCalle());
			entity.setNumero(direccion.getNumero());
			entity.setPiso(direccion.getPiso());
			entity.setDepartamento(direccion.getDepartamento());
			entity.setCodigoPostal(direccion.getCodigoPostal());
			entity.setLocalidad(direccion.getLocalidad());
		}
		
	}

	@Override
	public boolean isCalleDireccionUnique(Long idDireccion, String calle) {
		Direccion direccion = findById(idDireccion);
        return ( direccion == null || ((idDireccion != null) && (direccion.getIdDireccion()) == idDireccion));
	}

}
