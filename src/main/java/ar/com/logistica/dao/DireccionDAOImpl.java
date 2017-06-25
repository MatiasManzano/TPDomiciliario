package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Direccion;

@Repository("direccionDAO")
public class DireccionDAOImpl extends AbstractDao<Long, Direccion> implements DireccionDAO {

	@Override
	public Direccion findById(Long idDireccion) {
		Direccion direccion = getByKey(idDireccion);
		if (direccion != null) {
			Hibernate.initialize(direccion.getCalle());
		}
		return direccion;
	}

	@Override
	public Direccion findByCalle(String calle) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("calle", calle));
		Direccion direccion = (Direccion) criteria.uniqueResult();
		if (direccion != null) {
			Hibernate.initialize(direccion.getCalle());
		}
		return direccion;
	}

	@Override
	public void save(Direccion direccion) {
		persist(direccion);

	}

	@Override
	public void deleteByCalle(String calle) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("calle", calle));
		Direccion direccion = (Direccion) criteria.uniqueResult();
		delete(direccion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direccion> findAllDirecciones() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("calle"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Direccion>) criteria.list();
	}

}
