package com.example.pahanaeduonlinebillingsys;

import java.util.ArrayList;

public abstract class UserAbstract {

    protected ArrayList<UserLogin> userList = new ArrayList<>();

    public abstract boolean validateUser(UserLogin userLogin);

    public void adduser(UserLogin userLogin) {
        userList.add(userLogin);
    }

    public ArrayList<UserLogin> getUsers() {
        return userList;
    }
}
