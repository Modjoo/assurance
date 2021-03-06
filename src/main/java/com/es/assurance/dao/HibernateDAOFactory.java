package com.es.assurance.dao;

import com.es.assurance.persistence.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Christophe on 05.11.2015.
 */
public class HibernateDAOFactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	private GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO dao = (GenericHibernateDAO) daoClass.newInstance();
			dao.setSession(getCurrentSession());
			return dao;
		} catch (Exception ex) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
		}
	}

	@Override
	public ClientsHibernateDAO getClientsDAO() {
		// TODO Auto-generated method stub
		return (ClientsHibernateDAO) instantiateDAO(ClientsHibernateDAO.class);
	}

	@Override
	public AdressesHibernateDAO getAdressesDAO() {
		return (AdressesHibernateDAO) instantiateDAO(AdressesHibernateDAO.class);
	}
}
