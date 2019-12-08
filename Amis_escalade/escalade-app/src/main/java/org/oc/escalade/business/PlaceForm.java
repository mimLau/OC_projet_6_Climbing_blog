package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.PlaceDao;
import org.oc.escalade.model.Place;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class PlaceForm {

    private static final String COUNTRY_FIELD = "country";
    private static final String REGION_FIELD = "region";
    private Map<String, String> errors = new HashMap<String, String>();
    private PlaceDao placeDao = DaoFactory.getPlaceDao();

    public Map<String, String> getErrors() {
        return errors;
    }

    public Place addPlace(HttpServletRequest req) {
        String country = getFieldValue(req, COUNTRY_FIELD );
        String region = getFieldValue(req, REGION_FIELD );

        Place place = new Place();
        countryValidation(country);
        place.setCountry(country);
        regionValidation(region);
        place.setRegion(region);

        System.out.println("Country: " + place.getCountry());
        System.out.println("errors: " + errors);
        System.out.println("errors.isEmpty(): " + errors.isEmpty());
        System.out.println("errors.isEmpty(): " + errors.isEmpty());

        if(errors.isEmpty()) {
            placeDao.addPlace(place);
        }


        return place;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return fieldValue;
    }

    private void countryValidation(String country) {
        if ( country.isEmpty())
            setError(country, "Saisissez un pays.");
    }

    private void regionValidation(String region) {
        if ( region.isEmpty())
            setError(region, "Saisissez une région.");
    }

    private void setError( String field, String message ) {
        errors.put( field, message );
    }

}
