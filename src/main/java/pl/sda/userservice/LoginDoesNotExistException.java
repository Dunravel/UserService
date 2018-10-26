package pl.sda.userservice;

class LoginDoesNotExistException extends RuntimeException {
    LoginDoesNotExistException(String login) {
        super("Login does not exist: " + login);
    }
}
