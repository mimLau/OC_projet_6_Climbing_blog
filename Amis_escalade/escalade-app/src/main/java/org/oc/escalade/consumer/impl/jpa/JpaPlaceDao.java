package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.PlaceDao;
import org.oc.escalade.model.Place;

import javax.persistence.*;

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

    @Override
    public Place findPlaceByCountryAndRegion(String country, String region) {
        final EntityManager em = emf.createEntityManager();
        Place placeByCountryAndRegion = new Place();

        try {
            Query query = em.createQuery("SELECT p FROM Place AS p WHERE p.country= :country AND p.region= :region");
            query.setParameter("country" , country);
            query.setParameter("region", region);
           try {
               placeByCountryAndRegion = ( Place ) query.getSingleResult();
           } catch (NoResultException e){
               placeByCountryAndRegion = null;
           }
        } finally {
            em.close();
        }

        return placeByCountryAndRegion;
    }
}