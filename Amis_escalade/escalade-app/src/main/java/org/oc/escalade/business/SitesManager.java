package org.oc.escalade.business;

import org.oc.escalade.consumers.*;
import org.oc.escalade.models.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public final class SitesManager {

    private SiteDao siteDao = DaoFactory.getSiteDao();
    private PlaceDao placeDao = DaoFactory.getPlaceDao();
    private WayDao wayDao = DaoFactory.getWayDao();
    private LengthDao lengthDao = DaoFactory.getLengthDao();
    private static final String NAME_FIELD = "name";
    private static final String REGION_FIELD = "region";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String ID_PARAMETER_NAME = "id";
    private static final String TAG_PARAMETER_NAME = "tag";
    private static final String OFFICIAL_CHECK_BOX = "official";
    private static final String RATING_FIELD = "rating";
    private static final String SECTOR_NB_FIELD ="sectorsNb";

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
        Long idParameter = Long.parseLong(getParameterValue( req, ID_PARAMETER_NAME ));
        Boolean tag = Boolean.parseBoolean(getParameterValue( req, TAG_PARAMETER_NAME ));
        siteDao.updateTag( idParameter,tag );
    }

    public List<Site> searchSite(HttpServletRequest req ) {
        List<Site> site;
        String region = getParameterValue( req, REGION_FIELD );
        String rating = getParameterValue( req, RATING_FIELD );
        String officialSite = getParameterValue( req, OFFICIAL_CHECK_BOX );
        String sectorNbP = getParameterValue( req, SECTOR_NB_FIELD );
        Boolean tagged = false;
        int sectorNb = 0;
        Place place = null;
        List<Long> siteId = new ArrayList<>();

        if( officialSite != null ) tagged = true;
        if( sectorNbP != null && !sectorNbP.isEmpty() ) sectorNb = Integer.parseInt( sectorNbP );
        if( region != null && !region.isEmpty() ) place = placeDao.getPlaceByRegionName( region );
        if( rating != null && !rating.isEmpty() ) {

             List<Way> ways = wayDao.findWaysByRating( rating );
             List<Length> lengths = lengthDao.findLengthsByRating( rating );

             for( Length length : lengths ) {
                    siteId.add(length.getWay().getSector().getSite().getId());
             }

             for( Way way : ways ) {
                 Long id = way.getSector().getSite().getId();
                 if(!siteId.contains( id )) siteId.add( id );
             }
        }

        site = siteDao.getSiteBySearchParams( place, sectorNb, tagged, siteId );
        return site;
    }

    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
