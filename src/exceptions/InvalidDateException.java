package exceptions;

public class InvalidDateException extends Exception{

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException() {
        super();
    }
}
