package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.WayDao;
import org.oc.escalade.model.Rating;
import org.oc.escalade.model.Way;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public final class WaysForm {

    private static String WAY_NAME_FIELD = "wayName";
    private static String RATING_FIELD = "rating";
    private static String  LENGTH_FIELD = "length";
    private WayDao wayDao = DaoFactory.getWayDao();

    public Way addWay( HttpServletRequest req ) {
        String wayName = getParamValue(req, WAY_NAME_FIELD);
        String rating = getParamValue(req, RATING_FIELD);
        long length = Long.parseLong(getParamValue(req, LENGTH_FIELD));

        Way way = new Way();
        way.setName(wayName);
        way.setRating(rating);
        way.setLength(length);
        wayDao.addWay(way);

        return way;
    }

    public List<String> getAllRatings() {
       return  Rating.getAllRtingsValues();
    }

    private static String getParamValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }

}
