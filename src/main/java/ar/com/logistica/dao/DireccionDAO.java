package ar.com.logistica.dao;

import java.util.List;

import ar.com.logistica.entity.Direccion;

public interface DireccionDAO {

	public Direccion findById(Long idDireccion);

	public Direccion findByCalle(String calle);

	public void save(Direccion direccion);

	public void deleteByCalle(String calle);

	public List<Direccion> findAllDirecciones();

}
