package exceptions;

public class ProductExpired extends RuntimeException {
    public ProductExpired(String message) {
        super(message);
    }
}
