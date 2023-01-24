package com.fevralev.user_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static com.fevralev.user_testing.constants.UserTestConstants.VALID_EMAIL;
import static com.fevralev.user_testing.constants.UserTestConstants.VALID_PASSWORD;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(VALID_EMAIL, VALID_PASSWORD);
    }

    @Test
    public void createUser() {
        assertEquals(user.getEmail(), VALID_EMAIL);
        assertEquals(user.getPassword(), VALID_PASSWORD);
    }

    @Test
    public void createNullUser() {
        User user = new User();
        assertNull(user.getEmail());
        assertNull(user.getPassword());
    }

    @Test
    public void emailUserValidation() {
        User user = new User(VALID_EMAIL, VALID_PASSWORD);
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
