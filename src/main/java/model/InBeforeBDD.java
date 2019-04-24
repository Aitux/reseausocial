package model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InBeforeBDD {

    private static InBeforeBDD ourInstance = new InBeforeBDD();
    private List<User> users;

    private InBeforeBDD() {
        users = new ArrayList<>();
        User u1 = new User("Océane", "Pruvost", "azerty", "oceane.pruvost@outlook.fr", "FEMME");
        User u2 = new User("Jonas", "Voeltzel", "123", "jonas.voeltzel@live.fr", "HOMME");
        User u3 = new User("Quentin", "Hageman", "0000", "xecto74@gmail.com", "HOMME");
        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    public static InBeforeBDD getInstance() {
        return ourInstance;
    }

    public User getUser(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String mail = "";
        String password = "";
        if (cookies != null) {
            for (Cookie c :
                    cookies) {
                if (c.getName().equals("miagebook_mail")) {
                    mail = c.getValue();
                }
                if (c.getName().equals("miagebook_password")) {
                    password = c.getValue();
                }
            }
        }

        String finalPassword = password;
        String finalUsername = mail;
        System.out.println("pass: " + password);
        System.out.println("mail: " + mail);
        System.out.println("List users: ");
        users.forEach(System.out::println);
        List<User> us = users.stream().filter(x -> x.exist(finalUsername, finalPassword)).collect(Collectors.toList());
        us.forEach(System.out::println);
        us.forEach(System.out::println);
        if (us.size() > 0)
            return us.get(0);
        else
            return null;
    }

    public User getUser(String email, String password) {

        List<User> us = users.stream().filter(x -> x.exist(email, Security.sha256(password))).collect(Collectors.toList());
        us.forEach(System.out::println);
        if (us.size() > 0)
            return us.get(0);
        else
            return null;
    }

    public User getUser(String email) {

        List<User> us = users.stream().filter(x -> x.exist(email)).collect(Collectors.toList());
        us.forEach(System.out::println);
        if (us.size() > 0)
            return us.get(0);
        else
            return null;
    }

    public boolean isConnected(HttpServletRequest req) {
        User us = getUser(req);
        return us != null;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public List<User> getUsers() {
        return users;
    }

}
