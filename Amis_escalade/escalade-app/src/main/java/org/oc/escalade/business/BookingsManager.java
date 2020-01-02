package org.oc.escalade.business;

import org.oc.escalade.consumers.BookingDao;
import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.consumers.TopoDao;
import org.oc.escalade.models.Booking;
import org.oc.escalade.models.Status;
import org.oc.escalade.models.Topo;
import org.oc.escalade.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BookingsManager {
    private BookingDao bookingDao = DaoFactory.getBookingDao();
    private TopoDao topoDao = DaoFactory.getTopoDao();
    private final static String ID_TOPO_PARAM = "id";
    private final static String ID_BOOKING_PARAM = "id";

    public Booking addBooking( HttpServletRequest req ) {
        Long topoId = Long.parseLong(getParameterValue( req,  ID_TOPO_PARAM ));
        Topo topo = topoDao.findTopoById( topoId );
        User userRequest = (User) req.getSession().getAttribute("user");

        Booking booking = new Booking();
        booking.setTopo( topo );
        booking.setUserRequest( userRequest );
        booking.setUserLender( topo.getTopoOwner() );
        booking.setStatus(Status.IN_PROGRESS);
        bookingDao.addBooking( booking );
        //req.getServletContext().setAttribute("BOOKED", true);

        return booking;
    }

    public List<Booking> getBookingsByUserLenderId( HttpServletRequest req ) {
        User user = (User) req.getSession().getAttribute("user");
        List<Booking> bookings = bookingDao.findBookingsByUserLenderId( user.getUserId() );

        return bookings;
    }

    public List<Booking> getBookingsByUserRequestId( HttpServletRequest req ) {
        User user = (User) req.getSession().getAttribute("user");
        List<Booking> bookings = bookingDao.findBookingsByUserRequestId( user.getUserId() );

        return bookings;
    }

    public void updateBookingStatusToAccepted( HttpServletRequest req ) {
        Long bookingId = Long.parseLong(getParameterValue( req,  ID_BOOKING_PARAM ));
        bookingDao.updateBookingStatus( bookingId, Status.ACCEPTED );
        Booking booking = bookingDao.findBookingById( bookingId );
        topoDao.updateTopoStatusToTrue( booking.getTopo().getId() );
    }

    private static String getParameterValue( HttpServletRequest req, String param ) {
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
