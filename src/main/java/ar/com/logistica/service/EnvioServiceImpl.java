package ar.com.logistica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.logistica.dao.EnvioDAO;
import ar.com.logistica.entity.Envio;

@Service("envioService")
@Transactional
public class EnvioServiceImpl implements EnvioService {

	@Autowired
	EnvioDAO envioDAO;

	@Override
	public Envio findByNroEnvio(long nroEnvio) {
		return envioDAO.findByNroEnvio(nroEnvio);
	}

	@Override
	public void save(Envio envio) {
		envioDAO.save(envio);

	}

	@Override
	public void deleteByNroEnvio(long nroEnvio) {
		envioDAO.deleteByNroEnvio(nroEnvio);

	}

	@Override
	public List<Envio> findAllEnvios() {
		return envioDAO.findAllEnvios();
	}

	@Override
	public void updateEnvio(Envio envio) {
		Envio entity = envioDAO.findByNroEnvio(envio.getNumeroEnvio());
		if (entity != null) {
			entity.setDireccionOrigen(envio.getDireccionOrigen());
			entity.setDireccionDestino(envio.getDireccionDestino());
			entity.setPaquete(envio.getPaquete());
			entity.setPeso(envio.getPeso());
			entity.setCantidad(envio.getCantidad());
			entity.setTransporte(envio.getTransporte());
			entity.setRemitente(envio.getRemitente());
			entity.setDestinatario(envio.getDestinatario());
			entity.setFechaEnvio(envio.getFechaEnvio());
			entity.setFechaEntrega(envio.getFechaEntrega());
			entity.setImporte(envio.getImporte());
		}

	}

	@Override
	public boolean isNroEnvioUnique(Long nroEnvio) {
		Envio envio = findByNroEnvio(nroEnvio);
		return (envio == null || ((nroEnvio != null) && (envio.getNumeroEnvio() == nroEnvio)));
	}

}
