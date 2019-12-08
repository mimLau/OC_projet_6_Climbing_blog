package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.SiteDao;
import org.oc.escalade.model.Site;

import java.util.ArrayList;
import java.util.List;

public final class SitesBusiness {

    private SiteDao siteDao = DaoFactory.getSiteDao();


    public List<Site> getAllSites() {
         List<Site> allSites = new ArrayList<>();
         return allSites = siteDao.getAllSites();
    }
}
