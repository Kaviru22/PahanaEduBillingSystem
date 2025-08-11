package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserDAO;
import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserUpdateServiceTest {

    private UserDAO userDAOMock;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userDAOMock = mock(UserDAO.class);

        // Inject mock via anonymous subclass
        userService = new UserService() {
            private final UserDAO dao = userDAOMock;

            @Override
            public String updateUser(String originalUsername, User user) {
                boolean success = dao.updateUser(originalUsername, user);
                return success ? "User updated successfully" : "User not found";
            }
        };
    }

    @Test
    void testUpdateUserSuccess() {
        User newUser = new User("johnny", "John", "Doe", "john@example.com", "pass123");
        when(userDAOMock.updateUser("john", newUser)).thenReturn(true);

        String result = userService.updateUser("john", newUser);
        assertEquals("User updated successfully", result);
        System.out.println("User updated success Unit Testing : " + result);
    }

    @Test
    void testUpdateUserNotFound() {
        User newUser = new User("johnny", "John", "Doe", "john@example.com", "pass123");
        when(userDAOMock.updateUser("john", newUser)).thenReturn(false);

        String result = userService.updateUser("john", newUser);
        assertEquals("User not found", result);
        System.out.println("User not found Unit Testing : " + result);
    }
}
