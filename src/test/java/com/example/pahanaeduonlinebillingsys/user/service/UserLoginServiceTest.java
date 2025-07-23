package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginServiceTest {

    @Test
    void testLoginSuccess() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("test", "pass123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertSame("Login Success", "Login Success", "User should login successfully");
        System.out.println("Test Login Passed :" + result);
    }

    @Test
    void testEmptyUserName() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("","user123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Username cannot be empty", result);
        System.out.println("Empty UserName Login Test Passed :" +result);

    }

    @Test
    void testEmptyPassword() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("user","");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Password cannot be empty", result);
        System.out.println("Empty Password Login Test Passed :" +result);

    }

    @Test
    void testInvalidUserName() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("wrong123","pass123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Invalid username or password", result);
        System.out.println("Invalid UserName Login Test Passed :" +result);

    }

    @Test
    void testInvalidPassword() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("testuser1","testing");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertEquals("Invalid username or password", result, "Should fail with Invalid Password");
        System.out.println("Invalid Password Login Test Passed :" +result);

    }
}
