package az.company.turbo.exception;

public class PhoneAlreadyExistsException extends RuntimeException{

    public PhoneAlreadyExistsException(String message) {
        super(message);
    }
}
