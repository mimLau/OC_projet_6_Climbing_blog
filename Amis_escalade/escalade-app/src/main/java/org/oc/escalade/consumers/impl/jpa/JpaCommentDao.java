package org.oc.escalade.consumers.impl.jpa;

import org.oc.escalade.consumers.CommentDao;
import org.oc.escalade.models.Comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaCommentDao implements CommentDao {
    private EntityManagerFactory emf;

    public JpaCommentDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Comment addComment(Comment comment) {
       final  EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(comment);
            t.commit();
        } finally {
            if( t.isActive() ) t.rollback();
        }
        return comment;
    }
}
