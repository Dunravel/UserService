package pl.sda.userservice;

class LoginDoesNotExistException extends RuntimeException {
    LoginDoesNotExistException(String login) {
    }
}