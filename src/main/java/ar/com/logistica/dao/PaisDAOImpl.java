package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Pais;

@Repository("paisDAO")
public class PaisDAOImpl extends AbstractDao<Long, Pais> implements PaisDAO {

	@Override
	public Pais findById(Long idPais) {
		Pais pais = getByKey(idPais);
		if (pais != null) {
			Hibernate.initialize(pais.getProvincias());
		}
		return pais;
	}

	@Override
	public Pais findByNombre(String nombrePais) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombrePais", nombrePais));
		Pais pais = (Pais) criteria.uniqueResult();
		if (pais != null) {
			Hibernate.initialize(pais.getProvincias());
		}
		return pais;
	}

	@Override
	public void save(Pais pais) {
		persist(pais);

	}

	@Override
	public void deleteByNombre(String nombrePais) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombrePais", nombrePais));
		Pais pais = (Pais) criteria.uniqueResult();
		delete(pais);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findAllPaises() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombrePais"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		return (List<Pais>) criteria.list();
		
	}

}
