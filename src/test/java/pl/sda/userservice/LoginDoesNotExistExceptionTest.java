package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Test;

public class LoginDoesNotExistExceptionTest {
    @Test
    public void shouldReturnCorrectMessageWithGivenLogin() {
        //given
        String login = "login";

        //when
        String message = new LoginDoesNotExistException(login).getMessage();

        //then
        Assert.assertEquals("Login does not exist: login", message);
    }
}
