package pl.sda.userservice;

import java.util.Map;

class UserService {
    private Map<String,Person> users;

    UserService(Map<String, Person> users) {
        this.users = users;
    }

    void add(String login, String firstName, String lastName) {
        users.put("",new Person());
    }
}
