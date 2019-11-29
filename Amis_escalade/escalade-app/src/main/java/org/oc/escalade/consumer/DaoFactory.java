package org.oc.escalade.consumer;

import org.oc.escalade.consumer.impl.jpa.JpaUserDao;
import org.oc.escalade.model.User;
import org.oc.escalade.utils.PersistenceManager;

public class DaoFactory {

    private DaoFactory(){}

    public static UserDao getUserDao(){
        return new JpaUserDao(
            PersistenceManager.getEntityManagerFactory());
        }
}
