package pl.sda.userservice;

class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

   // @Override
    public boolean equals(Person obj) {
        if(this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName())) {
            return true;
        }else {
            return false;
        }

    }
}
