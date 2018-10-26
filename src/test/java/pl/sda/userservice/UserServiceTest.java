package pl.sda.userservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {

    private static final String LOGIN = "myLogin";
    private static final String FIRST_NAME = "myName";
    private static final String LAST_NAME = "myLast name";
    private Map<String, Person> users;
    private UserService userService;
    private Validator validator;

    @Before
    public void setUp() {

        users = new HashMap<>();
        validator = Mockito.mock(Validator.class);
        userService = new UserService(users,validator);
    }

    private void givenLoginIsValid() {
        BDDMockito.given(validator.loginIsValid(ArgumentMatchers.anyString())).willReturn(true);
    }

    private void givenLoginIsNotValid() {
        BDDMockito.given(validator.loginIsValid(ArgumentMatchers.any())).willReturn(false);
    }

    @Test
    public void shouldAddLogin(){
        //given
        givenLoginIsValid();
        //when
        userService.add(LOGIN, FIRST_NAME, LAST_NAME);

        //then
        Assert.assertEquals(1, users.size());
        Assert.assertTrue(users.containsKey("myLogin"));
        Assert.assertTrue(new Person(FIRST_NAME, LAST_NAME).equals(users.get(LOGIN)));
    }

    @Test
    public void shouldReadReturnCorrectPersonDataForGivenLogin() {
        //given
        givenLoginIsValid();
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
        givenLoginIsValid();
        userService.add(LOGIN,"test","test");

        //when
        userService.update(LOGIN,FIRST_NAME,LAST_NAME);

        //then
        Assert.assertTrue(new Person(FIRST_NAME,LAST_NAME).equals(users.get(LOGIN)));
    }
    //should update name and last name separately? If yes, suggest separate methods for updating name and first name.

    @Test
    public void shouldDeleteRemoveGivenLogin() {
        //given
        givenLoginIsValid();
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);

        //when
        userService.delete(LOGIN);

        //then
        Assert.assertFalse(users.containsKey(LOGIN));
    }

    @Test(expected = LoginAlreadyExistsException.class)
    public void shouldAddThrowExceptionWhenGivenLoginAlreadyExists(){
        //given
        givenLoginIsValid();
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);

        //when
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);
    }

    @Test(expected = LoginDoesNotExistException.class)
    public void shouldReadReturnExceptionWhenLoginDoesNotExists() {
        //given

        //when
        userService.read(LOGIN);
    }

    @Test(expected = LoginDoesNotExistException.class)
    public void shouldDeleteReturnExceptionWhenLoginDoesNotExist() {
        //given

        //when
        userService.delete(LOGIN);
    }

    @Test
    public void shouldAddNotAddGivenLoginWhenNotValid() {
        //given
        givenLoginIsNotValid();

        //when
        userService.add(LOGIN,FIRST_NAME,LAST_NAME);

        //then
        Assert.assertFalse(users.containsKey(LOGIN));
    }
    //should Add return exception when login not valid?


    @Test(expected = LoginDoesNotExistException.class)
    public void shouldUpdateReturnExceptionWhenLoginDoesNotExist() {
        //given

        //when
        userService.update(LOGIN,FIRST_NAME,LAST_NAME);
    }
}
