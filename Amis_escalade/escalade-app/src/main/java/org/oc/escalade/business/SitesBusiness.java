package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.PlaceDao;
import org.oc.escalade.consumer.SiteDao;
import org.oc.escalade.model.Place;
import org.oc.escalade.model.Site;

import java.util.*;

public final class SitesBusiness {

    private SiteDao siteDao = DaoFactory.getSiteDao();
    private PlaceDao placeDao = DaoFactory.getPlaceDao();
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

}
