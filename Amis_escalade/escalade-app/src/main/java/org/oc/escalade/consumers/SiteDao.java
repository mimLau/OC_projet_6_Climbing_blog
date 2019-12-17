package org.oc.escalade.consumers;

import org.oc.escalade.models.Site;

import java.util.List;

public interface SiteDao {

     List<Site> getAllSites();
     Site addSite(Site site);
     Site findSiteById(long id);
     void updateNbOfSectors(Long id);
}
