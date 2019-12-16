package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.LengthDao;
import org.oc.escalade.models.Length;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaLengthDao implements LengthDao {
        private EntityManagerFactory emf;

        public JpaLengthDao(EntityManagerFactory emf){
            this.emf=emf;
        }
        @Override
        public Length addLength(Length length) {
            final EntityManager em = emf.createEntityManager();
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(length);
                t.commit();
            }finally {
                if(t.isActive()) t.rollback();
            }
            return length;
        }

}
