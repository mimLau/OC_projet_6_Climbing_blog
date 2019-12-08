package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.SiteDao;
import org.oc.escalade.model.Site;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
}
