package exceptions;

public class InsufficientQuantity extends RuntimeException {
    public InsufficientQuantity(String message) {
        super(message);
    }
}
