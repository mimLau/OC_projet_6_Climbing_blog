package org.oc.escalade.consumer;

import org.oc.escalade.model.Place;

public interface PlaceDao {

    Place addPlace(Place place);
    Place findPlaceByCountryAndRegion(String country, String region);
}