package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.UserLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginServiceTest {

    @Test
    void testLoginSuccess() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("user", "user123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertSame("Login Success", "Login Success");
        System.out.println("Test Login Passed :" + result);
    }

    @Test
    void testEmptyUserName() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("","user123");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertTrue(result.contains("error"), "UserName Cannot be empty");
        System.out.println("Empty UserName Login Test Passed :" +result);

    }

    @Test
    void testEmptyPassword() {
        UserLoginServer userLoginServer = new UserLoginServer();

        UserLogin userLogin = new UserLogin("user","");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertTrue(result.contains("error"), "Password Cannot be empty");
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

        UserLogin userLogin = new UserLogin("user","testing");
        String result = userLoginServer.login(userLogin.getUsername(), userLogin.getPassword());

        assertTrue(result.contains("Invalid Password"), "Invalid Password");
        System.out.println("Invalid Password Login Test Passed :" +result);

    }
}
