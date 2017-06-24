package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Transporte;

@Repository("transporteDAO")
public class TransporteDAOimpl extends AbstractDao<Long, Transporte> implements TransporteDAO {

	@Override
	public Transporte findByPatente(String patente) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("patente", patente));
		Transporte transporte = (Transporte) criteria.uniqueResult();
		if (transporte != null) {
			Hibernate.initialize(transporte.getMarca());
		}
		return transporte;
	}

	public Transporte findByModelo(String modelo) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("modelo", modelo));
		Transporte transporte = (Transporte) criteria.uniqueResult();
		if (transporte != null) {
			Hibernate.initialize(transporte.getMarca());
		}
		return transporte;
	}

	@Override
	public void save(Transporte transporte) {
		persist(transporte);
	}

	@Override
	public void deleteByPatente(String patente) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("patente", patente));
		Transporte transporte = (Transporte) criteria.uniqueResult();
		delete(transporte);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transporte> findAlltransportes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("patente"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		List<Transporte> transportes = (List<Transporte>) criteria.list();

		// No need to fetch userProfiles since we are not showing them on list
		// page. Let them lazy load.
		// Uncomment below lines for eagerly fetching of userProfiles if you
		// want.
		/*
		 * for(Transporte transporte : transporte){
		 * Hibernate.initialize(transporte.getUserProfiles()); }
		 */
		return transportes;
	}

}
