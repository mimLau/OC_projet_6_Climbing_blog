package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.SiteDao;
import org.oc.escalade.models.Site;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class JpaSiteDao implements SiteDao {
    private EntityManagerFactory emf;

    public JpaSiteDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Site> getAllSites() {
        final EntityManager em = emf.createEntityManager();
        List<Site> allSites = new ArrayList<Site>();

        try {
            Query query = em.createQuery("SELECT s FROM Site as s");
            allSites = (List<Site>) query.getResultList();

        } finally {
            em.close();
        }

        return allSites;
    }

    @Override
    public Site addSite(Site site) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(site);
            t.commit();
        }finally {
            if(t.isActive()) t.rollback();
        }
        return site;
    }

    @Override
    public Site findSiteById(long id) {
        final EntityManager em = emf.createEntityManager();
        Site site = new Site();

        try {
            Query query = em.createQuery("SELECT DISTINCT s FROM Site AS s LEFT JOIN FETCH s.sectors  WHERE s.id= :id ");
            query.setParameter("id", id);
            site = (Site) query.getSingleResult();

            Query  query2 = em.createQuery("SELECT DISTINCT s FROM Site AS s LEFT JOIN FETCH s.comments WHERE  s IN :site");
            query2.setParameter("site", site);
            site = (Site) query2.getSingleResult();

        } finally {
            em.close();
        }
        return site;
    }

    @Override
    public void updateNbOfSectors(Long id) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            Query query = em.createQuery("UPDATE Site s SET s.nbOfSectors = s.nbOfSectors + :increment WHERE s.id= :id");
            query.setParameter("increment", 1);
            query.setParameter("id", id);

            query.executeUpdate();
            t.commit();
        }finally {
            if ( t.isActive() ) {
                t.rollback();
            }
                em.close();
            }
        }

    @Override
    public void updateTag(Long sitId) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            Query query = em.createQuery("UPDATE Site s SET s.tagged = true WHERE s.id= :id");
            query.setParameter("id", sitId);

            query.executeUpdate();
            t.commit();
        }finally {
            if ( t.isActive() ) {
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public List<Site> getSitesByPlaceId(Long placeId) {
        final EntityManager em = emf.createEntityManager();
        List<Site> sites = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT s FROM Site AS s  WHERE s.place.id= :id ");
            query.setParameter("id", placeId);
            sites = (List<Site>) query.getResultList();



        } finally {
            em.close();
        }
        return sites;
    }
}
