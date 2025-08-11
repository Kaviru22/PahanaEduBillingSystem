package com.example.pahanaeduonlinebillingsys.user.dao;

import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserViewIntegrateTest {

    @Test
    void testViewExistingUser() {
        UserService service = new UserService();
        User user = service.getUserByUsername("testuser");

        assertNotNull(user, "User should exist in DB");
        assertEquals("testuser", user.getUsername());
        System.out.println("User Viewing Integration Testing : " + user);
    }
}
