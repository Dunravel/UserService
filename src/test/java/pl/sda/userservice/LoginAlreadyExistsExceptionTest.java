package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Test;

public class LoginAlreadyExistsExceptionTest {
    @Test
    public void shouldReturnCorrectMessageWithGivenLogin() {
        //given
        String login = "login";

        //when
        String message = new LoginAlreadyExistsException(login).getMessage();

        //then
        Assert.assertEquals("Login already exists: login", message);
    }
}
