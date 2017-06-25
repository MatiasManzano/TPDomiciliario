package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.TipoPaquete;

@Repository("tipoPaqueteDAO")
public class TipoPaqueteDAOImpl extends AbstractDao<Long, TipoPaquete> implements TipoPaqueteDAO{

	@Override
	public TipoPaquete findById(Long idTipoPaquete) {
		TipoPaquete tipoPaquete = getByKey(idTipoPaquete);
		if (tipoPaquete != null) {
			Hibernate.initialize(tipoPaquete.getDescripcion());
		}
		return tipoPaquete;
	}

	@Override
	public TipoPaquete findByDescripcion(String descripcion) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("descripcion", descripcion));
		TipoPaquete tipoPaquete = (TipoPaquete) criteria.uniqueResult();
		if (tipoPaquete != null) {
			Hibernate.initialize(tipoPaquete.getDescripcion());
		}
		return tipoPaquete;
	}

	@Override
	public void save(TipoPaquete tipoPaquete) {
		persist(tipoPaquete);
		
	}

	@Override
	public void deleteByDescripcion(String descripcion) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("descripcion", descripcion));
		TipoPaquete tipoPaquete = (TipoPaquete) criteria.uniqueResult();
		delete(tipoPaquete);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPaquete> findAllTiposPaquete() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<TipoPaquete>) criteria.list();
	
	}

}
