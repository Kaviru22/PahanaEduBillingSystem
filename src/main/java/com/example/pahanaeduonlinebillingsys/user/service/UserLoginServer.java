package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserLoginDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;

public class UserLoginServer {

    private final UserLoginDAO userLoginDAO = new UserLoginDAO();


    public String login(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return "Username cannot be empty";
        }

        if (password == null || password.trim().isEmpty()) {
            return "Password cannot be empty";
        }

        boolean isValid = userLoginDAO.validateUser(username, password);
        return isValid ? "SUCCESS" : "Invalid username or password";
    }

}
