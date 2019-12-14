package org.oc.escalade.business;


import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.SectorDao;
import org.oc.escalade.model.Sector;
import org.oc.escalade.model.Site;

import javax.servlet.http.HttpServletRequest;

public final class SectorsManager {
    private static final String NAME_FIELD = "sectorName";
    private static final String  NB_WAYS_FIELD = "numberWay";
    private SectorDao sectorDao = DaoFactory.getSectorDao();

    public Sector addSector( HttpServletRequest req ) {
        String name = getFieldValue(req, NAME_FIELD );
        String nbOfWays = getFieldValue(req, NB_WAYS_FIELD );
        Site site = ( Site ) req.getServletContext().getAttribute("site" );
        Sector sector = new Sector();
        sector.setName( name );
        sector.setSite( site );
        sector = sectorDao.addSector( sector );

        return sector;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return fieldValue;
    }
}
