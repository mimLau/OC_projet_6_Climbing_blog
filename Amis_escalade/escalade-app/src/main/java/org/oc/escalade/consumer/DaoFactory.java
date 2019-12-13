package org.oc.escalade.consumer;

import org.oc.escalade.consumer.impl.jpa.*;
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

    public static SectorDao getSectorDao() {
        return new JpaSectorDao(
                PersistenceManager.getEntityManagerFactory());
    }

    public static WayDao getWayDao() {
        return new JpaWayDao(
                PersistenceManager.getEntityManagerFactory());
    }
}
