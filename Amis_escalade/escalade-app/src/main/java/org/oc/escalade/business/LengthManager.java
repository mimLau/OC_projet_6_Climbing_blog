package org.oc.escalade.business;

import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.consumers.LengthDao;
import org.oc.escalade.consumers.SectorDao;
import org.oc.escalade.consumers.WayDao;
import org.oc.escalade.models.Length;
import org.oc.escalade.models.Way;

import javax.servlet.http.HttpServletRequest;

public class LengthManager {
    private static final String NAME_FIELD = "lengthName";
    private static String RATING_FIELD = "rating";
    private static String  LENGTH_FIELD = "lengthLength";
    private static final String ID_PARAM_NAME = "id";
    private LengthDao lengthDao = DaoFactory.getLengthDao();
    private WayDao wayDao = DaoFactory.getWayDao();

    public Length addLength(HttpServletRequest req ) {
        String name = getParameterValue( req, NAME_FIELD );
        String rating = getParameterValue( req, RATING_FIELD );
        long lengthLength = Long.parseLong(getParameterValue( req, LENGTH_FIELD ));
        Way way = ( Way ) req.getServletContext().getAttribute("way" );

        Length length = new Length();
        length.setName( name );
        length.setLength( lengthLength );
        length.setWay( way );
        length.setRating(rating);
        length = lengthDao.addLength( length );

        wayDao.updateNbOfLengths(way.getId());
        return length;
    }

    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
