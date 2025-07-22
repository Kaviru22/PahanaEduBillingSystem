package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import com.example.pahanaeduonlinebillingsys.user.dao.NewUserDAO;

public class UserCreateService {

    private final NewUserDAO userDAO = new NewUserDAO();

    public String registerUser(UserRegister userRegister) {
        try {
            if (!userRegister.getPassword().equals(userRegister.getConfirmpassword())) {
                return "❌ Passwords do not match!";
            }

            if (!userRegister.getEmail().contains("@") || userRegister.getPassword().length() < 6) {
                return "Invalid email or password must be 6+ characters.";
            }

            if (userDAO.userExists(userRegister.getUsername(), userRegister.getEmail())) {
                return "❌ User already exists!";
            }

            boolean inserted = userDAO.insertUser(userRegister);
            return inserted ? "✅ User created successfully!" : "❌ Failed to create user!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}

