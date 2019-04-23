package model;

public class Commentaire
{

    User user;
    String commentaire;
    Status statut;

    public Commentaire(User user, String commentaire, Status statut)
    {
        this.user = user;
        this.commentaire = commentaire;
        this.statut = statut;
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
        return statut;
    }

    public void setStatus(Status statut)
    {
        this.statut = statut;
    }

}


