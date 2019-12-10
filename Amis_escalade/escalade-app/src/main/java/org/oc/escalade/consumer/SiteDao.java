package org.oc.escalade.consumer;

import org.oc.escalade.model.Site;

import java.util.ArrayList;
import java.util.List;

public interface SiteDao {

     List<Site> getAllSites();
     Site addSite(Site site);
}
