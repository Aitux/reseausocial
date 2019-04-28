package model;

public class Commentaire {

    private User user;
    private String commentaire;

    public Commentaire() {
    }

    public Commentaire(User user, String commentaire) {
        this.user = user;
        this.commentaire = commentaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}


