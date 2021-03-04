package com.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.restapi.model.OdishaPops;
@Repository
public class RestApiDAO {
	
private static final Logger logger = Logger.getLogger(RestApiDAO.class);
	
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEntityManager() {
		return em;
	}


	@SuppressWarnings("unchecked")
	public List<OdishaPops> getOdishaPops() {
		logger.info("Dao.......");
		return (List<OdishaPops>)getEntityManager().createQuery("Select * from " + OdishaPops.class.getSimpleName() + " odisha_pops").getResultList();
	}

}
