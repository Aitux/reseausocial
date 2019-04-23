package model;

public class Commentaire
{

    User user;
    String commentaire;
    Status status;

    public Commentaire(User user, String commentaire, Status status)
    {
        this.user = user;
        this.commentaire = commentaire;
        this.status = status;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getCommentaire()
    {
        return commentaire;
    }

    public void setCommentaire(String commentaire)
    {
        this.commentaire = commentaire;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

}


