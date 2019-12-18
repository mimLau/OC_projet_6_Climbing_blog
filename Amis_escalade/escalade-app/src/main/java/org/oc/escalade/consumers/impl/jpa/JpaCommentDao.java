package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.CommentDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaCommentDao implements CommentDao {
    private EntityManagerFactory emf;

    public JpaCommentDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
