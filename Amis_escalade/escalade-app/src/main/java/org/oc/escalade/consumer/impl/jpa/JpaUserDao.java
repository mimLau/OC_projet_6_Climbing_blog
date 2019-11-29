package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JpaUserDao implements UserDao {
    private EntityManagerFactory emf;

    public JpaUserDao(EntityManagerFactory emf){
        this.emf=emf;
    }

    @Override
    public User addUser(User user) {
        final EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(user);
            t.commit();
        }finally {
            if(t.isActive()) t.rollback();
        }

        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        final EntityManager em = emf.createEntityManager();
        User u = new User();

        try {
            Query query = em.createQuery("SELECT u FROM User AS u WHERE u.username= :username");
            query.setParameter("name", username);
            u = (User) query.getSingleResult();
        }finally {
            em.close();
        }
        return u;
    }
}
