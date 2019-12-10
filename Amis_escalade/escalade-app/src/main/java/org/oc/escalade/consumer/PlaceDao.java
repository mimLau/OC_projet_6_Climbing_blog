package org.oc.escalade.consumer;

import org.oc.escalade.model.Place;

import java.util.List;

public interface PlaceDao {

    Place addPlace(Place place);
    Place findPlaceByCountryAndRegion(String country, String region);
    List<String> getAllDistinctCountries();
    List<Place> getPlaceByCountryName(String country);
    Place  getPlaceByRegionName(String region);
}
