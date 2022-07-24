package az.company.turbo.exception;

public class BrandNameAlreadyExistsException extends RuntimeException{
    public BrandNameAlreadyExistsException(String message) {
        super(message);
    }
}
