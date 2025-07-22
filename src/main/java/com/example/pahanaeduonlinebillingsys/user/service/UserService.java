package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserDAO;
import com.example.pahanaeduonlinebillingsys.user.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public String updateUser(String originalUsername, User newUser) {
        // Basic validation
        if (!newUser.getEmail().contains("@") || newUser.getPassword().length() < 6) {
            return "Invalid email or password must be 6+ characters.";
        }

        boolean updated = userDAO.updateUser(originalUsername, newUser);
        return updated ? "User updated successfully." : "Update failed.";
    }
}
