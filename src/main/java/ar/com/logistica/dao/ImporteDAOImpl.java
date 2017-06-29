package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Importe;
import ar.com.logistica.entity.Localidad;

@Repository("importeDAO")
public class ImporteDAOImpl extends AbstractDao<Long, Importe> implements ImporteDAO {

	@Override
	public Importe findByLocalidad(Localidad localidad) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("localidad", localidad));
		Importe importe = (Importe) criteria.uniqueResult();
		if (importe != null) {
			Hibernate.initialize(importe.getLocalidad());
		}
		return importe;
	}

	@Override
	public void save(Importe importe) {
		persist(importe);

	}

	@Override
	public void deleteByLocalidad(long localidad) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("localidad", localidad));
		Importe importe = (Importe) criteria.uniqueResult();
		delete(importe);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Importe> findAllImportes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombreLocalidad"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Importe>) criteria.list();
	}

}
