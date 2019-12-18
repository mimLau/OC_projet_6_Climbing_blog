package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.TopoDao;

import javax.persistence.EntityManagerFactory;

public class JpaTopoDao implements TopoDao {
    private EntityManagerFactory emf;

    public JpaTopoDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
