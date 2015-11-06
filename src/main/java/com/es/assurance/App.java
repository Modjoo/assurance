package com.es.assurance;

import com.es.assurance.dao.AdressesHibernateDAO;
import com.es.assurance.dao.DAOFactory;
import com.es.assurance.model.Adresses;
import com.es.assurance.persistence.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Hello world!
 *https://mybatis.github.io/mybatis-3/sqlmap-xml.html
 */

public class App 
{
    @PersistenceUnit(unitName = "test")
    private static EntityManagerFactory entityManagerFactory;

    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Print out all required information
        //System.out.println("Session Is Opened :: "+session.isOpen());
        //System.out.println("Session Is Connected :: " + session.isConnected());

        DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AdressesHibernateDAO adressesHibernateDAO = factory.getAdressesDAO();
        List<Adresses> ad = adressesHibernateDAO.findAll();
        List<?> adresses = adressesHibernateDAO.findAllWithSQL();
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Clients client = (Clients) session.get(Clients.class,1);
        //AdressesHome adresse = new AdressesHome(session);
        //Adresses ad = adresse.findById(1);

        Clients clients = (Clients) session.get(Clients.class,1);
        Query query = session.createQuery("from Npa as npa, Villes as villes where npa.id=1 and villes=1");
        List<?> list = query.list();
        System.out.println(clients.getNom());
        clients.setNom("MonCUl");
        session.update(clients);
        System.out.println(clients.getAdresses().getRues().getRue());
        System.out.println(clients.getAdresses().getRues().getNpa().getVilles().getNom());

        session.getTransaction().rollback();
        session.getTransaction().commit();

        //Villes ville = npa.getVilles();
        /*
        session.beginTransaction();
        Villes ville = new Villes();
        ville.setNom("toto");
        session.save(ville);
        session.getTransaction().commit();
        */
        //session.getTransaction().commit();
        System.out.println("Hello World!");
        System.exit(0);
    }
}
