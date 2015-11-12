package com.es.assurance;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.es.assurance.dao.AdressesHibernateDAO;
import com.es.assurance.dao.DAOFactory;
import com.es.assurance.model.Adresses;
import com.es.assurance.model.Clients;
import com.es.assurance.persistence.HibernateUtil;

/**
 * Hello world! https://mybatis.github.io/mybatis-3/sqlmap-xml.html
 * 
 * 
 * Générer un contrat pour une année donnée
 * 
 */

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);
		session.beginTransaction();
		int i = 0;
		do {

			i = AffichageGUIManager.menuPrincipal();
			
//			factory.getClientsDAO().tousLesMembresDeLaMemeFamille();

			switch (i) {
			case 1:
				List<Clients> client = factory.getClientsDAO().findAll();
				Clients.afficher(client);
				break;
			case 2:
				addRandomClient(factory);
				session.flush(); // bad mais mauvaise configuration pas le temps
									// de changer.
				break;
			case 3:
				List<Clients> client1 = factory.getClientsDAO().findAll();
				Clients elu = AffichageGUIManager.selectionClients(client1);
				menuClient(elu);
				break;
			default:
				break;
			}

		} while (i != 4);

		System.out.println("Bye !");
		System.exit(0);
	}

	public static void menuClient(Clients elu) {
		int choix = AffichageGUIManager.menuClient();
		do {
			switch (choix) {
			case 1:
				
				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}

		} while (choix != 4);
	}

	// addRandomClient(factory);
	// session.getTransaction().commit();

	// AdressesHibernateDAO adressesHibernateDAO = factory.getAdressesDAO();
	// List<Adresses> ad = adressesHibernateDAO.findAll();
	// List<?> adresses = adressesHibernateDAO.findAllWithSQL();
	//
	// Clients client = new Clients();
	// client.setNom("toto");
	// client.setPrenom("tutu");
	// client.setAdresses(adressesHibernateDAO.findById(1, false));
	// client.setTelephone("021/8260858");
	// client.setAnniversaire(new Date(2011,10,5));
	// client.setCompteBancaire("23984390843klkljsdfuioer");
	// session.save(client);
	//
	// session.getTransaction().commit();

	/*
	 * Session session = HibernateUtil.getSessionFactory().openSession();
	 * session.beginTransaction();
	 * 
	 * //Clients client = (Clients) session.get(Clients.class,1); //AdressesHome
	 * adresse = new AdressesHome(session); //Adresses ad = adresse.findById(1);
	 * 
	 * Clients clients = (Clients) session.get(Clients.class,1); Query query =
	 * session.createQuery(
	 * "from Npa as npa, Villes as villes where npa.id=1 and villes=1"); List<?>
	 * list = query.list(); System.out.println(clients.getNom());
	 * clients.setNom("MonCUl"); session.update(clients);
	 * System.out.println(clients.getAdresses().getRues().getRue());
	 * System.out.println(clients.getAdresses().getRues().getNpa().getVilles
	 * ().getNom());
	 * 
	 * session.getTransaction().rollback(); session.getTransaction().commit();
	 * 
	 * //Villes ville = npa.getVilles(); /* session.beginTransaction(); Villes
	 * ville = new Villes(); ville.setNom("toto"); session.save(ville);
	 * session.getTransaction().commit();
	 */
	// session.getTransaction().commit();
	// System.out.println("Hello World!");
	// /**
	// * Ajouter un client
	// * @param factory
	// */

	public static void listerClient(DAOFactory factory) {
		List<Clients> clients = factory.getClientsDAO().findAll();

		for (Clients client : clients) {

		}
	}

	/**
	 * Ajout de client
	 * 
	 * @param factory
	 */
	public static void addRandomClient(DAOFactory factory) {

		System.out.println("Ajouter un client :");
		Clients client = new Clients();
		AdressesHibernateDAO adressesHibernateDAO = factory.getAdressesDAO();
		client.setNom(AffichageGUIManager.question("Inserer son nom :"));
		client.setPrenom(AffichageGUIManager.question("Inserer son prenom :"));

		System.out.println("Affichage de toutes les adresses disponible");
		List<Adresses> ad = factory.getAdressesDAO().findAll();
		Adresses.afficher(ad);

		int idAdresse = Integer.valueOf(AffichageGUIManager.question("Inserer une adresse id :"));
		client.setAdresses(adressesHibernateDAO.findById(idAdresse, false));

		client.setTelephone(AffichageGUIManager.question("Inserer son numero de telephonne :"));

		System.out.println("Insertion d'une date de naissance : ");

		int annee = Integer.valueOf(AffichageGUIManager.question("Annee :"));
		int mois = Integer.valueOf(AffichageGUIManager.question("Mois :"));
		int jours = Integer.valueOf(AffichageGUIManager.question("Jours :"));
		client.setAnniversaire(new Date(annee, mois, jours));

		client.setCompteBancaire(AffichageGUIManager.question("Inserer son numéros de compte banquaire :"));
		factory.getClientsDAO().makePersistent(client);
	}

}
