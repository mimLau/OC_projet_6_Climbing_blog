package org.oc.escalade.consumer;

import org.oc.escalade.consumer.impl.jpa.JpaPlaceDao;
import org.oc.escalade.consumer.impl.jpa.JpaSiteDao;
import org.oc.escalade.consumer.impl.jpa.JpaUserDao;
import org.oc.escalade.utils.PersistenceManager;

public class DaoFactory {

    private DaoFactory(){}

    public static UserDao getUserDao(){
        return new JpaUserDao(
            PersistenceManager.getEntityManagerFactory());
        }

    public static PlaceDao getPlaceDao() {
        return new JpaPlaceDao(
                PersistenceManager.getEntityManagerFactory());
    }

    public static SiteDao getSiteDao() {
        return new JpaSiteDao(
                PersistenceManager.getEntityManagerFactory());
    }
}
