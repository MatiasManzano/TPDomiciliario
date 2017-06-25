package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Localidad;

@Repository("localidadDAO")
public class LocalidadDAOImpl extends AbstractDao<Long, Localidad> implements LocalidadDAO {

	@Override
	public Localidad findById(Long idLocalidad) {
		Localidad localidad = getByKey(idLocalidad);
		if (localidad != null) {
			Hibernate.initialize(localidad.getDirecciones());
		}
		return localidad;
	}

	@Override
	public Localidad findByNombre(String nombreLocalidad) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombreLocalidad", nombreLocalidad));
		Localidad localidad = (Localidad) criteria.uniqueResult();
		if (localidad != null) {
			Hibernate.initialize(localidad.getDirecciones());
		}
		return localidad;
	}

	@Override
	public void save(Localidad localidad) {
		persist(localidad);

	}

	@Override
	public void deleteByNombre(String nombreLocalidad) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombreLocalidad", nombreLocalidad));
		Localidad localidad = (Localidad) criteria.uniqueResult();
		delete(localidad);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Localidad> findAllLocalidades() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombreLocalidad"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Localidad>) criteria.list();
	}

}
