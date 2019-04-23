package model;

public class User {

        private String firstname;
        private String lastname;
        private String password;
        private String email;
        private String sexe;

    public User() {
    }

    public User(String firstname, String lastname, String password, String email, String sexe) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = hash(password);
        this.email = email;
        this.sexe = sexe;
    }

    private String hash(String password) {
        return Security.sha256(password);
    }

    public boolean exist(String email, String password) {
        return this.password.equals(password) && this.email.equals(email);
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

    public boolean isGoodPassword(String password){
        return Security.sha256(password).equals(password);
    }


}
