package model;

public class Commentaire
{

    User user;
    String commentaire;
    Statut statut;

    public Commentaire(User user, String commentaire, Statut statut)
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

    public Statut getStatut()
    {
        return statut;
    }

    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }

}


