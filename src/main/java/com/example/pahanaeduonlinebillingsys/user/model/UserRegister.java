package com.example.pahanaeduonlinebillingsys.user.model;

public class UserRegister extends User {

    private String confirmpassword;

    public UserRegister(String username, String firstName, String lastName, String email, String password, String confirmpassword) {
        super(username, firstName, lastName, email, password);
        this.confirmpassword = confirmpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword =confirmpassword;
    }
}
