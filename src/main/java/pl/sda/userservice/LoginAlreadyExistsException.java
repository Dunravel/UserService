package pl.sda.userservice;

class LoginAlreadyExistsException extends RuntimeException {

    LoginAlreadyExistsException(String login) {
        super(login);
    }
}
