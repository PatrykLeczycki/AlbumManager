package pl.coderslab.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void WhenSetAdminThenAdminIsSet() {
        User user = new User("login", "password", "email@email.com");
        boolean oldRole = user.isAdmin();

        if (oldRole) user.setAdmin(false);
        else user.setAdmin(true);

        assertNotEquals(oldRole, user.isAdmin());
    }

}