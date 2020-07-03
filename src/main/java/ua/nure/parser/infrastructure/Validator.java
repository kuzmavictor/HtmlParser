package ua.nure.parser.infrastructure;

import org.apache.commons.validator.routines.UrlValidator;

public class Validator {

    private static final UrlValidator urlValidator = new UrlValidator();

    public static boolean validateUrl(String url) {
        return urlValidator.isValid(url);
    }
}
