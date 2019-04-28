package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Status {
    private String status;
    private User user;
    private Integer idStatus;
    private List<Commentaire> listCom;
    private Date date;

    public Status() {
        listCom = new ArrayList<>();
    }

    public Status(String status, User user, Integer idStatus, Date date) {
        this.status = status;
        this.user = user;
        this.idStatus = idStatus;
        this.date = date;
        this.listCom = new ArrayList<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public List<Commentaire> getListCom() {
        return listCom;
    }

    public void setListCom(List<Commentaire> listCom) {
        this.listCom = listCom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addCommentaire(Commentaire commentaire) {
        listCom.add(commentaire);
    }

    public void deleteCommentaire(Commentaire commentaire) {
        listCom.remove(commentaire);
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
