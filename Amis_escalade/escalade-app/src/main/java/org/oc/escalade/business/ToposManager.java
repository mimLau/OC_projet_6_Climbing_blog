package org.oc.escalade.business;

import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.consumers.TopoDao;
import org.oc.escalade.consumers.UserDao;
import org.oc.escalade.models.Topo;
import org.oc.escalade.models.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ToposManager {
    private final static String DESCRIPTION_FIELD = "topoDesc";
    private final static String NAME_FIELD = "topoName";
    private final static String RELEASE_DATE = "topoDate";
    private static final String ID_PARAMETER = "id";
    private static final String DISP_PARAMETER = "disp";
    private TopoDao topoDao = DaoFactory.getTopoDao();
    private UserDao userDao = DaoFactory.getUserDao();


    public List<Topo> userTopos( HttpServletRequest req ) {
        User user = (User) req.getSession().getAttribute("user");
        List<Topo> userTopos = topoDao.getAllToposByUserId( user.getUserId() );

        return userTopos;
    }

    public Topo addTopo( HttpServletRequest req ) throws ParseException {
        User user = (User) req.getSession().getAttribute("user");
        String description = getParameterValue( req, DESCRIPTION_FIELD );
        String name = getParameterValue( req, NAME_FIELD );
        String date = getParameterValue( req, RELEASE_DATE );
        Date releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse( date );

        Topo topo = new Topo(false );
        topo.setDescription( description );
        topo.setName( name );
        topo.setReleaseDate( releaseDate );
        topo.setTopoOwner( user );
        topoDao.addTopo( topo);

        return topo;
    }

    public List<Topo> getAllTopos() {
        List<Topo> userTopos = topoDao.getAllTopos();
        return userTopos;
    }

    public void updateTopoDisp( HttpServletRequest req ) {
        String idTopo = getParameterValue( req, ID_PARAMETER );
        String disp = getParameterValue( req, DISP_PARAMETER );
        topoDao.updateTopoState( Long.parseLong( idTopo ) , Boolean.parseBoolean(disp) );
    }


    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
