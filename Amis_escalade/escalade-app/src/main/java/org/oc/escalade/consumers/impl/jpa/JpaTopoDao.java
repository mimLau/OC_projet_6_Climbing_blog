package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.TopoDao;
import org.oc.escalade.models.Topo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JpaTopoDao implements TopoDao {
    private EntityManagerFactory emf;

    public JpaTopoDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Topo addTopo(Topo topo) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist( topo );
            t.commit();
        }finally {
            if(t.isActive()) t.rollback();
        }
        return topo;
    }

    @Override
    public List<Topo> getAllToposByUserId(Long userId) {
        final EntityManager em = emf.createEntityManager();
        List<Topo> topos = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM Topo AS t WHERE t.topoOwner.id= : id");
            query.setParameter("id", userId);
            try {
                topos = (List<Topo>) query.getResultList();
            } catch ( NoResultException noResultE ) {

                topos = null;
            }
        } finally {
            em.close();
        }
        return topos;
    }

    @Override
    public List<Topo> getAllTopos() {
        final EntityManager em = emf.createEntityManager();
        List<Topo> allTopos = new ArrayList<Topo>();

        try {
            Query query = em.createQuery("SELECT t FROM Topo as t");
            try {
                allTopos = (List<Topo>) query.getResultList();
            } catch ( NoResultException noResultE ) {
                allTopos = null;
            }

        } finally {
            em.close();
        }

        return allTopos;
    }

    @Override
    public void updateTopoState(Long topoId, boolean borrowed) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            Query query = em.createQuery("UPDATE Topo t SET t.borrowed= :bool WHERE t.id= :id");
            query.setParameter("bool", borrowed );
            query.setParameter("id", topoId );

            query.executeUpdate();
            t.commit();
        }finally {
            if ( t.isActive() ) {
                t.rollback();
            }
            em.close();
        }
    }
}
