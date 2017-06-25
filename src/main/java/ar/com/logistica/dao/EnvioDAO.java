package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Envio;

public interface EnvioDAO {

	public Envio findByNroEnvio(long nroEnvio);

	public void save(Envio envio);

	public void deleteByNroEnvio(long nroEnvio);

	public List<Envio> findAllEnvios();

}
