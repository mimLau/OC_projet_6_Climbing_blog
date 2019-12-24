package org.oc.escalade.business;

import org.oc.escalade.consumers.CommentDao;
import org.oc.escalade.consumers.DaoFactory;
import org.oc.escalade.models.Comment;
import org.oc.escalade.models.Site;
import org.oc.escalade.models.User;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentsManager {
    private CommentDao commentDao = DaoFactory.getCommentDao();
    private final static String COMMENT_CONTENTS_FIELD = "comment_contents";
    private final static String COMMENT_EDIT_CONTENTS_FIELD = "comment_edit_contents";
    private final static String ID_COMMENT_PARAM = "id";
    private static final String SITE_ATT =  "site";

    public Comment addComment( HttpServletRequest req ) {
        String commentContents = getParameterValue( req, COMMENT_CONTENTS_FIELD );
        User user = (User) req.getSession().getAttribute("user");
        Site site = (Site) req.getServletContext().getAttribute("site");
        req.getServletContext().setAttribute( SITE_ATT, site );

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();

        Comment comment = new Comment();
        comment.setContents( commentContents );
        comment.setCommentOwner( user );
        comment.setSiteComment( site );
        comment.setDate( date );

        commentDao.addComment( comment );

        return comment;
    }

    public void deleteComment( HttpServletRequest req ) {
        Long commentId = Long.parseLong(getParameterValue( req,  ID_COMMENT_PARAM ));
        commentDao.deleteComById(commentId);
    }

    public void updateComment( HttpServletRequest req ) {
        Long commentId = Long.parseLong(getParameterValue( req,  ID_COMMENT_PARAM ));
        String commentContents = getParameterValue(  req, COMMENT_EDIT_CONTENTS_FIELD );
        Date editedDate = new Date();
        commentDao.updateCommentById( commentId, commentContents , editedDate );
    }

    private static String getParameterValue( HttpServletRequest req, String param ){
        String paramValue = req.getParameter( param );
        return paramValue;
    }
}
