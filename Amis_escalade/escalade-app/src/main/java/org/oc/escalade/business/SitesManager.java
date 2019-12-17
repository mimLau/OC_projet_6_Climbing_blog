package org.oc.escalade.business;

import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.consumers.PlaceDao;
import org.oc.escalade.consumers.SiteDao;
import org.oc.escalade.models.Place;
import org.oc.escalade.models.Site;
import org.oc.escalade.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public final class SitesManager {

    private SiteDao siteDao = DaoFactory.getSiteDao();
    private PlaceDao placeDao = DaoFactory.getPlaceDao();
    private static final String NAME_FIELD = "name";
    private static final String REGION_FIELD = "region";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String ID_PARAMETER_NAME = "id";

    public List<Site> getAllSites() {
         return siteDao.getAllSites();
    }

    private List<String> getAllCountries() {
        List<String> countries = placeDao.getAllDistinctCountries();
        return countries;
    }

    public  Map<String, List<String>> listOfCountriesRegions() {
        Map<String, List<String>> countrysRegions = new LinkedHashMap<>();
        List<String> countries = getAllCountries();
        List<String> regions = new ArrayList<>();
        List<Place> places;

        for( String country:countries ) {
            places = placeDao.getPlaceByCountryName( country );

            for ( Place place : places ) {
                regions.add( place.getRegion() );
            }

            List<String> regionsBis = new ArrayList<>( regions );
            regions.clear();
            countrysRegions.put( country, regionsBis );
        }
        return countrysRegions;
    }

    public Site addSite(HttpServletRequest req) {
        String name = getParameterValue( req, NAME_FIELD );
        String region = getParameterValue( req, REGION_FIELD );
        String description = getParameterValue( req, DESCRIPTION_FIELD );

        User user = (User) req.getSession().getAttribute("user");
        Place place = placeDao.getPlaceByRegionName( region );

        Site site = new Site();
        site.setDescription(description);
        site.setName( name );
        site.setPlace( place );
        site.setSiteOwner( user );

        site = siteDao.addSite( site );
        return site;
    }

    public Site getSiteById( HttpServletRequest req ) {
        String idParameter = getParameterValue(req, ID_PARAMETER_NAME );
        Site requestedSite = new Site();

        if(idParameter != null) {
            try {
                final Long idLong = Long.parseLong( idParameter );
                requestedSite = siteDao.findSiteById( idLong );
            } catch( NumberFormatException nfe ) {
                System.out.println("ERROR: l'id entré n'est pas un nombre.");
            }
        }
        return requestedSite;
    }

    public void updateTag(HttpServletRequest req) {
        String idParameter = getParameterValue(req, ID_PARAMETER_NAME );
        siteDao.updateTag(Long.parseLong(idParameter));
    }

    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }

}
