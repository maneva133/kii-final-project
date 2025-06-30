package mk.ukim.finki.labb1.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String message) {
        super("already exists");
    }
}
