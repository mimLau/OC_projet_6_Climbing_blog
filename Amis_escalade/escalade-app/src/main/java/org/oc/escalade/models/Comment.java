package org.oc.escalade.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String contents;
    private boolean edited;
    private Date editedDate;

    @ManyToOne
    @JoinColumn(name= "user_fk")
    private User commentOwner;

    @ManyToOne
    @JoinColumn(name = "site_fk")
    private Site siteComment;

    @ManyToOne
    @JoinColumn(name="answer_comment_fk")
    private Comment answerComment;

    @OneToMany(mappedBy = "answerComment")
    private List<Comment> answerComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public User getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(User commentOwner) {
        this.commentOwner = commentOwner;
    }

    public Site getSiteComment() {
        return siteComment;
    }

    public void setSiteComment(Site siteComment) {
        this.siteComment = siteComment;
    }
}
