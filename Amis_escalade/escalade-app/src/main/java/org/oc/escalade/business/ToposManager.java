package org.oc.escalade.business;

import org.oc.escalade.consumers.BookingDao;
import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.consumers.TopoDao;
import org.oc.escalade.consumers.UserDao;
import org.oc.escalade.models.Booking;
import org.oc.escalade.models.Status;
import org.oc.escalade.models.Topo;
import org.oc.escalade.models.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToposManager {
    private final static String DESCRIPTION_FIELD = "topoDesc";
    private final static String NAME_FIELD = "topoName";
    private final static String RELEASE_DATE = "topoDate";
    private static final String ID_PARAMETER = "id";
    private static final String DISP_PARAMETER = "disp";
    private TopoDao topoDao = DaoFactory.getTopoDao();
    private UserDao userDao = DaoFactory.getUserDao();
    private BookingDao bookingDao = DaoFactory.getBookingDao();

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

    public Map<Topo, Boolean> getAllTopos( HttpServletRequest req ) {
        List<Topo> allTopos = topoDao.getAllTopos();
        Map<Topo, Boolean> topos = new HashMap<>();
        List<Topo> bookedTopos = new ArrayList<>();

        BookingsManager bookingsManager = new BookingsManager();
        List<Booking> userBookings = bookingsManager.getBookingsByUserRequestId( req );

        for ( Booking booking : userBookings )  bookedTopos.add(booking.getTopo());

        for( Topo topo : (allTopos )) {
            if( bookedTopos.size() != 0) {
                for( Topo top : bookedTopos) {
                    if (top.getId() == topo.getId()) {
                        topos.put(topo, true);
                    }
                     else topos.put(topo, false);
                }
            } else
                topos.put(topo, false);
        }
        return topos;
    }

    public void updateTopoDisp( HttpServletRequest req ) {
        Long idTopo =  Long.parseLong( getParameterValue( req, ID_PARAMETER ));
        Boolean  disp =  Boolean.parseBoolean( getParameterValue( req, DISP_PARAMETER ));
        topoDao.updateTopoStatus( idTopo, disp );
        Booking booking = bookingDao.findBookingByStatusAndTopoId(Status.ACCEPTED, idTopo );
        bookingDao.updateBookingStatus( booking.getId(), Status.EXPIRED );
    }

    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
