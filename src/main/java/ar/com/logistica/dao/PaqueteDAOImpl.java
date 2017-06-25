package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Paquete;

@Repository("paqueteDAO")
public class PaqueteDAOImpl extends AbstractDao<Long, Paquete> implements PaqueteDAO{

	@Override
	public Paquete findById(Long idPaquete) {
		Paquete paquete = getByKey(idPaquete);
		if (paquete != null) {
			Hibernate.initialize(paquete.getDescripcion());
		}
		return paquete;
	}

	@Override
	public void save(Paquete paquete) {
		persist(paquete);
		
	}

	@Override
	public void deleteById(Long idPaquete) {
		delete(getByKey(idPaquete));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paquete> findAllPaquetes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Paquete>) criteria.list();
	}

}
