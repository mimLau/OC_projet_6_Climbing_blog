package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.PlaceDao;
import org.oc.escalade.model.Place;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaPlaceDao implements PlaceDao {
    private EntityManagerFactory emf;

    public JpaPlaceDao(EntityManagerFactory emf){
        this.emf=emf;
    }
    @Override
    public Place addPlace(Place place) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(place);
            t.commit();
        }finally {
            if(t.isActive()) t.rollback();
        }
        return place;
    }
}
