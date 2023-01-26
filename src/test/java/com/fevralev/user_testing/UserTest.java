package com.fevralev.user_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private static final String VALID_EMAIL = "user01@gmail.com";
    private static final String VALID_PASSWORD = "password123";

    @BeforeEach
    public void setUp() {
        user = new User(VALID_EMAIL, VALID_PASSWORD);
    }

    @Test
    public void createUser() {
        User actualUser = new User(VALID_EMAIL, VALID_PASSWORD);
        assertEquals(user.getEmail(), VALID_EMAIL);
        assertEquals(user.getPassword(), VALID_PASSWORD);
        assertEquals(actualUser, user);
    }

    @Test
    public void createNullUser() {
        User nullUser  = new User();
        assertNull(nullUser.getEmail());
        assertNull(nullUser.getPassword());
    }

    @Test
    public void canNotCreateNotValidUser() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {new User("fdfd@g.com", "pass");
        });
        assertEquals("Неверный email", exception.getMessage());

    }

    @Test
    public void emailUserValidation() {
        Assertions.assertTrue(user.getEmail().contains("@"));
        Assertions.assertTrue(user.getEmail().contains("."));
        Assertions.assertNotNull(user.getEmail());
        Assertions.assertNotNull(user.getPassword());
    }

    @Test
    public void loginNotEqualsPassport() {
    assertNotEquals(user.getEmail(), user.getPassword());
    }


}
