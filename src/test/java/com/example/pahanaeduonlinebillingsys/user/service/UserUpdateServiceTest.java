package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.User;
import com.example.pahanaeduonlinebillingsys.user.model.UserRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserUpdateServiceTest {

    @Test
    void testInvalidEmail() {
        UserService userService = new UserService();

        User user = new User("test", "Test", "User", "test1email.com", "pass123");
        String result = userService.updateUser(user.getUsername(), user);

        assertTrue(result.contains("Invalid email"), "Should fail with invalid email");
        System.out.println("Invalid Test Email Passed. Results :" +result);
    }

    @Test
    void testPasswordMismatch() {
        UserCreateService service = new UserCreateService();

        UserRegister user = new UserRegister("test", "Test", "User", "test@email.com", "345345", "pass345");
        String result = service.registerUser(user);

        assertTrue(result.contains("do not match"), "Should fail with password mismatch");
        System.out.println("Password Mismatched Test Passed. Results :" +result);
    }

    @Test
    void updateUser() {
        UserService service = new UserService();

        User user = new User("testuser1", "Test", "Inter", "integ@example.com", "345345");
        String result = service.updateUser(user.getUsername(), user);

        assertTrue(result.contains("User updated successfully"), "Should Update User Successfully");
        System.out.println("User Update Test Passed. Results :" +result);
    }

    @Test
    void updateFailUser() {
        UserService service = new UserService();

        User user = new User("testingUser", "Test", "Inter", "integ@example.com", "345345");
        String result = service.updateUser(user.getUsername(), user);

        assertTrue(result.contains("Update failed"), "Should Fail Update User");
        System.out.println("Failed User Update Test Passed. Results :" +result);
    }
}
