package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.TransporteDAO;
import ar.com.logistica.entity.Transporte;

@Service("transporteService")
@Transactional
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteDAO transporteDAO;

	@Override
	public Transporte findByPatente(String patente) {
		return transporteDAO.findByPatente(patente);
	}
	
	@Override
	public Transporte findByModelo(String modelo) {
		return transporteDAO.findByModelo(modelo);
	}

	@Override
	public void save(Transporte transporte) {
		transporteDAO.save(transporte);
		
	}

	@Override
	public void deleteByPatente(String patente) {
		transporteDAO.deleteByPatente(patente);
		
	}

	@Override
	public List<Transporte> findAlltransportes() {
		return transporteDAO.findAlltransportes();
	}

	@Override
	public void updateTransporte(Transporte transporte) {
		Transporte entity = transporteDAO.findByPatente(transporte.getPatente());
        if(entity!=null){
            entity.setMarca(transporte.getMarca());
            entity.setModelo(transporte.getModelo());
            entity.setColor(transporte.getColor());
            entity.setPatente(transporte.getPatente());
            entity.setAnio(transporte.getAnio());
            entity.setTipo(transporte.getTipo());
        }		
	}

	@Override
	public boolean isTransportePatenteUnique(Long idtransporte, String patente) {
		Transporte transporte = findByPatente(patente);
        return ( transporte == null || ((idtransporte != null) && (transporte.getIdTransporte() == idtransporte)));
	}

}
