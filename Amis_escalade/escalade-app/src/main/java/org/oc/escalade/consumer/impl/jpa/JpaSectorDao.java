package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.SectorDao;
import org.oc.escalade.model.Sector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaSectorDao implements SectorDao {
    private EntityManagerFactory emf;

    public JpaSectorDao(EntityManagerFactory emf){
        this.emf=emf;
    }

    @Override
    public Sector addSector(Sector sector) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(sector);
            t.commit();
        }finally {
            if(t.isActive()) t.rollback();
        }
        return sector;
    }
}
