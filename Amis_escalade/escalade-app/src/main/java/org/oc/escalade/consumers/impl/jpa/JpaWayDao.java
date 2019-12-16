package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.WayDao;
import org.oc.escalade.models.Way;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Way> getAllWays() {
        final EntityManager em = emf.createEntityManager();
        List<Way> allWays = new ArrayList<Way>();

        try {
            Query query = em.createQuery("SELECT w FROM Way as w");
            allWays = (List<Way>) query.getResultList();

        } finally {
            em.close();
        }

        return allWays;
    }

    @Override
    public Way findWayById( Long id ) {
        final EntityManager em = emf.createEntityManager();
        Way way = new Way();

        try {
            Query query = em.createQuery("SELECT w FROM Way AS w LEFT JOIN FETCH w.lengths WHERE w.id= :id ");
            query.setParameter("id", id);
            way = ( Way) query.getSingleResult();
        } finally {
            em.close();
        }
        return way;
    }

}
