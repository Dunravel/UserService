package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {

    public static final String LOGIN = "login";
    public static final String FIRST_NAME = "name";
    public static final String LAST_NAME = "last name";

    @Test
    public void shouldAddLogin(){
        //given

        Map<String,Person> users = new HashMap<>();
        UserService userService = new UserService(users);

        //when
        userService.add(LOGIN, FIRST_NAME, LAST_NAME);

        //then
        Assert.assertEquals(1, users.size());
        Assert.assertTrue(users.containsKey("login"));
        Assert.assertTrue(new Person(FIRST_NAME,LAST_NAME).equals(users.get(LOGIN)));
//        Assert.assertEquals("name",users.get("login").getFirstName());
//        Assert.assertEquals("last name", users.get("login").getLastName());
    }

}
