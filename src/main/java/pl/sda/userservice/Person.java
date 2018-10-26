package pl.sda.userservice;

class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    boolean equals(Person person) {
        return this.firstName.equals(person.firstName) && this.lastName.equals(person.lastName);

    }
}
