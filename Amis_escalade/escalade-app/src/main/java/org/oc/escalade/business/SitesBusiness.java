package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.PlaceDao;
import org.oc.escalade.consumer.SiteDao;
import org.oc.escalade.model.Place;
import org.oc.escalade.model.Site;
import org.oc.escalade.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public final class SitesBusiness {

    private SiteDao siteDao = DaoFactory.getSiteDao();
    private PlaceDao placeDao = DaoFactory.getPlaceDao();
    private static final String NAME_FIELD = "name";
    private static final String REGION_FIELD = "region";
    private static final String DESCRIPTION_FIELD = "description";
   // private Map<String, List<String>> countrysRegions = new HashMap<String, List<String>>();

    /*public Map<String, List<String>> getCountrysRegions() {
        return countrysRegions;
    }*/


    public List<Site> getAllSites() {
         //List<Site> allSites = new ArrayList<>();
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

        for(String country:countries) {
            places = placeDao.getPlaceByCountryName(country);

            for (Place place : places) {
                regions.add(place.getRegion());
            }

            List<String> regionsBis = new ArrayList<>(regions);
            regions.clear();
            countrysRegions.put(country, regionsBis);
        }
        return countrysRegions;
    }

    public Site addSite(HttpServletRequest req) {
        String name = getFieldValue(req, NAME_FIELD );
        String region = getFieldValue(req, REGION_FIELD );
        String description = getFieldValue(req, DESCRIPTION_FIELD );

        User user = (User) req.getSession().getAttribute("user");
        Place place = placeDao.getPlaceByRegionName(region);

        Site site = new Site();
        site.setDescription(description);
        site.setName(name);
        site.setPlace(place);
        site.setSiteOwner(user);

        site = siteDao.addSite(site);

        return site;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return fieldValue;
    }

}
