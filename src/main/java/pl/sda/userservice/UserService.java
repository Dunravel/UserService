package pl.sda.userservice;

import java.util.Map;

class UserService {
    private Map<String,Person> users;
    private Validator validator;

    UserService(Map<String, Person> users, Validator validator) {
        this.users = users;
        this.validator = validator;

    }

    void add(String login, String name, String lastName) {
        if(validator.loginIsValid(login)) {
            if (users.containsKey(login)) {
                throw new LoginAlreadyExistsException(login);
            }
            users.put(login, new Person(name, lastName));
        }
    }

    Person read(String login) {
        if(!users.containsKey(login)){
            throw new LoginDoesNotExistException(login);
        }
        return users.get(login);
    }

    void update(String login, String firstName, String lastName) {
        if(!users.containsKey(login)){
            throw new LoginDoesNotExistException(login);
        }
        users.put(login,new Person(firstName,lastName));
    }

    void delete(String login) {
        if(!users.containsKey(login)){
            throw new LoginDoesNotExistException(login);
        }
        users.remove(login);
    }
}
