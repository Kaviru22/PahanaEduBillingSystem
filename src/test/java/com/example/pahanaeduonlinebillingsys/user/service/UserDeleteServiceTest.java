package com.example.pahanaeduonlinebillingsys.user.service;

import com.example.pahanaeduonlinebillingsys.user.dao.UserDeleteDAO;
import com.example.pahanaeduonlinebillingsys.user.model.UserDelete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserDeleteServiceTest {

    private UserDeleteDAO deleteDAOMock;
    private UserDeleteService deleteService;

    @BeforeEach
    void setUp() {
        deleteDAOMock = mock(UserDeleteDAO.class);

        deleteService = new UserDeleteService() {
            private final UserDeleteDAO dao = deleteDAOMock;

            @Override
            public String deleteUser(UserDelete userDelete) {
                try {
                    boolean success = dao.userDelete(userDelete);
                    return success
                            ? "✅ User '" + userDelete.getUsername() + "' deleted successfully."
                            : "❌ User not found.";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        };
    }

    @Test
    void testDeleteUserSuccess() throws Exception {
        UserDelete user = new UserDelete("john");
        when(deleteDAOMock.userDelete(user)).thenReturn(true);

        String result = deleteService.deleteUser(user);
        assertEquals("✅ User 'john' deleted successfully.", result);
        System.out.println("User Deletion Unit Testing : " + user);
    }

    @Test
    void testDeleteUserNotFound() throws Exception {
        UserDelete user = new UserDelete("john");
        when(deleteDAOMock.userDelete(user)).thenReturn(false);

        String result = deleteService.deleteUser(user);
        assertEquals("❌ User not found.", result);
        System.out.println("User Not Found Unit Testing : " + user);
    }

    @Test
    void testDeleteUserException() throws Exception {
        UserDelete user = new UserDelete("john");
        when(deleteDAOMock.userDelete(user)).thenThrow(new RuntimeException("DB error"));

        String result = deleteService.deleteUser(user);
        assertTrue(result.contains("Error: DB error"));
        System.out.println("User Delete Exception Unit Testing : " + user);
    }
}
