//package exceptions;
/**
 * This exception is thrown when the given input is not valid.
 *
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String s) {
        super(s);
    }
}