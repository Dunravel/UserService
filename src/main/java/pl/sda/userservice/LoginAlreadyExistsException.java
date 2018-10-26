package pl.sda.userservice;

class LoginAlreadyExistsException extends RuntimeException {

    LoginAlreadyExistsException(String login) {
        super("Login already exists: " + login);
    }
}
