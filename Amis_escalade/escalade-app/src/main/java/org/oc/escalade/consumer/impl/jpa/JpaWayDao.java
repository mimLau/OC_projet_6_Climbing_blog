package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.WayDao;
import org.oc.escalade.model.Way;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaWayDao implements WayDao {
  private EntityManagerFactory emf;

  public JpaWayDao(EntityManagerFactory emf) {
      this.emf = emf;
  }


    @Override
    public Way addWay(Way way) {
      final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(way);
            t.commit();
        } finally {
            if( t.isActive() ) t.rollback();
        }
        return way;
    }
}
