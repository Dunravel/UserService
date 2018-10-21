package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {

    @Test
    public void shouldAddLogin(){
        //given
        String login = "login";
        String firstName = "name";
        String lastName = "last name";

        Map<String,Person> users = new HashMap<>();
        UserService userService = new UserService(users);

        //when
        userService.add(login,firstName,lastName);

        //then
        Assert.assertEquals(1, users.size());
    }
}
