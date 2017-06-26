package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Envio;

public interface EnvioDAO {

	public Envio findByNroEnvio(long numeroEnvio);

	public void save(Envio envio);

	public void deleteByNroEnvio(long numeroEnvio);

	public List<Envio> findAllEnvios();

}
