package fr.pizzeria.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Class to connect application with database using JPA
 * 
 * @author Sandra Le Thiec
 *
 */
public class DbManagerJPA {
	/* ATTRIBUTES */
	/**
	 * An Object to manage database access
	 */
	private static DbManagerJPA singleton;
	
	/**
	 * An entity manager factory
	 */
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");
	
	/**
	 * An entity manager
	 */
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	/**
	 * An entity transaction
	 */
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	/* CONSTRUCTOR */
	/**
	 * private constructor
	 */
	private DbManagerJPA() {
		
	}

	/**
	 * 
	 * @return instance of this class
	 */
	public static synchronized DbManagerJPA getInstance() {
		if (singleton == null) {
			synchronized (DbManagerJPA.class) {
				singleton = new DbManagerJPA();
			}
		}
		return singleton;
	}
	
	

	/* GETTERS AND SETTERS */
	/**
	 * @return the entityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		if(!entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");
		}
		return entityManagerFactory;
	}

	/**
	 * @param entityManagerFactory the entityManagerFactory to set
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		if(!entityManager.isOpen()) {
			entityManager = this.getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @return the entityTransaction
	 */
	public EntityTransaction getEntityTransaction() {
		if(!entityTransaction.isActive()) {
			entityTransaction = this.getEntityManager().getTransaction();
		}
		return entityTransaction;
	}

	/**
	 * @param entityTransaction the entityTransaction to set
	 */
	public void setEntityTransaction(EntityTransaction entityTransaction) {
		this.entityTransaction = entityTransaction;
	}
	
	

	

	

}
