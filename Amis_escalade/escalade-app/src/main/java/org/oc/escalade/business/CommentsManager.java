package org.oc.escalade.business;

import org.oc.escalade.consumers.CommentDao;
import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.models.Comment;
import org.oc.escalade.models.Site;
import org.oc.escalade.models.User;
import org.oc.escalade.utils.RetrieveParamValue;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class CommentsManager {
    private CommentDao commentDao = DaoFactory.getCommentDao();
    private final static String COMMENT_CONTENTS_FIELD = "comment_contents";
    private final static String COMMENT_EDIT_CONTENTS_FIELD = "comment_edit_contents";
    private final static String ID_COMMENT_PARAM = "id";
    private static final String SITE_ATT =  "site";
    private final static String USER_SESSION = "user";

    public Comment addComment( HttpServletRequest req ) {
        String commentContents = RetrieveParamValue.getParameterValue( req, COMMENT_CONTENTS_FIELD );
        User user = (User) req.getSession().getAttribute( USER_SESSION );
        Site site = (Site) req.getServletContext().getAttribute( SITE_ATT );
        req.getServletContext().setAttribute( SITE_ATT, site );

        Date today = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM, new Locale("FR", "fr"));


        Comment comment = new Comment();
        comment.setContents( commentContents );
        comment.setCommentOwner( user );
        comment.setSiteComment( site );
        comment.setDate( shortDateFormat.format( today ));

        commentDao.addComment( comment );

        return comment;
    }

    public void deleteComment( HttpServletRequest req ) {
        Long commentId = Long.parseLong(RetrieveParamValue.getParameterValue( req,  ID_COMMENT_PARAM ));
        commentDao.deleteComById(commentId);
    }

    public void updateComment( HttpServletRequest req ) {
        Long commentId = Long.parseLong(RetrieveParamValue.getParameterValue( req,  ID_COMMENT_PARAM ));
        String commentContents = RetrieveParamValue.getParameterValue(  req, COMMENT_EDIT_CONTENTS_FIELD );
        Date editedDate = new Date();
        commentDao.updateCommentById( commentId, commentContents , editedDate );
    }

}
