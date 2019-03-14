package model;

import java.util.ArrayList;
import java.util.List;

public class InBeforeBDD {

    List<User> users;

    private static InBeforeBDD ourInstance = new InBeforeBDD();

    public static InBeforeBDD getInstance() {
        return ourInstance;
    }



    private InBeforeBDD() {
        users = new ArrayList<>();
    }
}
