package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserDAO;
import com.example.pahanaeduonlinebillingsys.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserViewServiceTest {

    private UserDAO userDAOMock;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userDAOMock = mock(UserDAO.class);
        userService = new UserService() {
            private final UserDAO dao = userDAOMock;

            @Override
            public User getUserByUsername(String username) {
                return dao.getUserByUsername(username);
            }

            @Override
            public String updateUser(String originalUsername, User newUser) {
                if (!newUser.getEmail().contains("@") || newUser.getPassword().length() < 6) {
                    return "Invalid email or password must be 6+ characters.";
                }
                return dao.updateUser(originalUsername, newUser) ? "User updated successfully." : "Update failed.";
            }
        };
    }

    @Test
    void testGetUserByUsername() {
        User mockUser = new User("john", "John", "Doe", "john@email.com", "password123");
        when(userDAOMock.getUserByUsername("john")).thenReturn(mockUser);

        User result = userService.getUserByUsername("john");
        assertNotNull(result);
        assertEquals("john", result.getUsername());
        System.out.println("User found Unit Testing: " + result);
    }

    @Test
    void testUpdateUserInvalidEmail() {
        User newUser = new User("john", "John", "Doe", "invalidEmail", "password123");
        String result = userService.updateUser("john", newUser);
        assertTrue(result.contains("Invalid email"));
        System.out.println("Invalid User Email Unit Testing: " + result);
    }

    @Test
    void testUpdateUserSuccess() {
        User newUser = new User("john", "John", "Doe", "john@email.com", "password123");
        when(userDAOMock.updateUser("john", newUser)).thenReturn(true);

        String result = userService.updateUser("john", newUser);
        assertTrue(result.contains("successfully"));
        System.out.println("User updated Success Unit Testing: " + result);
    }
}
