package ar.com.logistica.service;

import java.util.List;

import ar.com.logistica.entity.Envio;

public interface EnvioService {

	public Envio findByNroEnvio(long nroEnvio);

	public void save(Envio envio);

	public void deleteByNroEnvio(long nroEnvio);

	public List<Envio> findAllEnvios();

	public void updateEnvio(Envio envio);

	public boolean isNroEnvioUnique(Long nroEnvio);

}
