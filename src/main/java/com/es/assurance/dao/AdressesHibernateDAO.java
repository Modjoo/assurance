package com.es.assurance.dao;

import com.es.assurance.model.Adresses;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christophe on 05.11.2015.
 */
public class AdressesHibernateDAO extends GenericHibernateDAO<Adresses,Integer> implements AdressesDAO{

    public List<List> findAllWithSQL(){
        Query query = getSession().createQuery(SELECT_ALL);
        List<List> list = query.list();
        if(list.size() > 0){
            return (List<List>) list;
        }else{
            return null;
        }
    }
}
