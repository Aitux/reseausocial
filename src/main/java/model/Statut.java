package model;

import java.util.ArrayList;
import java.util.List;

public class Status
{
    String status;
    User user;
    Integer idStatus;
    List<Commentaire> listCom;

    public Status(String status, User user, Integer idStatus)
    {
        this.status = status;
        this.user = user;
        this.idStatus = idStatus;
        this.listCom = new ArrayList<>();
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
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


    public void addCommentaire(Commentaire commentaire){
        listCom.add(commentaire);
    }

    public void deleteCommentaire(Commentaire commentaire) {
        listCom.remove(commentaire);
    }

}
