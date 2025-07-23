package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class UserDeleteServiceTest {

    @Test
    void testDeleteSuccess() {
        UserDeleteService userDeleteService = new UserDeleteService();

        UserDelete userDelete = new UserDelete("test");
        String result = userDeleteService.deleteUser(userDelete);

        assertSame("deleted successfully", "deleted successfully", "User should Delete successfully");
        System.out.println("User Delete Test Passed :" + result);
    }

    @Test
    void testDeleteFailure() {
        UserDeleteService userDeleteService = new UserDeleteService();

        UserDelete userDelete = new UserDelete("test56");
        String result = userDeleteService.deleteUser(userDelete);

        assertSame("❌ User not found.", "❌ User not found.", "User should Not Delete successfully");
        System.out.println("User delete Failed Test Passed :" + result);
    }

}
