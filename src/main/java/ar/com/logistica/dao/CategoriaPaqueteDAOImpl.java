package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.CategoriaPaquete;

@Repository("categoriaPaqueteDAO")
public class CategoriaPaqueteDAOImpl extends AbstractDao<Long, CategoriaPaquete> implements CategoriaPaqueteDAO{

	@Override
	public CategoriaPaquete findById(Long idCategoriaPaquete) {
		CategoriaPaquete categoriaPaquete = getByKey(idCategoriaPaquete);
		if (categoriaPaquete != null) {
			Hibernate.initialize(categoriaPaquete.getDescripcion());
		}
		return categoriaPaquete;
	}

	@Override
	public CategoriaPaquete findByDescripcion(String descripcion) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("descripcion", descripcion));
		CategoriaPaquete categoriaPaquete = (CategoriaPaquete) criteria.uniqueResult();
		if (categoriaPaquete != null) {
			Hibernate.initialize(categoriaPaquete.getDescripcion());
		}
		return categoriaPaquete;
	}

	@Override
	public void save(CategoriaPaquete categoriaPaquete) {
		persist(categoriaPaquete);
		
	}

	@Override
	public void deleteByDescripcion(String descripcion) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("descripcion", descripcion));
		CategoriaPaquete categoriaPaquete = (CategoriaPaquete) criteria.uniqueResult();
		delete(categoriaPaquete);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaPaquete> findAllCategoriasPaquete() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<CategoriaPaquete>) criteria.list();
	}

}
