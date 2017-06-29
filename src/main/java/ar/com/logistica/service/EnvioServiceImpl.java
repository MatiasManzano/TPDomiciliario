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
	public Envio findByNroEnvio(long numeroEnvio) {
		return envioDAO.findByNroEnvio(numeroEnvio);
	}

	@Override
	public void save(Envio envio) {
		envioDAO.save(envio);

	}

	@Override
	public void deleteByNroEnvio(long numeroEnvio) {
		envioDAO.deleteByNroEnvio(numeroEnvio);

	}

	@Override
	public List<Envio> findAllEnvios() {
		return envioDAO.findAllEnvios();
	}

	@Override
	public void updateEnvio(Envio envio) {
		Envio entity = envioDAO.findByNroEnvio(envio.getNumeroEnvio());
		if (entity != null) {
			entity.setCalle(envio.getCalle());
			entity.setNumero(envio.getNumero());
			entity.setPiso(envio.getPiso());
			entity.setDepartamento(envio.getDepartamento());
			entity.setCodigoPostal(envio.getCodigoPostal());
			entity.setLocalidad(envio.getLocalidad());
			entity.setPaquete(envio.getPaquete());
			entity.setCategoriaPaquete(envio.getCategoriaPaquete());
			entity.setTipoPaquete(envio.getTipoPaquete());
			entity.setPeso(envio.getPeso());
			entity.setCantidad(envio.getCantidad());
			entity.setTransporte(envio.getTransporte());
			entity.setRemitente(envio.getRemitente());
			entity.setDestinatario(envio.getDestinatario());
			entity.setImporte(envio.getImporte());
			entity.setNroCertificacion(envio.getNroCertificacion());
		}

	}

	@Override
	public boolean isNroEnvioUnique(Long numeroEnvio) {
		Envio envio = findByNroEnvio(numeroEnvio);
		return (envio == null || ((numeroEnvio != null) && (envio.getNumeroEnvio() == numeroEnvio)));
	}

}
