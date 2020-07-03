package ua.nure.parser;

/**
 * This exception is thrown if the input data is invalid.
 */
public class ParserException extends RuntimeException {

    private static final long serialVersionUID = 0L;

    public ParserException(String message) {
        super(message);
    }
}
