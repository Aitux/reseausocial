package model;

import org.glassfish.jersey.internal.guava.Lists;

import java.util.*;

public class User {

    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String sexe;
    private List<User> friends;
    private List<Status> statuts;

    public User() {
        this.friends = new ArrayList<>();
        this.statuts = new ArrayList<>();
    }

    public User(String firstname, String lastname, String password, String email, String sexe) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = hash(password);
        this.email = email;
        this.sexe = sexe;
        this.friends = new ArrayList<>();
        this.statuts = new ArrayList<>();
    }

    private String hash(String password) {
        return Security.sha256(password);
    }

    public boolean exist(String email, String password) {
        return this.password.equals(password) && this.email.equals(email);
    }

    public boolean exist(String email) {
        return this.email.equals(email);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGoodPassword(String password) {
        return Security.sha256(password).equals(password);
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Status> getStatus() {
        return statuts;
    }

    public void setStatus(List<Status> statuts) {
        this.statuts = statuts;
    }

    public void addStatus(Status stat) {
        statuts.add(stat);
    }


    public void deleteStatus(Status stat) {
        statuts.remove(stat);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }

    public List<Status> getLatestStatus() {
        List<Status> res = new ArrayList<>();
        res.addAll(getStatus());
        friends.forEach(x -> {
            if (x.getStatus().size() > 10) {
                res.addAll(x.getStatus().subList(0, 10));
            } else {
                res.addAll(x.getStatus());
            }
        });

        res.sort(Comparator.comparing(Status::getDate));
        Collections.reverse(res);
        if (res.size() > 10)
            return res.subList(0, 10);
        else
            return res;
        }
    }
