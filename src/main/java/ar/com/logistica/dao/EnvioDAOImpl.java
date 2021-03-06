package ar.com.logistica.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.logistica.entity.Direccion;
import ar.com.logistica.entity.Envio;
import ar.com.logistica.entity.Transporte;

@Repository("envioDAO")
public class EnvioDAOImpl extends AbstractDao<Long, Envio> implements EnvioDAO{

	@Override
	public Envio findByNroEnvio(long numeroEnvio) {
		Envio envio = getByKey(numeroEnvio);
		if (envio != null) {
			Hibernate.initialize(envio.getDestinatario());
		}
		return envio;
	}

	@Override
	public void save(Envio envio) {
		persist(envio);
		
	}

	@Override
	public void deleteByNroEnvio(long numeroEnvio) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("numeroEnvio", numeroEnvio));
		Envio envio = (Envio) criteria.uniqueResult();
		delete(envio);
		
	}

	@Override
	public List<Envio> findAllEnvios() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("numeroEnvio"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Envio> envios = (List<Envio>) criteria.list();
		return envios;
	}

}
