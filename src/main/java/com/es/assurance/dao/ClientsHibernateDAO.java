package com.es.assurance.dao;

import java.util.List;

import org.hibernate.Query;

import com.es.assurance.model.Clients;

/**
 * Created by Christophe on 05.11.2015.
 */
public class ClientsHibernateDAO extends GenericHibernateDAO<Clients, Integer> implements ClientsDAO {
	
	

	public List<?> tousLesMembresDeLaMemeFamille() {
		Query query = getSession().createQuery(LISTER_MEMBRE_FAMILLE);
		query.setString("annee", "2014");
		query.setInteger("familleId", 1);
		Object[] resultat = (Object[]) query.list().get(0);
		
		System.out.println("nom \t prenom \t type");
		for (Object object : resultat) {
			System.out.print(object);
		}
		return null;

	}

}
