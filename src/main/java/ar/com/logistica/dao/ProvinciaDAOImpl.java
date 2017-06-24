package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Provincia;

@Repository("provinciaDAO")
public class ProvinciaDAOImpl extends AbstractDao<Long, Provincia> implements ProvinciaDAO{

	@Override
	public Provincia findById(Long idProvincia) {
		Provincia provincia = getByKey(idProvincia);
		if (provincia != null) {
			Hibernate.initialize(provincia.getLocalidades());
		}
		return provincia;
	}

	@Override
	public Provincia findByNombre(String nombreProvincia) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombreProvincia", nombreProvincia));
		Provincia provincia = (Provincia) criteria.uniqueResult();
		if (provincia != null) {
			Hibernate.initialize(provincia.getLocalidades());
		}
		return provincia;
	}

	@Override
	public void save(Provincia provincia) {
		persist(provincia);
		
	}

	@Override
	public void deleteByNombre(String nombreProvincia) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombre", nombreProvincia));
		Provincia provincia = (Provincia) criteria.uniqueResult();
		delete(provincia);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findAllProvincias() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombreProvincia"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Provincia>) criteria.list();
	}

}
