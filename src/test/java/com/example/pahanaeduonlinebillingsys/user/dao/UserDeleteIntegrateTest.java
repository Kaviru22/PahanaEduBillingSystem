package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import com.example.pahanaeduonlinebillingsys.user.service.UserDeleteService;
import com.example.pahanaeduonlinebillingsys.user.service.UserLoginServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDeleteIntegrateTest {

    @Test
    void testDeleteUserFromDatabase() {
        UserDeleteService service = new UserDeleteService();

        UserDelete userToDelete = new UserDelete("testuser1");
        String result = service.deleteUser(userToDelete);

        assertTrue(result.contains("deleted successfully") || result.contains("not found"));
        System.out.println("User Deletion Integration Testing :" +result);
    }
}
