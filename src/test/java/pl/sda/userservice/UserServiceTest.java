package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {

    private static final String LOGIN = "login";
    private static final String FIRST_NAME = "name";
    private static final String LAST_NAME = "last name";

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
        Assert.assertTrue(new Person(FIRST_NAME, LAST_NAME).equals(users.get(LOGIN)));
//        Assert.assertEquals("name",users.get("login").getFirstName());
//        Assert.assertEquals("last name", users.get("login").getLastName());
    }

    @Test
    public void shouldReadReturnCorrectPersonDataForGivenLogin() {
        //given

        Map<String,Person> users = new HashMap<>();
        UserService userService = new UserService(users);
        userService.add("test","test","test");
        userService.add(LOGIN, FIRST_NAME, LAST_NAME);
        userService.add("test2","test2","test2");

        //when
        Person person = userService.read(LOGIN);

        //then
        Assert.assertTrue(new Person(FIRST_NAME,LAST_NAME).equals(person));
    }
}
