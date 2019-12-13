package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.model.Way;

import javax.servlet.http.HttpServletRequest;

public final class WaysForm {

    private static String WAY_NAME_FIELD = "wayName";
    private static String QUOTATION_FIELD = "quotation";
    private static String  LENGTH_FIELD = "length";
    //private WayDao waDao = DaoFactory.get

    public Way addWay( HttpServletRequest req ) {
        String wayName = getParamValue(req, WAY_NAME_FIELD);
        String quotation = getParamValue(req, QUOTATION_FIELD);
        int length = Integer.parseInt(getParamValue(req, LENGTH_FIELD));

        Way way = new Way();

        return way;
    }

    private static String getParamValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }

}
