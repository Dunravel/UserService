package pl.sda.userservice;

import java.util.Map;

class UserService {
    private Map<String,Person> users;

    UserService(Map<String, Person> users) {
        this.users = users;
    }

    void add(String login, String name, String lastName) {
        users.put(login,new Person(name,lastName));
    }

    Person read(String login) {
        return users.get(login);
    }

    void update(String login, String firstName, String lastName) {
        users.put(login,new Person(firstName,lastName));
    }

    void delete(String login) {
        users.remove(login);
    }
}
