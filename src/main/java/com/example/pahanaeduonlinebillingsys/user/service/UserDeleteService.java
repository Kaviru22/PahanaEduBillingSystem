package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserDeleteDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;

public class UserDeleteService {

    private final UserDeleteDAO userDeleteDAO = new UserDeleteDAO();

    public String deleteUser(UserDelete userDelete) {

        try{
            boolean success = userDeleteDAO.userDelete(userDelete);
            if(success){
                return "✅ User '" + userDelete.getUsername() + "' deleted successfully.";

            }
            else {
                return "❌ User not found.";
            }
        } catch (Exception e) {
        return "Error: " + e.getMessage();
    }

    }
}
