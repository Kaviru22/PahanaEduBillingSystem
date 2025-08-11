package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;
import com.example.pahanaeduonlinebillingsys.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserUpdateIntegrateTest {

    @Test
    void testUpdateExistingUser() {
        UserService service = new UserService();

        User updatedUser = new User("user3", "John", "Cena", "johnny@example.com", "1234567");
        String result = service.updateUser("user3", updatedUser);

        assertTrue(result.contains("successfully") || result.contains("not found"));
        System.out.println("User Update Integration Testing :" +result);
    }

}
