package wollits.hibernate;

// Generated Jun 14, 2014 7:45:28 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LocationTypes.
 * @see wollits.hibernate.LocationTypes
 * @author Hibernate Tools
 */
@Stateless
public class LocationTypesHome {

	private static final Log log = LogFactory.getLog(LocationTypesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LocationTypes transientInstance) {
		log.debug("persisting LocationTypes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LocationTypes persistentInstance) {
		log.debug("removing LocationTypes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LocationTypes merge(LocationTypes detachedInstance) {
		log.debug("merging LocationTypes instance");
		try {
			LocationTypes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LocationTypes findById(int id) {
		log.debug("getting LocationTypes instance with id: " + id);
		try {
			LocationTypes instance = entityManager
					.find(LocationTypes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
