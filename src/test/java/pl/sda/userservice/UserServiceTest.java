package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.LoginContext;
import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {

    private static final String LOGIN = "login";
    private static final String FIRST_NAME = "name";
    private static final String LAST_NAME = "last name";
    private Map<String, Person> users;
    private UserService userService;

    @Before
    public void setUp() {

        users = new HashMap<>();
        userService = new UserService(users);
    }

    @Test
    public void shouldAddLogin(){
        //given

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

        userService.add("test","test","test");
        userService.add(LOGIN, FIRST_NAME, LAST_NAME);
        userService.add("test2","test2","test2");

        //when
        Person person = userService.read(LOGIN);

        //then
        Assert.assertTrue(new Person(FIRST_NAME,LAST_NAME).equals(person));
    }

    @Test
    public void shouldUpdateChangePersonDataForGivenLogin() {
        // given
        userService.add(LOGIN,"test","test");

        //when
        userService.update(LOGIN,FIRST_NAME,LAST_NAME);

        //then
        Assert.assertTrue(new Person(FIRST_NAME,LAST_NAME).equals(users.get(LOGIN)));
    }

    @Test
    public void shouldDeleteRemoveGivenLogin() {
        //given
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);

        //when
        userService.delete(LOGIN);

        //then
        Assert.assertFalse(users.containsKey(LOGIN));
    }

    @Test(expected = LoginAlreadyExistsException.class)
    public void shouldAddThrowExceptionWhenGivenLoginAlreadyExists(){
        //given
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);

        //when
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);
    }
}
