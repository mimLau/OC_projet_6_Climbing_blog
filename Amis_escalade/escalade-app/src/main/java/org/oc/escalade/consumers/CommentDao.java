package org.oc.escalade.consumers;

import org.oc.escalade.models.Comment;

public interface CommentDao {

    Comment addComment(Comment comment);
}
