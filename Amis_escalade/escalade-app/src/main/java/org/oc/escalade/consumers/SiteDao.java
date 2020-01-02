package org.oc.escalade.consumers;

import org.oc.escalade.models.Place;
import org.oc.escalade.models.Site;

import java.util.List;

public interface SiteDao {

     List<Site> getAllSites();
     Site addSite(Site site);
     Site findSiteById( Long id );
     void updateNbOfSectors( Long id );
     void updateTag( Long id, Boolean tag );
     List<Site> getSitesByPlaceId( Long placeId );
     List<Site> getSiteBySearchParams(Place place, int nbOfSectors, Boolean tagged, List<Long> siteIds );
}
