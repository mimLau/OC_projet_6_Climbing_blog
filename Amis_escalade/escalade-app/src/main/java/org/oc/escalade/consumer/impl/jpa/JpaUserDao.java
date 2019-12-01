package org.oc.escalade.consumer.impl.jpa;

import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;

import javax.persistence.*;

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
            query.setParameter("username", username);
            u = (User) query.getSingleResult();
        }finally {
            em.close();
        }
        return u;
    }

    @Override
    public boolean usernameExists(String username) {
        final EntityManager em = emf.createEntityManager();
        boolean usernameExists = true;
        User u = new User();

        try {
            Query query = em.createQuery("SELECT u FROM User AS u WHERE u.username= :username");
            query.setParameter("username", username);
            try {
                u = (User) query.getSingleResult();
            } catch (NoResultException e) {
                usernameExists = false;
            }
        }finally {
            em.close();
        }
        return usernameExists;
    }

    @Override
    public User findUserByEmail(String email) {
        final EntityManager em = emf.createEntityManager();
        User u = new User();

        try {
            Query query = em.createQuery("SELECT u FROM User AS u WHERE u.email= :email");
            query.setParameter(email, "email");
            u = (User) query.getSingleResult();
        } finally {
            em.close();
        }
        return u;
    }
}
